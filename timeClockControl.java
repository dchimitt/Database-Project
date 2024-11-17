package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

public class timeClockControl {

	//FXML Object Linking
	
    // Buttons
    @FXML private Button btnPunch;
    @FXML private Button btnExit;
    
    // Labels
    @FXML private Label lblTimeIn;
    @FXML private Label lblTimeInOutput;
    @FXML private Label lblTimeOutOutput;
    @FXML private Label lblTimeWorked;
    @FXML private Label lblTitle;
    
    // PasswordField
    @FXML private PasswordField passwordField; // rename as needed, unsure of function at the moment
    
    // ChoiceBox
    @FXML private ChoiceBox<String> choiceBox; // rename as needed, unsure of function at the moment

    @FXML
    // Handle the action when the Punch button is clicked
    private void handlePunchButtonAction() {
    	
    }

    @FXML
    private void handleExitButtonAction() {
        System.exit(0);
    }
}

