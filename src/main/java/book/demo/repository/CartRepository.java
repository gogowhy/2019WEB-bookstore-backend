package book.demo.repository;


import book.demo.entity.Books;
import book.demo.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface CartRepository extends JpaRepository<Cart,Integer> {
   public  Cart findByCartid(Integer cardid);

   public List<Cart> findByUserid(Integer userid);
}
