package com.jdbcPostgreSqlConnection.PostgreSqlConnectionDemo.core.connection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import java.sql.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
    public JSONArray orderList() {

        String query = "select * from orders";
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        Connection connection = connectionManager.getConnection();
        JSONArray result = new JSONArray();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            ResultSetMetaData md = resultSet.getMetaData();
            int numCols = md.getColumnCount();
            List<String> colNames = IntStream.range(0, numCols)
                    .mapToObj(i -> {
                        try {
                            return md.getColumnName(i + 1);
                        } catch (SQLException e) {
                            e.printStackTrace();
                            return "?";
                        }
                    })
                    .collect(Collectors.toList());

            while (resultSet.next()) {
                JSONObject row = new JSONObject();
                colNames.forEach(cn -> {
                    try {
                        row.put(cn, resultSet.getObject(cn));
                    } catch (JSONException | SQLException e) {
                        e.printStackTrace();
                    }
                });
                result.put(row);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
