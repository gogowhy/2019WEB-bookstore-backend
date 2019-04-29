package book.demo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "userinfo")

public class User implements Serializable {
    //自增ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer userid;



    @Column(name="username")
    private String username;


    @Column(name = "password")
    private String password;

   @Column(name="tell")
    private String tell;

   @Column(name="state")
    private Integer state;
//state=0,则是普通user，state=1，则是管理员，state=2，则是被禁止的user


    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTell() {
        return tell;
    }

    public void setTell(String tell) {
        this.tell = tell;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}