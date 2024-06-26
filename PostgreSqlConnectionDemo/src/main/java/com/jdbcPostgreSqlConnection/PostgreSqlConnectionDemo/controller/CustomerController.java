package com.jdbcPostgreSqlConnection.PostgreSqlConnectionDemo.controller;
import com.jdbcPostgreSqlConnection.PostgreSqlConnectionDemo.business.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController<T> {

    @Autowired
    private GeneralService<T> generalService;

@GetMapping("/getcustomers")
public List<T> getAllCustomer()
{
    String query ="Select * from customers";
    return generalService.getObjectList(query);
}












}
