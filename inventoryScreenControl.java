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
    @FXML
    private void handleSelectionMade() {
        try (Connection connection = DriverManager.getConnection(Main.URL, Main.USER, Main.PASSWORD)) {
            String query = String.format("SELECT ingredientQuantity AS ingredient_q FROM Inventory WHERE ingredientName = '%s';", selectIngredientComboBox.getValue());
            try (Statement stmt = connection.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {

                while (rs.next()) {
                    String ingredientq = rs.getString("ingredient_q");
                    lblQuantityInInventory.setText("Quantity in Inventory: " + ingredientq);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
    	boolean isInt = false;
    	try {
    		Integer.parseInt(editQuantityField.getText());
    		isInt = true;
    		
    	} catch (Exception e) {
    		System.out.println("Error: non integer detected");
    	}
    	if (isInt) {
    	 	try (Connection connection = DriverManager.getConnection(Main.URL, Main.USER, Main.PASSWORD)) {
    	 		String query = String.format( "UPDATE Inventory SET ingredientQuantity = ingredientQuantity + %d "
    	 				+ "WHERE ingredientName = '%s';", Integer.parseInt(editQuantityField.getText()), selectIngredientComboBox.getValue());
    	 		Statement stmt = connection.createStatement();
    	 		stmt.executeUpdate(query);
    	 	} catch (SQLException e) {
    	 		e.printStackTrace();
    	 	}
    	}
        try (Connection connection = DriverManager.getConnection(Main.URL, Main.USER, Main.PASSWORD)) {
            String query = String.format("SELECT ingredientQuantity AS ingredient_q FROM Inventory WHERE ingredientName = '%s';", selectIngredientComboBox.getValue());
            try (Statement stmt = connection.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {

                while (rs.next()) {
                    String ingredientq = rs.getString("ingredient_q");
                    lblQuantityInInventory.setText("Quantity in Inventory: " + ingredientq);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleRemoveButtonAction() {
    	boolean isInt = false;
    	boolean isNegative = true;
    	try {
    		Integer.parseInt(editQuantityField.getText());
    		isInt = true;
    		
    	} catch (Exception e) {
    		System.out.println("Error: non integer detected");
    	}
        try (Connection connection = DriverManager.getConnection(Main.URL, Main.USER, Main.PASSWORD)) {
            String query = String.format("SELECT ingredientQuantity AS ingredient_q FROM Inventory WHERE ingredientName = '%s';", selectIngredientComboBox.getValue()); 
            try (Statement stmt = connection.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {

                while (rs.next()) {
                    String ingredientq = rs.getString("ingredient_q");
                    if ((Integer.parseInt(ingredientq) - Integer.parseInt(editQuantityField.getText())) > 0) {
                    	isNegative = false;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    	if (isInt == true && isNegative == false) {
        	// Logic to handle action when the Remove button is clicked
    	 	try (Connection connection = DriverManager.getConnection(Main.URL, Main.USER, Main.PASSWORD)) {
    	 		String query = String.format( "UPDATE Inventory SET ingredientQuantity = ingredientQuantity - %d "
    	 				+ "WHERE ingredientName = '%s';", Integer.parseInt(editQuantityField.getText()), selectIngredientComboBox.getValue());
    	 		Statement stmt = connection.createStatement();
    	 		stmt.executeUpdate(query);
    	 	} catch (SQLException e) {
    	 		e.printStackTrace();
    	 	}
    	}
        try (Connection connection = DriverManager.getConnection(Main.URL, Main.USER, Main.PASSWORD)) {
            String query = String.format("SELECT ingredientQuantity AS ingredient_q FROM Inventory WHERE ingredientName = '%s';", selectIngredientComboBox.getValue());
            try (Statement stmt = connection.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {

                while (rs.next()) {
                    String ingredientq = rs.getString("ingredient_q");
                    lblQuantityInInventory.setText("Quantity in Inventory: " + ingredientq);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleCloseButtonAction() {
    	try {
            Stage stage = (Stage) btnClose.getScene().getWindow();
            stage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
