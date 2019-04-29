package book.demo;

import org.hibernate.annotations.Subselect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Books,Integer> {


public Books findByBookname (String bookname);
public Books findByBookid(Integer bookid);

}
