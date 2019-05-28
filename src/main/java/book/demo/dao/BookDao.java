package book.demo.dao;


import book.demo.repository.*;
import book.demo.entity.*;
import book.demo.controller.*;
import book.demo.dao.*;
import book.demo.daoimpl.*;
import book.demo.service.*;
import book.demo.serviceimpl.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

import java.util.Date;
import java.text.SimpleDateFormat;

@Repository
public interface BookDao {

   List<Books> queryAll();
    void add(String isbn,String name ,Integer price,String author,
                    Integer repertory,String description);
     void update(Integer id);
   String addtocart(HttpServletRequest request);
  String checknow(HttpServletRequest request);
     String checkall (HttpServletRequest request);
    String bookdelete(HttpServletRequest request);
     String booknumber(HttpServletRequest request);
    String bookdescription(HttpServletRequest request);
    String bookadd(HttpServletRequest request);
  void setbookdetail(HttpServletRequest request);
 List<Books> querydetail(HttpServletRequest request);


}
