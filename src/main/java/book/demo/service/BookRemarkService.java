package book.demo.service;

import book.demo.entity.BookRemark;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@Service
public interface BookRemarkService {


    List<BookRemark> queryAll();
    String newbookremark(HttpServletRequest request);
    void deleteAll();
    List<BookRemark> querythebook(HttpServletRequest request);
}
