package com.example.inventorymanagemensystem;

import java.util.Date;

public class Product {
    private Integer product_id;
    private String category;
    private String vendor_name;
    private  String product_name;
    private  double price;
    private Date date;

    public Product(Integer product_id,String category,String vendor_name,String product_name,double price,Date date){
        this.product_id = product_id;
        this.category = category;
        this.vendor_name = vendor_name;
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

    public String getVendor_name() {
        return vendor_name;
    }
}
