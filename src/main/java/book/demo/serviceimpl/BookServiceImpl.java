package book.demo.serviceimpl;


import book.demo.repository.*;
import book.demo.entity.*;
import book.demo.controller.*;
import book.demo.dao.*;
import book.demo.daoimpl.*;
import book.demo.service.*;
import book.demo.serviceimpl.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

import java.util.Date;
import java.text.SimpleDateFormat;


@Service
public class BookServiceImpl implements BookService {

@Autowired
    public BookDao bookDao;

            @Override
    public List<Books> queryAll()
{
    return bookDao.queryAll()      ;

}

            @Override
    public  void add( String isbn,String name ,
                     Integer price,String author,
                    Integer repertory,String description) {
    bookDao.add( isbn,  name,price,author,repertory, description)     ;

}
              @Override
    public  void update(Integer id)
    {
         bookDao.update(id);
    }

             @Override
    public String addtocart(HttpServletRequest request)
    {
             return bookDao.addtocart(request);
    }
              @Override
    public String checknow(HttpServletRequest request)
     {
        return bookDao.checknow(request);
     }


              @Override
    public String checkall (HttpServletRequest request)
     {
         return bookDao.checkall(request);
     }

              @Override
    public String bookdelete(HttpServletRequest request)
    {
        return bookDao.bookdelete(request);
    }
          @Override
    public String booknumber(HttpServletRequest request)
     {
         return bookDao.booknumber(request);
     }

            @Override
    public String bookdescription(HttpServletRequest request)
     {
         return  bookDao.bookdescription(request);
     }


            @Override
    public String bookadd(HttpServletRequest request)
     {
         return bookDao.bookadd(request);
     }

             @Override
    public void setbookdetail(HttpServletRequest request)
     {
          bookDao.setbookdetail(request);
     }

            @Override
    public List<Books> querydetail(HttpServletRequest request)
     {
         return bookDao.querydetail(request);
     }


}
