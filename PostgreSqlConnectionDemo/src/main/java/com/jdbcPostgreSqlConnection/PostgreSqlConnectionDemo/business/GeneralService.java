package com.jdbcPostgreSqlConnection.PostgreSqlConnectionDemo.business;
import java.util.List;

public interface GeneralService<T> {
    List<T> getObjectList(String query);
}
