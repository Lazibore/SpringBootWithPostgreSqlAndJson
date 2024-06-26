package com.jdbcPostgreSqlConnection.PostgreSqlConnectionDemo.core.utilities;

import org.json.JSONArray;

import java.util.List;

public interface CastService<T> {
    List<T> getObjectList(String query);
    JSONArray getObjectJsonArray(String query);
}
