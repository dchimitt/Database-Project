package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class inventoryScreenControl {

	// Buttons
    @FXML private Button btnAdd;
    @FXML private Button btnRemove;
    @FXML private Button btnClose;
    
    // Labels
    @FXML private Label lblSelectIngredient;
    @FXML private Label lblEditQuantity;
    @FXML private Label lblQuantityInInventory;
    
    // TextFields
    @FXML private TextField editQuantityField;
	
    // ComboBoxes
    @FXML private ComboBox<String> selectIngredientComboBox;

    @FXML
    private void initialize() {
        // Load list of ingredients into the dropdown list when the application starts
        loadIngredientList();
    }
    
    // Queries the database and loads full list of employee names into the dropdown list
    private void loadIngredientList() {
        ObservableList<String> ingredientNames = FXCollections.observableArrayList();

        try (Connection connection = DriverManager.getConnection(Main.URL, Main.USER, Main.PASSWORD)) {
            String query = "SELECT ingredientName AS ingredient_name FROM INVENTORY ORDER BY ingredientName;"; 
            try (Statement stmt = connection.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {

                while (rs.next()) {
                    String ingredientName = rs.getString("ingredient_name");
                    ingredientNames.add(ingredientName); 
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        selectIngredientComboBox.setItems(ingredientNames);
    }
    
    @FXML
    private void handleAddButtonAction() {
    	// Logic to handle action when the Add button is clicked
    }

    @FXML
    private void handleRemoveButtonAction() {
    	// Logic to handle action when the Remove button is clicked
    }

    @FXML
    private void handleCloseButtonAction() {
    	try {
            Stage stage = (Stage) btnClose.getScene().getWindow();
            stage.setScene(Main.backOfficeUIScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
