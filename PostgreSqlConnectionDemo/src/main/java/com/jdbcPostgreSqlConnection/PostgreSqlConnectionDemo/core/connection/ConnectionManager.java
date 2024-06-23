package com.jdbcPostgreSqlConnection.PostgreSqlConnectionDemo.core.connection;
import com.jdbcPostgreSqlConnection.PostgreSqlConnectionDemo.entity.Order;
import org.springframework.stereotype.Service;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
@Service
public class ConnectionManager implements ConnectionService {
    private static ConnectionManager connectionManager=null;
    private static final String url="jdbc:postgresql://localhost:5432/Northwind";
    private static final String user="postgres";
    private static final String pwd="*";

    private ConnectionManager(){}

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
                    order.setEmloyeeId(rs.getInt("employee_id"));

                    SimpleDateFormat dateFormatter=new SimpleDateFormat("dd/MM/yyyy");
                    order.setOrderDate(dateFormatter.format(rs.getDate("order_date")));

                    order.setShipName(rs.getString("ship_name"));
                    order.setFreight(rs.getDouble("freight"));

                    orderList.add(order);
                }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orderList;
    }

}
