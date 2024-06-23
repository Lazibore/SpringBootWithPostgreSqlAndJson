package com.jdbcPostgreSqlConnection.PostgreSqlConnectionDemo.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import java.time.LocalDate;
public class Order {

    @Id
    private int orderId;

    private  String customerId;

    private  int emloyeeId;

//    @JsonFormat(pattern="dd-mm-yyyy")
    private String orderDate;

    private  String shipName;

    private  double freight;

    public Order()
    {

    }

    public Order(int orderId, String customerId, int emloyeeId, String orderDate, String shipName, double freight) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.emloyeeId = emloyeeId;
        this.orderDate = orderDate;
        this.shipName = shipName;
        this.freight = freight;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public int getEmloyeeId() {
        return emloyeeId;
    }

    public void setEmloyeeId(int emloyeeId) {
        this.emloyeeId = emloyeeId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public double getFreight() {
        return freight;
    }

    public void setFreight(double freight) {
        this.freight = freight;
    }
}
