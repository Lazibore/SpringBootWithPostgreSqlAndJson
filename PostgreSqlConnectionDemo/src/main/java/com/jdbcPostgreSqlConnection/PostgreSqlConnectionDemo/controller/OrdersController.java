package com.jdbcPostgreSqlConnection.PostgreSqlConnectionDemo.controller;
import com.jdbcPostgreSqlConnection.PostgreSqlConnectionDemo.business.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrdersController<T> {

    @Autowired
    private GeneralService<T> generalService;

    @GetMapping("/getorders")
    public List<T> getOrders()
    {
        String getOrderUrl="select ord.order_id, " +
                "ord.customer_id,ord.order_date, ord.freight,ord.ship_name," +
                "ord.ship_country from orders as ord";
         return this.generalService.getObjectList(getOrderUrl);
    }

    @GetMapping("/getorderbyid/{id}")
    public T getObjectById(@PathVariable int id)
    {
        String getOrderUrl="select * from orders as ord where ord.order_id="+id;
        return (T) generalService.getObjectById(getOrderUrl);
    }




}
