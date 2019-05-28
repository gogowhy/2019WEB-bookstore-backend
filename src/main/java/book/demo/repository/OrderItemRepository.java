package book.demo.repository;

import book.demo.repository.*;
import book.demo.entity.*;
import book.demo.controller.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

public interface OrderItemRepository  extends JpaRepository<OrderItem,Integer> {

    public List<OrderItem> findByOrderid (Integer orderid);
}
