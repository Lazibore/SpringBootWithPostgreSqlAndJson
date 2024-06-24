package com.jdbcPostgreSqlConnection.PostgreSqlConnectionDemo.business;
import com.jdbcPostgreSqlConnection.PostgreSqlConnectionDemo.core.connection.ConnectionService;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderManager implements OrderService{

    private  ConnectionService connectionService;

    @Autowired
    public OrderManager(ConnectionService connectionService) {
        this.connectionService = connectionService;
    }

    @Override
    public JSONArray orderList() {
        return this.connectionService.orderList();
    }
}
