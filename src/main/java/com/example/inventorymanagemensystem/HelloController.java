package com.example.inventorymanagemensystem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

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
    private TextField si_username;

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
}