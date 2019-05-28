package book.demo.service;

import book.demo.entity.Order;
import book.demo.entity.User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
@Service
public interface UserService {
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
