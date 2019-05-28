package book.demo.daoimpl;

import book.demo.dao.OrderItemDao;
import book.demo.entity.OrderItem;
import book.demo.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderItemDaoImpl implements OrderItemDao {


    @Autowired
    private OrderItemRepository orderItemRepository;


    @Override
    public List<OrderItem> queryAll(){
        List<OrderItem> list = new ArrayList<OrderItem>();
        list =orderItemRepository.findAll();
        return list;
    }

   @Override
    public void addorderitem( Integer userid,  Integer orderid,
                            Integer bookid, Integer number)
    {
        OrderItem orderitem =new OrderItem();
        orderitem.setUserid(userid);
        orderitem.setOrderid(orderid);
        orderitem.setBookid(bookid);
        orderitem.setNumber(number);
        orderItemRepository.save(orderitem);
    }
}
