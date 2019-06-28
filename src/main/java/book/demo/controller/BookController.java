package book.demo.controller;


import book.demo.repository.*;
import book.demo.entity.*;
import book.demo.controller.*;


import book.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

import java.util.Date;
import java.text.SimpleDateFormat;
@RestController
@RequestMapping("/books")
public class BookController{

    @Autowired
    private BookService bookService;


    @RequestMapping("queryAll")
    @ResponseBody
    public List<Books> queryAll(){
       return bookService.queryAll();
    }

    @RequestMapping("add/{isbn}/{name}/{price}/{author}/{repertory}/{description}")
    @ResponseBody
    public  void add(@PathVariable("isbn") String isbn, @PathVariable("name")String name ,
                     @PathVariable("price") Integer price,@PathVariable("author")String author,
                     @PathVariable("repertory") Integer repertory,@PathVariable("description") String description){
         bookService.add(isbn,name,price,author,repertory,description);
    }

    @RequestMapping("update/{bookid}/sell")
    @ResponseBody
    public  void update(@PathVariable("bookid")Integer id){
        bookService.update(id);
    }

    @RequestMapping("addtocart")
    @ResponseBody
    public String addtocart(HttpServletRequest request)
    {
        return bookService.addtocart(request);
    }


    @RequestMapping("numberbuy")
    @ResponseBody
    public String numberbuy(HttpServletRequest request)
    {
        return bookService.numberbuy(request);
    }

    @RequestMapping("checknow")
    @ResponseBody
    public String checknow(HttpServletRequest request)
    {
       return bookService.checknow(request);

    }

    @RequestMapping("checkall")
    @ResponseBody
    public String checkall (HttpServletRequest request)
    {
       return bookService.checkall(request);
    }


    @RequestMapping("bookdelete")
    @ResponseBody
    public String bookdelete(HttpServletRequest request)
    {
        return bookService.bookdelete(request);
    }


    @RequestMapping("booknumber")
    @ResponseBody
    public String booknumber(HttpServletRequest request)
    {
        return bookService.booknumber(request);
    }

    @RequestMapping("bookdescription")
    @ResponseBody
    public String bookdescription(HttpServletRequest request)
    {
       return  bookService.bookdescription(request);
    }

    @RequestMapping("bookadd")
    @ResponseBody
    public String bookadd(HttpServletRequest request)
    {
        return bookService.bookadd(request);
    }


    @RequestMapping("setbookdetail")
    @ResponseBody
    public void setbookdetail(HttpServletRequest request)
    {
         bookService.setbookdetail(request);
    }


    @RequestMapping("setbookdetailbyisbn")
    @ResponseBody
    public void setbookdetailbyisbn(HttpServletRequest request)
    {
        bookService.setbookdetailbyisbn(request);
    }


    @RequestMapping("querydetail")
    @ResponseBody
    public List<Books> querydetail(HttpServletRequest request)
    {
       return bookService.querydetail(request);
    }


    @RequestMapping("setpicture/{bookid}/{picture}")
    @ResponseBody
    public void setpicture(@PathVariable("bookid")Integer id,@PathVariable("picture") String picture)
    {
         bookService.setpicture(id,picture);
    }

    @RequestMapping("querythebookpicture")
    @ResponseBody
    public String querythebookpicture(HttpServletRequest request)
    {
        return bookService.querythebookpicture(request);
    }
}
