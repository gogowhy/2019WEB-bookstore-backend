package book.demo.dao;

import book.demo.entity.Books;
import book.demo.entity.Order;
import book.demo.entity.OrderItem;
import book.demo.entity.order_out_structure;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
@Repository
public interface OrderDao {


 List<Order> queryAll();
     void add(Integer userid,Integer paid,String ordertime);


     void update(Integer orderid);

     Order getStu( Integer orderid);

    Order getOrd(Integer orderuserid);

    List<order_out_structure> queryorder(HttpServletRequest request);

     List<order_out_structure> querycart(HttpServletRequest request);




    List<order_out_structure> queryallorder(HttpServletRequest request);
    String booksales(HttpServletRequest request) ;
}
