package book.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController{

    @Autowired
    private BookRepository bookRepository;
    //private static int cnt = 0;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @RequestMapping("queryAll")
    @ResponseBody
    public List<Books> queryAll(){
        List<Books> list = new ArrayList<Books>();
        list = bookRepository.findAll();
        return list;
    }

    @RequestMapping("add/{isbn}/{name}/{price}/{author}/{repertory}/{description}")
    @ResponseBody
    public  void add(@PathVariable("isbn") String isbn, @PathVariable("name")String name ,
                     @PathVariable("price") Integer price,@PathVariable("author")String author,
                     @PathVariable("repertory") Integer repertory,@PathVariable("description") String description){
        Books book = new Books();
        book.setIsbn(isbn);
        book.setName(name);
        book.setPrice(price);
        book.setAuthor(author);
        book.setRepertory(repertory);
        book.setDescription(description);
        bookRepository.save(book);
    }

    @RequestMapping("update/{bookid}/sell")
    @ResponseBody
    public  void update(@PathVariable("bookid")Integer id){
        Books book = bookRepository.findById(id).get();

        Integer n=book.getRepertory();
        book.setRepertory(n-1);

        bookRepository.save(book);
    }

    @RequestMapping("addtocart")
    @ResponseBody
    public String addtocart(HttpServletRequest request)
    {
        String bookname =request.getParameter("bookname");
        String thenumber=request.getParameter("number");
        Integer number=Integer.valueOf(thenumber);
        Order neworder=new Order();
        Books book=bookRepository.findByBookname(bookname);
        neworder.setPaid(0);
        neworder.setOrdertime("today");


        ServletContext servletContext=request.getServletContext();
        String title = servletContext.getAttribute("username").toString();
        Integer userid=userRepository.findByUsername(title).getUserid();
        neworder.setUserid(userid);

        orderRepository.save(neworder);
        Integer orderid=neworder.getOrderid();

        OrderItem orderItem =new OrderItem();
        Integer bookid =book.getId();
        orderItem.setNumber(number);
        orderItem.setBookid(bookid);
        orderItem.setOrderid(orderid);
        orderItem.setUserid(userid);


        orderItemRepository.save(orderItem);
       return"添加成功！";
    }

    @RequestMapping("checknow")
    @ResponseBody
    public String checknow(HttpServletRequest request)
    {
        String theorderid=request.getParameter("orderid");
        Integer orderid=Integer.valueOf(theorderid);
        Order order=orderRepository.findByOrderid(orderid);
        List<OrderItem> orderItems =orderItemRepository.findByOrderid(orderid);
        for(Integer i=0;i<orderItems.size();i++)
        {
            Books book =bookRepository.findByBookid(orderItems.get(i).getBookid());
            Integer number=orderItems.get(i).getNumber();
            Integer repertory=book.getRepertory()-number;
            book.setRepertory(repertory);
            bookRepository.save(book);
        }
        order.setPaid(1);

        orderRepository.save(order);
        return"结账成功！！！";

    }


    @RequestMapping("bookdelete")
    @ResponseBody
    public String bookdelete(HttpServletRequest request)
    {
        String bookname=request.getParameter("bookname");
        Books book=bookRepository.findByBookname(bookname);
        bookRepository.delete(book);
        return "已删除"+bookname;
    }


    @RequestMapping("booknumber")
    @ResponseBody
    public String booknumber(HttpServletRequest request)
    {
        String bookname=request.getParameter("bookname");
        String repertory_toset=request.getParameter("booknumber");
        Integer number=Integer.valueOf(repertory_toset);
        Books book=bookRepository.findByBookname(bookname);
        book.setRepertory(number);
        bookRepository.save(book);
        return  "已设置"+bookname+"的库存为"+number+"!" ;
    }

    @RequestMapping("bookadd")
    @ResponseBody
    public String bookadd(HttpServletRequest request)
    {
        String isbn=request.getParameter("isbn");
        String name=request.getParameter("bookname");
        String price=request.getParameter("price");
        String author=request.getParameter("author");
        String repertory=request.getParameter("repertory");
        String description=request.getParameter("description");

        Integer price_number=Integer.valueOf(price);
        Integer repertory_number=Integer.valueOf(repertory);

        Books book =new Books();
        book.setIsbn(isbn);
        book.setName(name);
        book.setPrice(price_number);
        book.setAuthor(author);
        book.setRepertory(repertory_number);
        book.setDescription(description);

        bookRepository.save(book);
        return  "已新增图书"+name+"!" ;
    }





}
