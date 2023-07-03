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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.Spinner;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

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
    private TableColumn<Product, Integer> column1;

    @FXML
    private TableColumn<Product, String> column2;

    @FXML
    private TableColumn<Product, String> column3;

    @FXML
    private TableColumn<Product, String> column4;

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
    private TableView<Product> tableView1;
    @FXML
    private TableView<CustomerData> tableView2;

    @FXML
    private Label total;

    @FXML
    private Button receipt_btn;
    @FXML
    private Button pay_btn;
    @FXML
    private TableColumn<?, ?> order_col_category;

    @FXML
    private TableColumn<?, ?> order_col_name;

    @FXML
    private TableColumn<?, ?> order_col_price;

    @FXML
    private TableColumn<?, ?> order_col_quantity;
    @FXML
    private ComboBox<?> issue_good_category;

    @FXML
    private ComboBox<?> issue_good_name;

    @FXML
    private Spinner<Integer> issue_good_quantity;
    @FXML
    private TextField amount;

    @FXML
    private Label balance;
    @FXML

    private Button order_add_btn;
    Alert alert;

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
    private String[] orderCategoryList = {
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
    public  void orderCategoryList(){

        List<String> CategoryList = new ArrayList<>();
        for(String data:orderCategoryList ){
            CategoryList.add(data);
        }
        ObservableList listData = FXCollections.observableArrayList(CategoryList);
        issue_good_category.setItems(listData);
        orderProductNameList();
    }
// SWITCH FORM METHOD
    public void SwitchForm(ActionEvent event){
        if(event.getSource() == home_btn){
            main_form.setVisible(true);
            product_fom.setVisible(false);
            order_form.setVisible(false);
        } else if (event.getSource() == add_product_btn) {
            main_form.setVisible(false);
            product_fom.setVisible(true);
            order_form.setVisible(false);
            showAllProducts();
            productCategoryList();

        } else if (event.getSource() == order_btn) {
            main_form.setVisible(false);
            product_fom.setVisible(false);
            order_form.setVisible(true);
            showAllIssuedGoods();
            orderCategoryList();
            orderProductNameList();
            getSpinner();

        } else if (event.getSource() == home_btn1) {
            main_form.setVisible(true);
            product_fom.setVisible(false);
            order_form.setVisible(false);
        } else if (event.getSource() == add_product_btn1) {
            main_form.setVisible(false);
            product_fom.setVisible(true);
            order_form.setVisible(false);
            showAllProducts();
            productCategoryList();

        } else if (event.getSource()== order_btn1) {
            main_form.setVisible(false);
            product_fom.setVisible(false);
            order_form.setVisible(true);
            showAllIssuedGoods();
            orderCategoryList();
            orderProductNameList();
            getSpinner();

        } else if (event.getSource() == home_btn11) {
            main_form.setVisible(true);
            product_fom.setVisible(false);
            order_form.setVisible(false);
        } else if (event.getSource() == add_product_btn11) {
            main_form.setVisible(false);
            product_fom.setVisible(true);
            order_form.setVisible(false);
            showAllProducts();
            productCategoryList();

        } else if (event.getSource() == order_btn11) {
            main_form.setVisible(false);
            product_fom.setVisible(false);
            order_form.setVisible(true);
            showAllIssuedGoods();
            orderCategoryList();
            orderProductNameList();
            getSpinner();

        }
    }
// LOGOUT METHOD
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

    // ADD PRODUCT METHOD
    public void addProduct(){
        String sql = "INSERT INTO product (product_id,category,product_name,price,date) VALUES (?,?,?,?,?)";
        try {
            if(product_id.getText().isEmpty()|| category.getSelectionModel().getSelectedItem() == null
                    || product_name.getText().isEmpty()||product_price.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            }else {
                connect = Database.connect();
                prepare = connect.prepareStatement(sql);
                prepare.setString(1,product_id.getText());
                prepare.setString(2,(String) category.getSelectionModel().getSelectedItem());
                prepare.setString(3,product_name.getText());
                prepare.setString(4,product_price.getText());

                Date date  = new Date();
                java.sql.Date sqldate = new java.sql.Date(date.getTime());
                prepare.setString(5,String.valueOf(sqldate));
                prepare.executeUpdate();
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("New Product Created Successfully");
                alert.showAndWait();
                // CLEAR THE PRODUCT FORM
                clearform();
                // SHOW THE PRODUCT ADDED IN THE TABLEVIEW
                showAllProducts();

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteProduct(){
        connect = Database.connect();
        try {

            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation  Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to delete Product with ID:" + product_id.getText()+ "?");
            Optional<ButtonType> option = alert.showAndWait();

            if(option.get().equals(ButtonType.OK)){
                String deleteData = "DELETE FROM product WHERE product_id = "+ product_id.getText();
                prepare = connect.prepareStatement(deleteData);
                prepare.executeUpdate();
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Product Deleted Successfully");
                alert.showAndWait();

                // TO UPDATE THE TABLE VIEW
                showAllProducts();
                // TO CLEAR THE PRODUCT FORM
                clearform();
            }else{
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Action Cancelled..");
                alert.showAndWait();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    // METHOD TO CLEAR THE PRODUCT FORM
    public void clearform(){
        product_id.setText("");
        product_price.setText("");
        product_name.setText("");
        category.getSelectionModel().clearSelection();
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
// MAP EACH PRODUCT TO IT RESPECTIVE COLUMN
    private ObservableList<Product> ProductLists;
    public void showAllProducts(){
        ProductLists = getAllProducts();
        column1.setCellValueFactory(new PropertyValueFactory<>("product_id"));
        column2.setCellValueFactory(new PropertyValueFactory<>("category"));
        column3.setCellValueFactory(new PropertyValueFactory<>("product_name"));
        column4.setCellValueFactory(new PropertyValueFactory<>("price"));
        tableView1.setItems(ProductLists);
    }
//  POPULATE THE PRODUCT FORM WITH SELECT PRODUCT
    public void selectStudentdata(){
        Product product = tableView1.getSelectionModel().getSelectedItem();
        int num = tableView1.getSelectionModel().getSelectedIndex();

        if((num - 1) < -1) return;
        product_id.setText(String.valueOf(product.getProductId()));
        product_name.setText(String.valueOf(product.getProduct_name()));
        product_price.setText(String.valueOf(product.getPrice()));
    }
// ISSUE GOODS METHODS
    public ObservableList<CustomerData> issueDataList (){
        customerId();
        ObservableList<CustomerData> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM customer WHERE customer_id = '"+customer_id+"'";
        connect = Database.connect();
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            CustomerData customers;

            while (result.next()){
                customers = new CustomerData(
                        result.getInt("customer_id"),
                        result.getInt("quantity"),
                        result.getDouble("price"),
                        result.getString("type"),
                        result.getString("product_name"),
                        result.getDate("date")
                );
                listData.add(customers);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return listData;
    }

    // CHECK CUSTOMER ID METHOD

    private  int customer_id;

    public void customerId(){
        String sql = "SELECT * FROM customer";
        int checkId = 0;

        try {
            connect = Database.connect();
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()){
                customer_id = result.getInt("customer_id");
            }
            String checkData = "SELECT * FROM customer_receipt";
            statement = connect.createStatement();
            result = statement.executeQuery(checkData);

            while (result.next()){
                checkId = result.getInt("customer_id");
            }

            if(customer_id == 0){
                customer_id += 1;
            } else if (checkId == customer_id) {
                customer_id += 1;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
// DISPLAY ALL ISSUED GOODS
    private ObservableList<CustomerData> issuedGoodsDataList;

    public void showAllIssuedGoods (){
        issuedGoodsDataList = issueDataList();
        order_col_name.setCellValueFactory(new PropertyValueFactory<>("goodCategory"));
        order_col_category.setCellValueFactory(new PropertyValueFactory<>("goodName"));
        order_col_quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        order_col_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        tableView2.setItems(issuedGoodsDataList);
        diaplayTotalPrice();
    }

// GET PRODUCTS DEPENDING ON THE CATEGORY SELECTED
    public void orderProductNameList(){
        String sql = "SELECT * FROM product WHERE category = '" + issue_good_category.getSelectionModel().getSelectedItem()+"'";
        connect = Database.connect();
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            ObservableList listData = FXCollections.observableArrayList();

            while (result.next()){
                listData.add(result.getString("product_name"));
            }
            issue_good_name.setItems(listData);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    // METHOD TO GET THE SPINNER VALUE

    private SpinnerValueFactory<Integer> spinner;
    public void getSpinner(){
        spinner = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10,0);
        issue_good_quantity.setValueFactory(spinner);
    }
    // METHOD TO SET THE SPINNER VALUE

    int qty;
    public void orderSpinner(){
        qty = issue_good_quantity.getValue();
    }

    // METHOD TO ADD ISSUE PRODUCTS OR GOODS
    public void AddOrder(){
        customerId();
        String sql  = "INSERT INTO customer (customer_id,type,product_name,quantity,price,date) VALUES (?,?,?,?,?,?)";
        connect = Database.connect();
        try {
            String checkData = "SELECT * FROM product WHERE product_name = '"
                    +issue_good_name.getSelectionModel().getSelectedItem() +"'";

            double price = 0;

            statement = connect.createStatement();
            result = statement.executeQuery(checkData);

            if(result.next()){
                price = result.getDouble("price");

            }
            double total = (price * qty);
            if(
                    issue_good_category.getSelectionModel().getSelectedItem() == null
                    || issue_good_name.getSelectionModel().getSelectedItem() == null
            ){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            }else{
                prepare = connect.prepareStatement(sql);
                prepare.setString(1,String.valueOf(customer_id));
                prepare.setString(2,(String) issue_good_category.getSelectionModel().getSelectedItem());
                prepare.setString(3,(String) issue_good_name.getSelectionModel().getSelectedItem());
                prepare.setString(4,String.valueOf(qty));
                prepare.setString(5,String.valueOf(total));

                Date date = new Date();
                java.sql.Date  sqldate = new java.sql.Date(date.getTime());
                prepare.setString(6,String.valueOf(sqldate));
                prepare.executeUpdate();
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Good Issued Successfully");
                alert.showAndWait();
                diaplayTotalPrice();
                showAllIssuedGoods();
            }


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // METHOD TO DISPLAY TOTAL PRICE

    private double total_price;
    public void diaplayTotalPrice(){
        customerId();
        String sql  = "SELECT SUM(price) FROM customer WHERE customer_id = '" +customer_id+"'";
        connect = Database.connect();
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()){
                total_price = result.getDouble("SUM(price)");
            }
            total.setText("$"+String.valueOf(total_price));

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //
    public void payOrder(){
        customerId();
        String sql = "INSERT INTO customer_receipt (customer_id,total, date) VALUES (?,?,?)";
        try {
            connect = Database.connect();
            if(total_price > 0){
                prepare = connect.prepareStatement(sql);
                prepare.setString(1,String.valueOf(customer_id));
                prepare.setString(2,String.valueOf(total_price));

                Date date = new Date();
                java.sql.Date sqldate = new java.sql.Date(date.getTime());
                prepare.setString(3,String.valueOf(sqldate));
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Good Payment made Successfully");
                alert.showAndWait();
            }else{
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Unknown Error occurred");
                alert.showAndWait();

            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        productCategoryList();
        showAllProducts();
        showAllIssuedGoods();
        orderCategoryList();
        orderProductNameList();
        getSpinner();
    }
}
