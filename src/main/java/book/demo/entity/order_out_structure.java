package book.demo.entity;
import book.demo.repository.*;
import book.demo.entity.*;
import book.demo.controller.*;

import javax.persistence.*;
import java.io.Serializable;

public class order_out_structure {

    public Integer userid;
    public Integer orderid;
    public Integer price;
    public String bookname;
    public String ordertime;
    public Integer number;
}
