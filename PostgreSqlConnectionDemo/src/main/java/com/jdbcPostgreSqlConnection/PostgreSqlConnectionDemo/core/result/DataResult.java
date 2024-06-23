package com.jdbcPostgreSqlConnection.PostgreSqlConnectionDemo.core.result;

public class DataResult<T> extends Result{
    private T data;

    public DataResult(boolean isSuccess) {
        super(isSuccess);
    }

    public DataResult(boolean isSuccess,T data) {
        super(isSuccess);
        this.data=data;
    }

    public DataResult(String message, boolean isSuccess,T data) {
        super(message, isSuccess);
        this.data=data;
    }
}
