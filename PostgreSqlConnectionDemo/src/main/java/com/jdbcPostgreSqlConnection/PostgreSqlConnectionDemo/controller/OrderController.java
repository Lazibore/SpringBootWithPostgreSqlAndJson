package com.jdbcPostgreSqlConnection.PostgreSqlConnectionDemo.controller;
import com.jdbcPostgreSqlConnection.PostgreSqlConnectionDemo.business.OrderService;
import com.jdbcPostgreSqlConnection.PostgreSqlConnectionDemo.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
  @Autowired
  private  OrderService orderService;

    @GetMapping("/getorders")
  public List<Order> getOrders()
  {
      return orderService.orderList();
  }







}
