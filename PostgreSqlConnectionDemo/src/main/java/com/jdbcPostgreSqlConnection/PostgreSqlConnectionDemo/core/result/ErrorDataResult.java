package com.jdbcPostgreSqlConnection.PostgreSqlConnectionDemo.core.result;

public class ErrorDataResult<T>  extends DataResult{

    public ErrorDataResult() {
        super(false);
    }

    public ErrorDataResult(String message, T data) {
        super(message, false, data);
    }

    public ErrorDataResult( T data) {
        super(false, data);
    }
}
