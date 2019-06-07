package book.demo.repository;

import book.demo.entity.BookRemark;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRemarkRepository extends MongoRepository<BookRemark,Integer> {

    public BookRemark findByBookremarkid(Integer id);
public List<BookRemark> findByBookname(String bookname);
}
