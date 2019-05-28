package book.demo.service;

import book.demo.entity.Order;
import book.demo.entity.OrderItem;
import book.demo.entity.order_out_structure;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public interface OrderItemService {
    List<OrderItem> queryAll();

    void addorderitem( Integer userid, Integer orderid,
                       Integer bookid,  Integer number);

}
