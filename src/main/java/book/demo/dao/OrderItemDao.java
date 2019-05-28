package book.demo.dao;


import book.demo.entity.OrderItem;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
@Repository
public interface OrderItemDao {

    List<OrderItem> queryAll();

   void addorderitem( Integer userid, Integer orderid,
                             Integer bookid,  Integer number);


}
