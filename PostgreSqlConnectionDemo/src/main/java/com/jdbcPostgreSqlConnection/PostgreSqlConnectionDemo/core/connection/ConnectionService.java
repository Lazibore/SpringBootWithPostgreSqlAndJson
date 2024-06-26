package com.jdbcPostgreSqlConnection.PostgreSqlConnectionDemo.core.connection;
import com.jdbcPostgreSqlConnection.PostgreSqlConnectionDemo.entity.Order;
import org.json.JSONArray;

import java.sql.Statement;

public interface ConnectionService {
   Statement getStatement();
}
