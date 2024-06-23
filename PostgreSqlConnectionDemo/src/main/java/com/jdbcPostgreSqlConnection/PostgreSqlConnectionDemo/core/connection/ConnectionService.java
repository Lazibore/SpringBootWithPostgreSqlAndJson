package com.jdbcPostgreSqlConnection.PostgreSqlConnectionDemo.core.connection;
import com.jdbcPostgreSqlConnection.PostgreSqlConnectionDemo.entity.Order;
import java.util.List;
public interface ConnectionService {
   List<Order> orderList();
}
