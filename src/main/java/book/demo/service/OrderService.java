package book.demo.service;

import book.demo.repository.*;
import book.demo.entity.*;
import book.demo.controller.*;
import book.demo.dao.*;
import book.demo.daoimpl.*;
import book.demo.service.*;
import book.demo.serviceimpl.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

import java.util.Date;
import java.text.SimpleDateFormat;;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@Service
public interface OrderService {
    List<Order> queryAll();
    void add(Integer userid,Integer paid,String ordertime);


    void update(Integer orderid);

    Order getStu(Integer orderid);

    Order getOrd(Integer orderuserid);

    List<order_out_structure> queryorder(HttpServletRequest request);

    List<order_out_structure> querycart(HttpServletRequest request);

    List<order_out_structure> queryallorder(HttpServletRequest request);
    String booksales(HttpServletRequest request) ;
}
