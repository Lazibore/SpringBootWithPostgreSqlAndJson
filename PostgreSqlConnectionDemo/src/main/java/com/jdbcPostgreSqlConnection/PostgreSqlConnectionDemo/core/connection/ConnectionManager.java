package com.jdbcPostgreSqlConnection.PostgreSqlConnectionDemo.core.connection;
import org.springframework.stereotype.Service;
import java.sql.*;

@Service
public class ConnectionManager implements ConnectionService {
    private static volatile ConnectionManager connectionManager=null;
    private static volatile Connection conn=null;
    private static final String url="jdbc:postgresql://localhost:5432/Northwind";
    private static final String user="postgres";
    private static final String pwd="*";

    private ConnectionManager()
    {

    }
    public static ConnectionManager getInstance()
    {
        if (connectionManager == null) {
            synchronized (ConnectionManager.class) {
                if (connectionManager == null) {
                    connectionManager = new ConnectionManager();
                }

            }
        }
        return connectionManager;
    }
    public Connection getConnection()
    {
        if (conn == null) {
            synchronized (ConnectionManager.class) {
                if (conn == null) {
                    try {
                        conn = DriverManager.getConnection(url,user,pwd);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        }
        return conn;
    }

    public Statement getStatement()
    {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        Connection connection = connectionManager.getConnection();
        Statement statement =null;
        try {
         statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return statement;
    }
}
