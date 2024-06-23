package com.jdbcPostgreSqlConnection.PostgreSqlConnectionDemo.controller;
import com.jdbcPostgreSqlConnection.PostgreSqlConnectionDemo.business.OrderService;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
  @Autowired
  private  OrderService orderService;

  @GetMapping("/getorders")
  public JSONArray getOrders()
  {
      return orderService.orderList();
  }







}
