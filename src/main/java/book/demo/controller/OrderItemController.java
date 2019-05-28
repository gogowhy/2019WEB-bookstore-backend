package book.demo.controller;
import book.demo.repository.*;
import book.demo.entity.*;
import book.demo.controller.*;
import book.demo.service.OrderItemService;
import book.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orderitem")
public class OrderItemController
{

    @Autowired
    private OrderItemService orderItemService;


    @RequestMapping("queryAll")
    @ResponseBody
    public List<OrderItem> queryAll(){
        return orderItemService.queryAll();
    }

    @RequestMapping("add/{userid}/{orderid}/{bookid}/{number}")
    @ResponseBody
    public void addorderitem(@PathVariable("userid") Integer userid,@PathVariable("orderid") Integer orderid,
                             @PathVariable("bookid") Integer bookid,@PathVariable("number") Integer number)
    {
        orderItemService.addorderitem(userid,orderid,bookid,number);
    }



}
