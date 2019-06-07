package book.demo.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Document(collection="bookremark")
public class BookRemark {
    @Id
    public Integer bookremarkid;

    public  String username;
    public String bookname;


    public String bookremark;


    public Integer getBookremarkid() {
        return bookremarkid;
    }

    public void setBookremarkid(Integer bookremarkid) {
        this.bookremarkid = bookremarkid;
    }

    public String getBookremark() {
        return bookremark;
    }

    public void setBookremark(String bookremark) {
        this.bookremark = bookremark;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }
}
