package application; 

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class deleteEmployeeScreenControl { 

	// FXML Object Linking
	
	// Buttons
    @FXML private Button btnDeleteEmployee;
    @FXML private Button btnClose;
    
    // Labels
    @FXML private Label lblSelectAnEmployee;
	
    // ComboBoxes
    @FXML private ComboBox<String> selectAnEmployeeComboBox;

    @FXML
    private void handleDeleteEmployeeButtonAction() {
    	// Logic to handle action when the Delete Employee button is clicked
    }

    @FXML
    private void handleCloseButtonAction() {
    	// Logic to handle action when the Close button is clicked
    }

}
