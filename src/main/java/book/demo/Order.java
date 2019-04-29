package book.demo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "orderinfo")


public  class  Order implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer orderid;


    @Column (name="userid")
    public Integer userid;


    @Column(name="paid")
    public Integer paid;


    @Column(name = "ordertime")
    public String ordertime;

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getPaid() {
        return paid;
    }

    public void setPaid(Integer paid) {
        this.paid = paid;
    }

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime;
    }
}