package com.example.inventorymanagemensystem;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    @FXML
    private Button add_good_btn;

    @FXML
    private Button add_product_btn;

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
    private FontAwesomeIcon logout_btn;

    @FXML
    private Label name;

    @FXML
    private Button order_btn;

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
    private TableView<?> tableView;



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

    public  void productCategoryList(){
        List<String> CategoryList = new ArrayList<>();
        for(String data:categoryList ){
            CategoryList.add(data);
        }
        ObservableList listData = FXCollections.observableArrayList(CategoryList);
        category.setItems(listData);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        productCategoryList();
    }
}
