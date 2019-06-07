package book.demo.serviceimpl;

import book.demo.dao.BookDao;
import book.demo.dao.BookRemarkDao;
import book.demo.entity.BookRemark;
import book.demo.service.BookRemarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class BookRemarkServiceImpl implements BookRemarkService {
    @Autowired
    public BookRemarkDao bookRemarkDao;


    @Override
    public List<BookRemark> queryAll()
    {
        return bookRemarkDao.queryAll();
    }


    @Override
    public String newbookremark(HttpServletRequest request)
    {
       return  bookRemarkDao.newbookremark(request);
    }

    @Override
    public void deleteAll()
    {
       bookRemarkDao.deleteAll();
    }


    @Override
    public List<BookRemark> querythebook(HttpServletRequest request)
    {
       return  bookRemarkDao.querythebook(request);
    }
}
