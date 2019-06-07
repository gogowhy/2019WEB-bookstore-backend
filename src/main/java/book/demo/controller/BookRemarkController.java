package book.demo.controller;


import book.demo.entity.BookRemark;
import book.demo.entity.Books;
import book.demo.service.BookRemarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/bookremark")
public class BookRemarkController {
    @Autowired
    private BookRemarkService bookRemarkService;


    @RequestMapping("queryAll")
    @ResponseBody
    public List<BookRemark> queryAll(){
        return bookRemarkService.queryAll();
    }



    @RequestMapping("newbookremark")
    @ResponseBody
    public String newbookremark(HttpServletRequest request)
    {
       return  bookRemarkService.newbookremark(request);
    }

    @RequestMapping("deleteAll")
    @ResponseBody
    public void deleteAll()
    {
         bookRemarkService.deleteAll();
    }

    @RequestMapping("querythebook")
    @ResponseBody
    public List<BookRemark> querythebook(HttpServletRequest request)
    {
        return bookRemarkService.querythebook(request);
    }
}
