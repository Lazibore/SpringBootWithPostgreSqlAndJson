package com.jdbcPostgreSqlConnection.PostgreSqlConnectionDemo.business;

import com.jdbcPostgreSqlConnection.PostgreSqlConnectionDemo.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> orderList();
}
