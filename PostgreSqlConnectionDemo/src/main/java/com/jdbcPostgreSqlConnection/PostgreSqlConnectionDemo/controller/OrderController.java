package com.jdbcPostgreSqlConnection.PostgreSqlConnectionDemo.controller;

import com.jdbcPostgreSqlConnection.PostgreSqlConnectionDemo.business.OrderService;
import com.jdbcPostgreSqlConnection.PostgreSqlConnectionDemo.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
=======
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
>>>>>>> e6181560e87d5bcbd56372df6af18753b2509fd3
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
<<<<<<< HEAD
  @Autowired
  private  OrderService orderService;

    @GetMapping("/getorders")
=======

  @Autowired
  private  OrderService orderService;

    @GetMapping("/getOrders")
>>>>>>> e6181560e87d5bcbd56372df6af18753b2509fd3
  public List<Order> getOrders()
  {
      return orderService.orderList();
  }







}
