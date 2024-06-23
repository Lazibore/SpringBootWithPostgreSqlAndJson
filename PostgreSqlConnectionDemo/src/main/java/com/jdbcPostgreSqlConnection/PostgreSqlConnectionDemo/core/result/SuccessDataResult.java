package com.jdbcPostgreSqlConnection.PostgreSqlConnectionDemo.core.result;

public class SuccessDataResult<T> extends DataResult{

    public SuccessDataResult() {
        super(true);
    }

    public SuccessDataResult(String message, T data) {
        super(message, true, data);
    }

    public SuccessDataResult( T data) {
        super(true, data);
    }
}
