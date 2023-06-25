package com.example.inventorymanagemensystem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class HelloController {
    @FXML
    private Button create_account;

    @FXML
    private Button login;

    @FXML
    private AnchorPane login_form;

    @FXML
    private Button register;

    @FXML
    private AnchorPane registration_form;

    @FXML
    private PasswordField si_password;

    @FXML
    private TextField si_email;
    @FXML
    private PasswordField su_confirm_password;

    @FXML
    private TextField su_email;

    @FXML
    private Button su_login;

    @FXML
    private PasswordField su_password;

    @FXML
    private TextField su_username;

    // METHOD TO SWITCH FORM
    public void switchForm(ActionEvent event){
        if(event.getSource()==su_login){
            login_form.setVisible(true);
            registration_form.setVisible(false);
        }else{
            if(event.getSource() == create_account){
                login_form.setVisible(false);
                registration_form.setVisible(true);
            }
        }

    }
    // IMPORTING REQUIRE LIBRARIES
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    private Alert alert;
    // LOGIN METHOD
    public void login(){
        String sql = "SELECT email,password FROM admin WHERE email = ? and password = ? ";
        try {
            connect = Database.connect();
            if(si_email.getText().isEmpty() || si_password.getText().isEmpty()){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            }else{
                prepare = connect.prepareStatement(sql);
                prepare.setString(1,si_email.getText());
                prepare.setString(2,si_password.getText());
                result = prepare.executeQuery();

                if(result.next()){
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Login");
                    alert.showAndWait();
                    si_email.setText("");
                    si_password.setText("");
                }else{
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Incorrect Credentials");
                    alert.showAndWait();
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}