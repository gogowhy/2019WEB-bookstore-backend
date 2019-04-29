package book.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public interface OrderItemRepository  extends JpaRepository<OrderItem,Integer> {

    public List<OrderItem> findByOrderid (Integer orderid);
}
