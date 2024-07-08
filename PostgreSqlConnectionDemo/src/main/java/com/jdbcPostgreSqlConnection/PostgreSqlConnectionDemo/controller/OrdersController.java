package com.jdbcPostgreSqlConnection.PostgreSqlConnectionDemo.controller;
import com.jdbcPostgreSqlConnection.PostgreSqlConnectionDemo.business.GeneralService;
import com.jdbcPostgreSqlConnection.PostgreSqlConnectionDemo.core.result.DataResult;
import com.jdbcPostgreSqlConnection.PostgreSqlConnectionDemo.core.result.SuccessDataResult;
import com.jdbcPostgreSqlConnection.PostgreSqlConnectionDemo.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrdersController<T> {

    @Autowired
    private GeneralService<T> generalService;

    @GetMapping("/getorders")
    public DataResult<List<T>> getOrders()
    {
        String getOrderUrl="select ord.order_id, " +
                "ord.customer_id,ord.order_date, ord.freight,ord.ship_name," +
                "ord.ship_country from orders as ord";
         return this.generalService.getObjectList(getOrderUrl);
    }

    @GetMapping("/getorderbyid/{id}")
    public DataResult<T> getObjectById(@PathVariable int id)
    {
        String getOrderUrl="select * from orders as ord where ord.order_id="+id;
        return generalService.getObjectById(getOrderUrl);
    }



}
