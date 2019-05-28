package book.demo.dao;

import book.demo.entity.Order;
import book.demo.entity.User;
import book.demo.repository.OrderRepository;
import book.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface UserDao {
   List<User> queryAll();


  void adduser(String username,  String passw,
                        String tell, Integer state);
    void update(Integer userid);
    void delete(Integer userid);
    void forbiduser(Integer userid);

   String Login(HttpServletRequest request, HttpServletResponse response) ;

     Integer checkuser(HttpServletRequest request);

 List<Order> tryit3(HttpServletRequest request);

    String Register(HttpServletRequest request);

    String userdorbid(HttpServletRequest request);


    String userbanlifting(HttpServletRequest request);
}
