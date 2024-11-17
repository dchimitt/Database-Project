package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class recallTicketScreenControl {

	// FXML Object Linking
	
	// Buttons
    @FXML private Button btnRecall; 
    @FXML private Button btnEdit; 
    @FXML private Button btnVoid; 
    @FXML private Button btnClose;
	
	// Labels
    @FXML private Label lblTicketNumber;
	
	// TextFields
    @FXML private TextField ticketNumberField;
    
	// TextArea
    @FXML private TextArea ticketDetailsTextArea;

    private void handleRecallButtonClick() {
    	// Logic to handle action when the Recall button is clicked
    }

    private void handleEditButtonClick() {
    	// Logic to handle action when the Edit button is clicked
    }	

    private void handleVoidButtonClick() {
    	// Logic to handle action when the Void button is clicked
    }

    private void handleCloseButtonClick() {
    	// Logic to handle action when the Close button is clicked
    }
}
