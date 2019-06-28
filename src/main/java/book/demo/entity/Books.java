package book.demo.entity;
import book.demo.repository.*;
import book.demo.entity.*;
import book.demo.controller.*;
import javax.persistence.*;

@Entity
@Table(name = "bookinfo")

public class Books {
    //自增ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookid;

    @Column(name="isbn")
    private String isbn;

    @Column(name = "bookname")
    private String bookname;

    @Column(name="price")
    private Integer price;

    @Column(name="author")
    private String author;

    @Column(name="repertory")
    private Integer repertory;


    @Column(name="description")
    private String description;


    @Column(name="picture")
    private String picture;

    //需要声明无参数的构造函数
    public Books(){  }
    public Integer getId() {
        return bookid;
    }
    public void setId(Integer id) {
        this.bookid = id;
    }

    public String getName() {
        return bookname;
    }
    public void setName(String name) {
        this.bookname = name;
    }

    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }

   public String getAuthor()
    {
        return author;
    }
  public void setAuthor(String author)
    {
        this.author=author;
    }
    public Integer getRepertory() { return repertory; }
    public void setRepertory(Integer repertory) {
        this.repertory = repertory; }


        public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}