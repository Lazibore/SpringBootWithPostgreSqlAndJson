package com.jdbcPostgreSqlConnection.PostgreSqlConnectionDemo.core.result;

public class Result {
    private String message;
    private  boolean isSuccess;

    public Result(boolean isSuccess)
    {
        this.isSuccess=isSuccess;
    }

    public  Result(String message,boolean isSuccess)
    {
        this(isSuccess);
        this.message=message;
    }





}
