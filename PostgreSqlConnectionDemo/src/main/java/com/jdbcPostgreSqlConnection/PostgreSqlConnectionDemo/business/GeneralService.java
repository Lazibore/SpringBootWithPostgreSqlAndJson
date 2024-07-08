package com.jdbcPostgreSqlConnection.PostgreSqlConnectionDemo.business;
import com.jdbcPostgreSqlConnection.PostgreSqlConnectionDemo.core.result.DataResult;

import java.util.List;

public interface GeneralService<T> {
   DataResult<List<T>>  getObjectList(String query);
    DataResult<T> getObjectById(String query);
}
