package application;

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

    // Other globals
    private int inventoryCount;

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
