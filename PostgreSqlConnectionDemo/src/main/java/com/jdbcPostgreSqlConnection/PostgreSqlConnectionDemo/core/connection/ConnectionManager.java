package com.jdbcPostgreSqlConnection.PostgreSqlConnectionDemo.core.connection;
import com.jdbcPostgreSqlConnection.PostgreSqlConnectionDemo.entity.Order;
import org.springframework.stereotype.Service;
<<<<<<< HEAD
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
=======

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

>>>>>>> e6181560e87d5bcbd56372df6af18753b2509fd3
@Service
public class ConnectionManager implements ConnectionService {
    private static ConnectionManager connectionManager=null;
    private static final String url="jdbc:postgresql://localhost:5432/Northwind";
    private static final String user="postgres";
    private static final String pwd="*";

<<<<<<< HEAD
    private ConnectionManager(){}

=======
    private ConnectionManager()
    {
//        url="jdbc:postgresql://localhost:5432/Northwind";
//        user="postgres";
//        pwd="*";
    }
>>>>>>> e6181560e87d5bcbd56372df6af18753b2509fd3
    public static ConnectionManager getInstance()
    {
        if (connectionManager == null)
        {
            connectionManager=new ConnectionManager();
        }

        return connectionManager;
    }
    public Connection getConnection()
    {
        Connection cnn;
        try {
           cnn = DriverManager.getConnection(url,user,pwd);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cnn;
    }
    public List<Order> orderList()
    {
        String query="select * from orders";
        ConnectionManager connectionManager=ConnectionManager.getInstance();
        Connection connection=connectionManager.getConnection();
        Order order;
        List<Order> orderList=new ArrayList<>();
        try {
            Statement statement=connection.createStatement();
                ResultSet rs=statement.executeQuery(query);
                while (rs.next())
                {
                    order=new Order();

                    order.setOrderId(rs.getInt("order_id"));
                    order.setCustomerId(rs.getString("customer_id"));
<<<<<<< HEAD
                    order.setEmloyeeId(rs.getInt("employee_id"));

                    SimpleDateFormat dateFormatter=new SimpleDateFormat("dd/MM/yyyy");
                    order.setOrderDate(dateFormatter.format(rs.getDate("order_date")));

                    order.setShipName(rs.getString("ship_name"));
                    order.setFreight(rs.getDouble("freight"));

=======
                    order.setOrderDate(rs.getDate("order_date").toLocalDate());
>>>>>>> e6181560e87d5bcbd56372df6af18753b2509fd3
                    orderList.add(order);
                }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orderList;
    }

}
