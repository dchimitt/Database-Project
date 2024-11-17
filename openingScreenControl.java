package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class openingScreenControl {

    // FXML Object Linking

    // Buttons
	@FXML private Button btnCount;
    @FXML private Button btnStartDay;
    @FXML private Button btnExit;
    @FXML private Button btnTimeClock;
    @FXML private Button btnBackOffice;
    
    // Labels
    @FXML private Label lblWelcome;
    @FXML private Label lblPosBackOffice;
    @FXML private Label lblStartingTicketNumber;
    @FXML private Label lblSelectDrawer;
    @FXML private Label lblStartingCashCount;
    
    // Text Fields
    @FXML private TextField startingTicketNumberField;
    @FXML private TextField startingCashCountField;
    
    // ChoiceBox
    @FXML private ChoiceBox<String> drawerChoiceBox;

    @FXML
    private void handleTimeClockButtonAction() {
    	// Logic to handle action when the Time Clock button is clicked
    }

    @FXML
    private void handleBackOfficeButtonAction() {
    	// Logic to handle action when the Back Office button is clicked
    }
    
    @FXML
    private void handleCountButtonAction() {
    	// Logic to handle action when the Count button is clicked
    }

    @FXML
    private void handleStartDayButtonAction() {
    	// Logic to handle action when the Start Day button is clicked
    }
    
    @FXML
    private void handleExitButtonAction() {
    	// Exit the GUI application
        System.exit(0);  
    }
}

