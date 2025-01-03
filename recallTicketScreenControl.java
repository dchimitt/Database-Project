package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class recallTicketScreenControl {

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

    @FXML
    private void handleRecallButtonAction() {
    	// Logic to handle action when the Recall button is clicked
    }

    @FXML
    private void handleEditButtonAction() {
    	// Logic to handle action when the Edit button is clicked
    }	

    @FXML
    private void handleVoidButtonAction() {
    	// Logic to handle action when the Void button is clicked
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
