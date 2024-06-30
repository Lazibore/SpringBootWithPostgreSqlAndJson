package com.jdbcPostgreSqlConnection.PostgreSqlConnectionDemo.core.utilities;

import org.json.JSONArray;

import java.util.List;

public interface CastService<T> {
    JSONArray getObjectJsonArray(String query);
    List<T> getObjectList(String query);
    Object getObjectById(String query);
}
