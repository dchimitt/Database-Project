package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class inventoryScreenControl {

	// FXML Object Linking
	
	// Buttons
    @FXML private Button btnAdd;
    @FXML private Button btnRemove;
    @FXML private Button btnClose;
    
    // Labels
    @FXML private Label lblSelectIngredient;
    @FXML private Label lblEditQuantity;
    @FXML private Label lblQuantityInInventory;
    
    // TextFields
    @FXML private TextField quantityField;
	
    // ComboBoxes
    @FXML private ComboBox<String> selectIngredientComboBox;

    // Other globals
    private int inventoryCount;

    private void handleAddButtonClick() {
    	// Logic to handle action when the Add button is clicked
    }

    private void handleRemoveButtonClick() {
    	// Logic to handle action when the Remove button is clicked
    }

    private void handleCloseButtonClick() {
    	// Logic to handle action when the Close button is clicked
    }
}
