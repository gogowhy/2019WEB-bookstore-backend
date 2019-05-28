package book.demo.controller;
import book.demo.repository.*;
import book.demo.entity.*;
import book.demo.controller.*;
import book.demo.service.UserService;
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
    public UserService userService;

    @RequestMapping("queryAll")
    @ResponseBody
    public List<User> queryAll(){
        return userService.queryAll();
    }



    @RequestMapping("add/{username}/{passw}/{tell}/{state}")
    @ResponseBody
    public void adduser(@PathVariable("username")String username,@PathVariable("passw") String passw,
                        @PathVariable("tell")String tell,@PathVariable("state") Integer state)
    {
        userService.adduser(username,passw,tell,state);
    }

    @RequestMapping("setadmin/{userid}")
    @ResponseBody
    public  void update(@PathVariable("userid")Integer userid){
        userService.update(userid);
    }

    @RequestMapping("delete/{userid}")
    @ResponseBody
    public  void delete(@PathVariable("userid")Integer userid){
       userService.delete(userid);
    }

    @RequestMapping("setforbid/{userid}")
    @ResponseBody
    public  void forbiduser(@PathVariable("userid")Integer userid){
        userService.forbiduser(userid);
    }

    @RequestMapping(value = { "/login" }, method = RequestMethod.POST)
    @ResponseBody
    public String Login(HttpServletRequest request,HttpServletResponse response) {
       return userService.Login(request,response);
    }

    @RequestMapping("checkuser")
    @ResponseBody
    public  Integer checkuser(HttpServletRequest request){
return userService.checkuser(request);
    }


   
    @RequestMapping("test3")
    @ResponseBody
    public List<Order> tryit3(HttpServletRequest request){
return userService.tryit3(request);
    }


    @RequestMapping(value = { "/register" }, method = RequestMethod.POST)
    @ResponseBody
    public String Register(HttpServletRequest request) {
        return userService.Register(request);
    }

    @RequestMapping("userforbid")
    @ResponseBody
    public String userdorbid(HttpServletRequest request)
    {
        return userService.userdorbid(request);
    }
    @RequestMapping("userbanlifting")
    @ResponseBody
    public String userbanlifting(HttpServletRequest request)
    {
       return userService.userbanlifting(request);
    }

}