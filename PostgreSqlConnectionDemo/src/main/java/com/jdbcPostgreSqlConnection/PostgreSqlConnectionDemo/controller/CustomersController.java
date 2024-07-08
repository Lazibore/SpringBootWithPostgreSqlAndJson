package com.jdbcPostgreSqlConnection.PostgreSqlConnectionDemo.controller;
import com.jdbcPostgreSqlConnection.PostgreSqlConnectionDemo.business.GeneralService;
import com.jdbcPostgreSqlConnection.PostgreSqlConnectionDemo.core.result.DataResult;
import com.jdbcPostgreSqlConnection.PostgreSqlConnectionDemo.core.result.SuccessDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomersController<T> {

    @Autowired
    private GeneralService<T> generalService;

    @GetMapping("/getcustomers")
    public DataResult<List<T>> getAllCustomer()
    {
        String query ="Select * from customers";
        return generalService.getObjectList(query);
    }

    @GetMapping("/getcustomerbyid/{id}")
    public DataResult<T> getCustomerById(@PathVariable String id)
    {
        String query ="Select * from customers as cst where cst.customer_id='"+id+"'";
        return new SuccessDataResult<>("Musteri bulundu",(T) generalService.getObjectById(query));
    }















}
