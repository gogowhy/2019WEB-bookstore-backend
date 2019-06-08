package book.demo.serviceimpl;

import book.demo.dao.OrderDao;
import book.demo.entity.Order;
import book.demo.entity.order_out_structure;
import book.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    public OrderDao orderDao;


    @Override
    public List<Order> queryAll(){
        return orderDao.queryAll();

    }

    @Override
    public  void add(Integer userid, Integer paid,
                     String ordertime)
    {
        orderDao.add(userid,paid,ordertime);
    }


    @Override
    public  void update(Integer orderid){
        orderDao.update(orderid);
    }


    @Override
    public Order getStu(  Integer orderid)
    {
        return orderDao.getStu(orderid);
    }

    @Override
    public Order getOrd( Integer orderuserid){
        return orderDao.getOrd(orderuserid);
    }



    @Override
    public  List<order_out_structure> queryorder(HttpServletRequest request)
    {
        return orderDao.queryorder(request);
    }

    @Override
    public  List<order_out_structure> querycart(HttpServletRequest request)
    {
        return orderDao.querycart(request);

    }


    @Override
    public  List<order_out_structure> queryallorder(HttpServletRequest request)
    {
        return orderDao.queryallorder(request);
    }

    @Override
    public String booksales(HttpServletRequest request) {
        return orderDao.booksales(request);
    }

    @Override
    public String timesalesall(HttpServletRequest request)
    {
        return orderDao.timesalesall(request);
    }


    @Override
    public  String allbooksalestimes(HttpServletRequest request)
    {
        return  orderDao.allbooksalestimes(request);
    }

    @Override
    public  String custimebuy(HttpServletRequest request)
    {
        return orderDao.custimebuy(request);
    }

}
