package book.demo.dao;
import java.util.List;
import book.demo.entity.BookRemark;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpServletRequest;
@Repository
public interface BookRemarkDao {

    List <BookRemark> queryAll();
    String newbookremark(HttpServletRequest request);
     void deleteAll();
     List<BookRemark> querythebook(HttpServletRequest request);
}
