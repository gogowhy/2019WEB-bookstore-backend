package book.demo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
@Service
public interface UserRepository extends JpaRepository<User,Integer> {

    public User findByUsername(String username);
    public User findByUserid(Integer userid);
}
