package com.jdbcPostgreSqlConnection.PostgreSqlConnectionDemo.core.utilities;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jdbcPostgreSqlConnection.PostgreSqlConnectionDemo.core.connection.ConnectionManager;
import com.jdbcPostgreSqlConnection.PostgreSqlConnectionDemo.core.connection.ConnectionService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.*;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class JsonArrayToList<T> implements CastService<T>{

    @Autowired
    private ConnectionService connectionService;



    public JSONArray getObjectJsonArray(String query) {
        JSONArray result = new JSONArray();
        try {
            ConnectionManager connectionManager = ConnectionManager.getInstance();
            Connection connection = connectionManager.getConnection();
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
                    .toList();

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

    public List<T> getObjectList(String query) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<T> Tlist= null;
        try {
            Tlist = objectMapper.readValue(getObjectJsonArray(query).toString(), new TypeReference<>(){});
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return Tlist;
    }

    @Override
    public Object getObjectById(String query) {
         Object t = getObjectList(query).getFirst();
        return t;
    }

}
