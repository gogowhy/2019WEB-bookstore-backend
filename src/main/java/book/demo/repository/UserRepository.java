package book.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import book.demo.repository.*;
import book.demo.entity.*;
import book.demo.controller.*;
@Service
public interface UserRepository extends JpaRepository<User,Integer> {

    public User findByUsername(String username);
    public User findByUserid(Integer userid);
}
