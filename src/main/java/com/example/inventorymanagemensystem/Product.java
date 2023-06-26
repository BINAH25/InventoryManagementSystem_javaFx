package com.example.inventorymanagemensystem;

import java.util.Date;

public class Product {
    private Integer product_id;
    private String category;
    private  String product_name;
    private  double price;
    private Date date;

    public Product(Integer product_id,String category,String product_name,double price,Date date){
        this.product_id = product_id;
        this.category = category;
        this.product_name = product_name;
        this.price = price;
        this.date = date;
    }
    public  Integer getProductId(){
        return  product_id;
    }

    public String getCategory(){
        return category;
    }

    public String getProduct_name(){
        return product_name;
    }

    public Date getDate() {
        return date;
    }

    public double getPrice() {
        return price;
    }
}
