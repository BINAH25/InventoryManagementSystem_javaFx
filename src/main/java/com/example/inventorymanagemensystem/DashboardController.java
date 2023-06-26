package com.example.inventorymanagemensystem;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    @FXML
    private Button add_good_btn;

    @FXML
    private Button add_product_btn;

    @FXML
    private Button add_product_btn1;

    @FXML
    private Button add_product_btn11;

    @FXML
    private ComboBox<?> category;

    @FXML
    private TableColumn<?, ?> column1;

    @FXML
    private TableColumn<?, ?> column2;

    @FXML
    private TableColumn<?, ?> column3;

    @FXML
    private TableColumn<?, ?> column4;

    @FXML
    private Button home_btn;

    @FXML
    private Button home_btn1;

    @FXML
    private Button home_btn11;

    @FXML
    private FontAwesomeIcon logout_btn;

    @FXML
    private FontAwesomeIcon logout_btn1;

    @FXML
    private FontAwesomeIcon logout_btn11;

    @FXML
    private AnchorPane main_form;

    @FXML
    private Label name;

    @FXML
    private Label name1;

    @FXML
    private Label name11;

    @FXML
    private Button order_btn;

    @FXML
    private Button order_btn1;

    @FXML
    private Button order_btn11;

    @FXML
    private AnchorPane order_form;

    @FXML
    private AnchorPane product_fom;

    @FXML
    private TextField product_id;

    @FXML
    private TextField product_name;

    @FXML
    private TextField product_price;

    @FXML
    private Button remove_good_btn;

    @FXML
    private TextField search;

    @FXML
    private TableView<?> tableView1;

    // IMPORTING SQL TOOLS
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    private Statement statement;

    // CREATING A LIST FOR CATEGORY LIST
    private String[] categoryList = {
            "Beverages",
            "Bread/Bakery",
            "Canned/Jarred Goods",
            "Dairy Products",
            "Dry/Baking Goods",
            "Frozen Products",
            "Meat",
            "Farm Produce",
            "Home Cleaners",
            "Paper Goods",
            "Home Care"
    };
    // METHOD TO FILL THE COMBO WITH CATEGORY LIST
    public  void productCategoryList(){
        List<String> CategoryList = new ArrayList<>();
        for(String data:categoryList ){
            CategoryList.add(data);
        }
        ObservableList listData = FXCollections.observableArrayList(CategoryList);
        category.setItems(listData);
    }

    public void SwitchForm(ActionEvent event){
        if(event.getSource() == home_btn){
            main_form.setVisible(true);
            product_fom.setVisible(false);
            order_form.setVisible(false);
        } else if (event.getSource() == add_product_btn) {
            main_form.setVisible(false);
            product_fom.setVisible(true);
            order_form.setVisible(false);
        } else if (event.getSource() == order_btn) {
            main_form.setVisible(false);
            product_fom.setVisible(false);
            order_form.setVisible(true);
        } else if (event.getSource() == home_btn1) {
            main_form.setVisible(true);
            product_fom.setVisible(false);
            order_form.setVisible(false);
        } else if (event.getSource() == add_product_btn1) {
            main_form.setVisible(false);
            product_fom.setVisible(true);
            order_form.setVisible(false);
        } else if (event.getSource()== order_btn1) {
            main_form.setVisible(false);
            product_fom.setVisible(false);
            order_form.setVisible(true);
        } else if (event.getSource() == home_btn11) {
            main_form.setVisible(true);
            product_fom.setVisible(false);
            order_form.setVisible(false);
        } else if (event.getSource() == add_product_btn11) {
            main_form.setVisible(false);
            product_fom.setVisible(true);
            order_form.setVisible(false);
        } else if (event.getSource() == order_btn11) {
            main_form.setVisible(false);
            product_fom.setVisible(false);
            order_form.setVisible(true);
        }
    }

    public void logout(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            home_btn.getScene().getWindow().hide();
            add_product_btn.getScene().getWindow().hide();
            order_btn.getScene().getWindow().hide();
            home_btn1.getScene().getWindow().hide();
            add_product_btn1.getScene().getWindow().hide();
            order_btn1.getScene().getWindow().hide();
            home_btn11.getScene().getWindow().hide();
            add_product_btn11.getScene().getWindow().hide();
            order_btn11.getScene().getWindow().hide();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    // GETTING ALL PRODUCTS FROM THE DATABASE
    public ObservableList<Product> getAllProducts(){
        ObservableList<Product> productList = FXCollections.observableArrayList();
        String getProducts = "SELECT * FROM product";
        try {
            connect = Database.connect();
            prepare = connect.prepareStatement(getProducts);
            result = prepare.executeQuery();
            Product produts;

            while (result.next()){
                produts = new Product(
                        result.getInt("product_id"),
                        result.getString("category"),
                        result.getString("product_name"),
                        result.getDouble("price"),
                        result.getDate("date")
                );
                productList.add(produts);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return  productList;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        productCategoryList();
    }
}
