package com.example.inventorymanagemensystem;

public class VendorData {
    private String vendor_name;
    private  Integer vendor_id;
    public VendorData(String vendor_name,Integer vendor_id){
        this.vendor_name = vendor_name;
        this.vendor_id = vendor_id;
    }

    public String getVendor_name() {
        return vendor_name;
    }

    public Integer getVendor_id() {
        return vendor_id;
    }
}
