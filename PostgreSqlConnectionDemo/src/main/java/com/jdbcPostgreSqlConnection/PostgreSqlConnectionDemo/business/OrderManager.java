package com.jdbcPostgreSqlConnection.PostgreSqlConnectionDemo.business;

import com.jdbcPostgreSqlConnection.PostgreSqlConnectionDemo.core.connection.ConnectionService;
import com.jdbcPostgreSqlConnection.PostgreSqlConnectionDemo.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderManager implements OrderService{
    @Autowired
    private ConnectionService connectionService;

    @Override
    public List<Order> orderList() {
        return connectionService.orderList();
    }
}
