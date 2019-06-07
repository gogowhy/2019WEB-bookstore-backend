package book.demo.daoimpl;

import book.demo.dao.OrderDao;
import book.demo.entity.Books;
import book.demo.entity.Order;
import book.demo.entity.OrderItem;
import book.demo.entity.order_out_structure;
import book.demo.repository.BookRepository;
import book.demo.repository.OrderItemRepository;
import book.demo.repository.OrderRepository;
import book.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao {

    @Autowired
    public OrderRepository orderRepository;
    @Autowired
    public UserRepository userRepository;
    @Autowired
    public OrderItemRepository orderItemRepository;
    @Autowired
    public BookRepository bookRepository;


   @Override
    public List<Order> queryAll(){
        List<Order> list = new ArrayList<Order>();
        list = orderRepository.findAll();
        return list;




    }

    @Override
    public  void add(Integer userid,  Integer paid,
                    String ordertime)
    {
        Order order=new Order();
        order.setUserid(userid);
        order.setPaid(paid);
        order.setOrdertime(ordertime);
        orderRepository.save(order);
    }



    @Override
    public  void update(Integer orderid){
        Order order= orderRepository.findById(orderid).get();
        order.setPaid(1);
        orderRepository.save(order);
    }


    @Override
    public Order getStu( Integer orderid)
    {

        Order order = orderRepository.findById(orderid).get();
        return order;
    }

    @Override
    public Order getOrd(  Integer orderuserid){
        Order order = orderRepository.findById(orderuserid).get();
        return order;
    }



    @Override
    public  List<order_out_structure> queryorder(HttpServletRequest request)
    {
        ServletContext servletContext=request.getServletContext();
        String title = servletContext.getAttribute("username").toString();
        Integer userid=userRepository.findByUsername(title).getUserid();
        List<Order> orders=orderRepository.findByUserid(userid);
        List<Order> middle = new ArrayList<Order>();
        List<order_out_structure> output=new ArrayList<order_out_structure>();
        for(Integer i=0;i<orders.size();i++)
        {

            if(orders.get(i).paid==1)
                middle.add(orders.get(i));
        }//middle里面存储的是所有paid的订单状态的order
        for(Integer i=0;i<middle.size();i++)
        {
            //String ordertime=middle.get(i).ordertime;
            // Integer orderid =middle.get(i).orderid;
            List<OrderItem> orderItems =orderItemRepository.findByOrderid(middle.get(i).orderid);
            //找到当前orderid对应的orderitem的集合
            for(Integer j=0;j<orderItems.size();j++)
            {
                String ordertime=middle.get(i).ordertime;
                Integer orderid =middle.get(i).orderid;
                Books book =new Books();
                book=bookRepository.findByBookid(orderItems.get(j).bookid);
                String bookname=book.getName();
                Integer number =orderItems.get(j).number;
                Integer oneprice=book.getPrice();
                Integer price =number*oneprice;
                order_out_structure the_temp_out= new order_out_structure();
                the_temp_out.orderid=orderid;
                the_temp_out.bookname=bookname;
                the_temp_out.ordertime=ordertime;
                the_temp_out.number=number;
                the_temp_out.price=price;
                output.add(the_temp_out);
            }

        }

        return output;



    }

    @Override
    public  List<order_out_structure> querycart(HttpServletRequest request)
    {
        ServletContext servletContext=request.getServletContext();
        String title = servletContext.getAttribute("username").toString();
        Integer userid=userRepository.findByUsername(title).getUserid();
        List<Order> orders=orderRepository.findByUserid(userid);
        List<Order> middle = new ArrayList<Order>();
        List<order_out_structure> output=new ArrayList<order_out_structure>();
        for(Integer i=0;i<orders.size();i++)
        {

            if(orders.get(i).paid==0)
                middle.add(orders.get(i));
        }//middle里面存储的是所有paid的订单状态的order
        for(Integer i=0;i<middle.size();i++)
        {

            //String ordertime=middle.get(i).ordertime;
            // Integer orderid =middle.get(i).orderid;
            List<OrderItem> orderItems =orderItemRepository.findByOrderid(middle.get(i).orderid);
            //找到当前orderid对应的orderitem的集合
            for(Integer j=0;j<orderItems.size();j++)
            {
                String ordertime=middle.get(i).ordertime;
                Integer orderid =middle.get(i).orderid;

                Books book =new Books();
                book=bookRepository.findByBookid(orderItems.get(j).bookid);
                String bookname=book.getName();
                Integer number =orderItems.get(j).number;
                Integer oneprice=book.getPrice();
                Integer price =number*oneprice;
                order_out_structure the_temp_out= new order_out_structure();
                the_temp_out.orderid=orderid;
                the_temp_out.bookname=bookname;
                the_temp_out.ordertime=ordertime;
                the_temp_out.number=number;
                the_temp_out.price=price;
                output.add(the_temp_out);
            }

        }

        return output;



    }



    @Override
    public  List<order_out_structure> queryallorder(HttpServletRequest request)
    {

        List<Order> orders=orderRepository.findAll();
        List<Order> middle = new ArrayList<Order>();
        List<order_out_structure> output=new ArrayList<order_out_structure>();
        for(Integer i=0;i<orders.size();i++)
        {

            if(orders.get(i).paid==1)
                middle.add(orders.get(i));
        }//middle里面存储的是所有paid的订单状态的order
        for(Integer i=0;i<middle.size();i++)
        {
            //String ordertime=middle.get(i).ordertime;
            // Integer orderid =middle.get(i).orderid;
            List<OrderItem> orderItems =orderItemRepository.findByOrderid(middle.get(i).orderid);
            //找到当前orderid对应的orderitem的集合
            for(Integer j=0;j<orderItems.size();j++)
            {
                String ordertime=middle.get(i).ordertime;
                Integer orderid =middle.get(i).orderid;
                Integer the_userid=middle.get(i).userid;
                Books book =new Books();
                book=bookRepository.findByBookid(orderItems.get(j).bookid);
                String bookname=book.getName();
                Integer number =orderItems.get(j).number;
                Integer oneprice=book.getPrice();
                Integer price =number*oneprice;
                order_out_structure the_temp_out= new order_out_structure();
                the_temp_out.orderid=orderid;
                the_temp_out.bookname=bookname;
                the_temp_out.price=price;
                the_temp_out.ordertime=ordertime;
                the_temp_out.number=number;

                the_temp_out.userid=the_userid;
                output.add(the_temp_out);
            }

        }

        return output;

    }

    @Override
    public String booksales(HttpServletRequest request) {
        String the_bookname=request.getParameter("bookname");

        List<Order> orders=orderRepository.findAll();
        List<Order> middle = new ArrayList<Order>();
        List<order_out_structure> output=new ArrayList<order_out_structure>();
        for(Integer i=0;i<orders.size();i++)
        {

            if(orders.get(i).paid==1)
                middle.add(orders.get(i));
        }//middle里面存储的是所有paid的订单状态的order
        for(Integer i=0;i<middle.size();i++)
        {

            List<OrderItem> orderItems =orderItemRepository.findByOrderid(middle.get(i).orderid);
            //找到当前orderid对应的orderitem的集合
            for(Integer j=0;j<orderItems.size();j++)
            {
                String ordertime=middle.get(i).ordertime;
                Integer orderid =middle.get(i).orderid;
                Integer the_userid=middle.get(i).userid;
                Books book =new Books();
                book=bookRepository.findByBookid(orderItems.get(j).bookid);
                String bookname=book.getName();
                Integer number =orderItems.get(j).number;
                Integer oneprice=book.getPrice();
                Integer price =number*oneprice;
                order_out_structure the_temp_out= new order_out_structure();
                the_temp_out.orderid=orderid;
                the_temp_out.bookname=bookname;
                the_temp_out.price=price;
                the_temp_out.ordertime=ordertime;
                the_temp_out.number=number;

                the_temp_out.userid=the_userid;
                output.add(the_temp_out);
            }

        }

        Integer sum=0;
        for(Integer q=0;q<output.size();q++)
        {
            String name=output.get(q).bookname;
            Integer num=output.get(q).number;

            if(name.contains(the_bookname)) {
                sum += num;
            }
        }

        return "书籍" + the_bookname + "的销量为" +sum;
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