package com.example.inventorymanagemensystem;

import java.sql.Date;

public class CustomerData {
    private Integer customerID;
    private Integer quantity;
    private double price;
    private String goodName;
    private  String goodCategory;
    private Date date;


    public CustomerData(Integer customerID,Integer quantity,double price,String goodName,String goodCategory,Date date){
        this.customerID = customerID;
        this.date = date;
        this.price = price;
        this.goodCategory = goodCategory;
        this.goodName = goodName;
        this.quantity = quantity;
    }



    public Integer getCustomerID() {
        return customerID;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getGoodName() {
        return goodName;
    }

    public Date getDate() {
        return date;
    }

    public String getGoodCategory() {
        return goodCategory;
    }
}
