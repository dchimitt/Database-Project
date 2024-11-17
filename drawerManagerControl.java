package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class drawerManagerControl {

	//FXML Object Linking
	
	// Buttons
	@FXML private Button assignButton;
    @FXML private Button countButton;
    @FXML private Button closeButton;
	
    // Labels
    @FXML private Label assignEmployeeLabel;
    @FXML private Label assignDrawerLabel;
    @FXML private Label drawerCountLabel;
    
    // TextFields
    @FXML private TextField drawerCountTextField;
    
    // ComboBoxes
    @FXML private ComboBox<String> employeeComboBox;
    @FXML private ComboBox<String> drawerComboBox;


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

