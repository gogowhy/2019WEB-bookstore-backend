package book.demo.daoimpl;


import book.demo.dao.BookRemarkDao;
import book.demo.entity.BookRemark;
import book.demo.entity.Books;
import book.demo.repository.BookRemarkRepository;
import book.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRemarkDaoImpl implements BookRemarkDao {

    @Autowired
    private BookRemarkRepository bookRemarkRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<BookRemark> queryAll(){
        List<BookRemark> list = new ArrayList<BookRemark>();
        list = bookRemarkRepository.findAll();
        return list;
    }


    @Override
    public String newbookremark(HttpServletRequest request)
    {
        String remark=request.getParameter("remark");
        ServletContext servletContext=request.getServletContext();
        String username= servletContext.getAttribute("username").toString();
        String bookname= servletContext.getAttribute("bookname").toString();


        BookRemark bookremark =new BookRemark();

        bookremark.setUsername(username);
        bookremark.setBookname(bookname);
        bookremark.setBookremark(remark);

        List<BookRemark> allbookmark=bookRemarkRepository.findAll();
        int maxid=1;
        for(int i=0;i<allbookmark.size();i++)
        {
            if(maxid<=allbookmark.get(i).getBookremarkid())
            {
                maxid = allbookmark.get(i).getBookremarkid() + 1;
            }
        }
        bookremark.setBookremarkid(maxid);
        bookRemarkRepository.save(bookremark);


        return  "已新增书评!" ;
    }


    @Override
    public void deleteAll()
    {
        bookRemarkRepository.deleteAll();
    }


    @Override
    public List<BookRemark> querythebook(HttpServletRequest request)
    {
        ServletContext servletContext=request.getServletContext();
        String bookname= servletContext.getAttribute("bookname").toString();
       List<BookRemark> thisnamebook =bookRemarkRepository.findByBookname(bookname);
       return thisnamebook;
    }
}
