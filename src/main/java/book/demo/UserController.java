package book.demo;

import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.print.DocFlavor;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
@RestController
@RequestMapping("/user")

public class UserController{
    @Autowired
    public UserRepository userRepository;
    @Autowired
    public OrderRepository orderRepository;
    //private static int cnt = 0;

    @RequestMapping("queryAll")
    @ResponseBody
    public List<User> queryAll(){
        List<User> list = new ArrayList<User>();
        list = userRepository.findAll();
        return list;
    }



    @RequestMapping("add/{username}/{passw}/{tell}/{state}")
    @ResponseBody
    public void adduser(@PathVariable("username")String username,@PathVariable("passw") String passw,
                        @PathVariable("tell")String tell,@PathVariable("state") Integer state)
    {
        User user=new User();
        user.setUsername(username);
        user.setPassword(passw);
        user.setTell(tell);
        user.setState(state);
        userRepository.save(user);
    }

    @RequestMapping("setadmin/{userid}")
    @ResponseBody
    public  void update(@PathVariable("userid")Integer userid){
        User user = userRepository.findById(userid).get();

        user.setState(1);
        userRepository.save(user);
    }

    @RequestMapping("delete/{userid}")
    @ResponseBody
    public  void delete(@PathVariable("userid")Integer userid){
        User user = userRepository.findById(userid).get();


        userRepository.delete(user);
    }

    @RequestMapping("setforbid/{userid}")
    @ResponseBody
    public  void forbiduser(@PathVariable("userid")Integer userid){
        User user = userRepository.findById(userid).get();
        user.setState(2);
        userRepository.save(user);
    }

    @RequestMapping(value = { "/login" }, method = RequestMethod.POST)
    @ResponseBody
    public String Login(HttpServletRequest request,HttpServletResponse response) {
        String username = request.getParameter("username");
        String pwd = request.getParameter("userpwd");
        User user=userRepository.findByUsername(username);
        Integer state =user.getState();
        if(state==0) {
            String passreal = user.getPassword();
            if (username == null || username.isEmpty()) {
                return "帐号为空";
            }
            if (pwd == null || pwd.isEmpty()) {
                return "密码为空";
            }
            if (pwd.equals(passreal)) {
                ServletContext servletContext = request.getServletContext();
                servletContext.setAttribute("username", username);
                //HttpSession session=request.getSession(true);
                //session.setMaxInactiveInterval(30*60);
                //session.setAttribute("username", "hi");
                //session.setAttribute("password",pwd);
                //User user1=(User)session.getAttribute("username");
                //System.out.println(user1.getUsername());

                return "登录成功！" + username + "欢迎！！！";
            } else {
                return "帐号或密码错误";

            }
        }
        if(state==2)
        {
            ServletContext servletContext = request.getServletContext();
            servletContext.setAttribute("username", username);
            return"对不起，您已经被禁用，请联系管理员了解详情！";
        }
        else
        {
            String passreal = user.getPassword();
            if (username == null || username.isEmpty()) {
                return "帐号为空";
            }
            if (pwd == null || pwd.isEmpty()) {
                return "密码为空";
            }
            if (pwd.equals(passreal)) {
                ServletContext servletContext = request.getServletContext();
                servletContext.setAttribute("username", username);
                //HttpSession session=request.getSession(true);
                //session.setMaxInactiveInterval(30*60);
                //session.setAttribute("username", "hi");
                //session.setAttribute("password",pwd);
                //User user1=(User)session.getAttribute("username");
                //System.out.println(user1.getUsername());

                return "管理员登录成功！" + username + "欢迎！！！";
            }
           else return "密码或用户名错误"  ;
        }

    }

    @RequestMapping("checkuser")
    @ResponseBody
    public  Integer checkuser(HttpServletRequest request){

        ServletContext servletContext=request.getServletContext();
        String title = servletContext.getAttribute("username").toString();
        Integer state=userRepository.findByUsername(title).getState();
        return state;
    }


   
    @RequestMapping("test3")
    @ResponseBody
    public List<Order> tryit3(HttpServletRequest request){

       List<Order> order =orderRepository.findByUserid(1);
        return order;
    }


    @RequestMapping(value = { "/register" }, method = RequestMethod.POST)
    @ResponseBody
    public String Register(HttpServletRequest request) {
        String username = request.getParameter("username");
        String pwd = request.getParameter("userpwd");
        String tell=request.getParameter("tell");
        User user=new User();
        user.setUsername(username);
        user.setPassword(pwd);
        user.setTell(tell);
        user.setState(0);
        userRepository.save(user);
        return "欢迎您，注册成功"+username+"!";

    }

    @RequestMapping("userforbid")
    @ResponseBody
    public String userdorbid(HttpServletRequest request)
    {
        String id=request.getParameter("userid");
        Integer userid_num=Integer.valueOf(id);
        User user= userRepository.findByUserid(userid_num);
        user.setState(2);
        userRepository.save(user);
        return"已经禁止用户"+user.getUsername()+"!";
    }
    @RequestMapping("userbanlifting")
    @ResponseBody
    public String userbanlifting(HttpServletRequest request)
    {
        String id=request.getParameter("userid");
        Integer userid_num=Integer.valueOf(id);
        User user= userRepository.findByUserid(userid_num);
        user.setState(0);
        userRepository.save(user);
        return"已经解禁用户"+user.getUsername()+"!";
    }

}