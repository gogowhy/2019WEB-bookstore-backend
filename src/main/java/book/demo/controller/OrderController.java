package book.demo.controller;
import book.demo.repository.*;
import book.demo.entity.*;
import book.demo.controller.*;
import book.demo.service.OrderService;
import javafx.geometry.InsetsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order")

public class OrderController
{

    @Autowired
    private OrderService orderService;


    @RequestMapping("queryAll")
    @ResponseBody
    public List<Order> queryAll(){
       return orderService.queryAll();


    }

    @RequestMapping("add/{userid}/{paid}/{ordertime}")
    @ResponseBody
    public  void add(@PathVariable("userid")Integer userid,@PathVariable("paid") Integer paid,
                     @PathVariable("ordertime" )String ordertime)
    {
         orderService.add(userid,paid,ordertime);
    }



    @RequestMapping("paid/{orderid}")
    @ResponseBody
    public  void update(@PathVariable("orderid") Integer orderid){
         orderService.update(orderid);
    }


    @RequestMapping(value = "/findorderid/{orderid}")
    public Order getStu( @PathVariable("orderid") Integer orderid)
    {
  return orderService.getStu(orderid);
    }

    @RequestMapping(value = "/findorderuserid/{orderuserid}")
    public Order getOrd( @PathVariable("orderuserid") Integer orderuserid){
        return orderService.getOrd(orderuserid);
    }



    @RequestMapping("/queryorder")
    @ResponseBody
    public  List<order_out_structure> queryorder(HttpServletRequest request)
    {
        return orderService.queryorder(request);


    }

    @RequestMapping("/querycart")
    @ResponseBody
    public  List<order_out_structure> querycart(HttpServletRequest request)
    {
       return orderService.querycart(request);

    }



    @RequestMapping("/query_all_order")
    @ResponseBody
    public  List<order_out_structure> queryallorder(HttpServletRequest request)
    {

       return orderService.queryallorder(request);

    }

@RequestMapping("booksales")
@ResponseBody
    public String booksales(HttpServletRequest request) {
    return orderService.booksales(request);
}

    /*public  List<order_out_structure> querycart(HttpServletRequest request)
    {
        ServletContext servletContext=request.getServletContext();
        String title = servletContext.getAttribute("username").toString();
        Integer userid=userRepository.findByUsername(title).getUserid();
        List<Order> orders=orderRepository.findByUserid(userid);
        List<Order> middle = new ArrayList<Order>();
        List<order_out_structure> output=new ArrayList<order_out_structure>();
        List<OrderItem> orderItems =new ArrayList<OrderItem>();
        order_out_structure the_temp_out= new order_out_structure();
        Order temp_order= new Order();
        OrderItem temp_orderitem=new OrderItem();
        Books book =new Books();
        for(Integer i=0;i<orders.size();i++)
        {

            if(orders.get(i).paid==0)
                middle.add(orders.get(i));
        }
        for(Integer i=0;i<middle.size();i++)
        {
            temp_order=middle.get(i);
            the_temp_out.orderid=temp_order.orderid;
            the_temp_out.ordertime=temp_order.ordertime;
            orderItems=orderItemRepository.findByOrderid(temp_order.orderid);
            for(Integer j=0;j<orderItems.size();j++)
            {
                temp_orderitem=orderItems.get(j);
                the_temp_out.number=temp_orderitem.number;
                book=bookRepository.findByBookid(temp_orderitem.bookid);
                the_temp_out.bookname=book.getName();
                the_temp_out.price=the_temp_out.number*book.getPrice();
                output.add(the_temp_out);

            }
        }

        return output;
    }*///浅拷贝 无法使用


}