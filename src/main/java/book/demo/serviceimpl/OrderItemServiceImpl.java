package book.demo.serviceimpl;

import book.demo.dao.OrderDao;
import book.demo.dao.OrderItemDao;
import book.demo.entity.Books;
import book.demo.entity.Order;
import book.demo.entity.OrderItem;
import book.demo.entity.order_out_structure;
import book.demo.repository.BookRepository;
import book.demo.repository.OrderItemRepository;
import book.demo.repository.OrderRepository;
import book.demo.repository.UserRepository;
import book.demo.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
@Service
public class OrderItemServiceImpl implements OrderItemService{
@Autowired
public OrderItemDao orderItemDao;

   @Override
   public  List<OrderItem> queryAll()
    {
        return orderItemDao.queryAll();
    }

@Override
    public void addorderitem( Integer userid, Integer orderid,
                       Integer bookid,  Integer number)
    {
        orderItemDao.addorderitem(userid,orderid,bookid,number);
    }

}
