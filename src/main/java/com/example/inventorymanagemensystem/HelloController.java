package com.example.inventorymanagemensystem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;

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
                    // TO HIDE THE LOGIN FORM
                    login.getScene().getWindow().hide();
                    // REDIRECT TO DASHBOARD
                    Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);
                    stage.setTitle("INVENTORY MANAGEMENT SYSTEM!");
                    stage.setScene(scene);
                    stage.show();
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

    public void register(){
        connect = Database.connect();
        try {
            if(su_email.getText().isEmpty()|| su_username.getText().isEmpty()
            || su_password.getText().isEmpty()||su_confirm_password.getText().isEmpty()){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else if (!Objects.equals(su_password.getText(), su_confirm_password.getText())) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Password Mismatch ");
                alert.showAndWait();
            }else{

                String insertData = "INSERT INTO admin (email,username,password) VALUES (?,?,?)";
                prepare = connect.prepareStatement(insertData);
                prepare.setString(1, su_email.getText());
                prepare.setString(2,su_username.getText());
                prepare.setString(3,su_password.getText());

                prepare.executeUpdate();
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("User Created Successfully");
                alert.showAndWait();
                su_email.setText("");
                su_password.setText("");
                su_confirm_password.setText("");
                su_username.setText("");
                registration_form.setVisible(false);
                login_form.setVisible(true);

            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}