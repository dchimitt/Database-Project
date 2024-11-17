package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class drawerManagerControl {

	//FXML Object Linking
	
	// Buttons
	@FXML private Button btnAssign;
    @FXML private Button btnCount;
    @FXML private Button btnClose;
	
    // Labels
    @FXML private Label lblAssignEmployee;
    @FXML private Label lblAssignDrawer;
    @FXML private Label lblDrawerCount;
    
    // TextFields
    @FXML private TextField drawerCountField;
    
    // ComboBoxes
    @FXML private ComboBox<String> assignEmployeeComboBox;
    @FXML private ComboBox<String> assignDrawerComboBox;


    private void handleAssignButtonClick() {
    	// Logic to handle action when the Assign button is clicked
    }

    private void handleCountButtonClick() {
    	// Logic to handle action when the Count button is clicked
    }

    private void handleCloseButtonClick() {
    	// Logic to handle action when the Close button is clicked
    }
}

