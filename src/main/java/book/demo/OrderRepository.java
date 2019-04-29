package book.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface OrderRepository extends JpaRepository<Order,Integer> {

    public List<Order> findByUserid(Integer userid);
    public Order findByOrderid(Integer orderid);
}

