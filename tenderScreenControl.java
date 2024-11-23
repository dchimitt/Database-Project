package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class tenderScreenControl {
	
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

    @FXML
    private void handleTenderButtonAction() {
    	// Logic to handle action when the Tender button is clicked
    }

    @FXML
    private void handleCloseButtonAction() {
    	try {
            Stage stage = (Stage) btnClose.getScene().getWindow();
            stage.setScene(Main.userInterfaceScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
