package book.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orderitem")
public class OrderItemController
{

    @Autowired
    private OrderItemRepository orderItemRepository;


    @RequestMapping("queryAll")
    @ResponseBody
    public List<OrderItem> queryAll(){
        List<OrderItem> list = new ArrayList<OrderItem>();
        list =orderItemRepository.findAll();
        return list;
    }

    @RequestMapping("add/{userid}/{orderid}/{bookid}/{number}")
    @ResponseBody
    public void addorderitem(@PathVariable("userid") Integer userid,@PathVariable("orderid") Integer orderid,
                             @PathVariable("bookid") Integer bookid,@PathVariable("number") Integer number)
    {
        OrderItem orderitem =new OrderItem();
        orderitem.setUserid(userid);
        orderitem.setOrderid(orderid);
        orderitem.setBookid(bookid);
        orderitem.setNumber(number);
        orderItemRepository.save(orderitem);
    }



}
