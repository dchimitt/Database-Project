package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class tenderScreenControl {

	// FXML Object Linking
	
	// Buttons
    @FXML private Button btnTender; 
    @FXML private Button btnClose;
	
	// Labels
    @FXML private Label lblSelectPaymentType;
    @FXML private Label lblPaymentAmount;
    @FXML private Label lblChangeDue;
	
	// TextFields
    @FXML private TextField paymentAmountField;
	
	// ComboBox
    @FXML private ComboBox<String> paymentTypeComboBox;

    private void handleTenderButtonClick() {
    	// Logic to handle action when the Tender button is clicked
    }

    private void handleCloseButtonClick() {
    	// Logic to handle action when the Close button is clicked
    }
}
