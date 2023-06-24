package com.example.inventorymanagemensystem;
import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    public static Connection connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/javafxCRUD", "root", "");
            return connect;

        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
