package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class openingScreenControl {

    // Buttons
	// NOTE: Removed toolbar with redundant buttons and made scene transition to backOfficeUI when hitting Start Day button
	@FXML private Button btnCount;
    @FXML private Button btnStartDay;
    @FXML private Button btnExitPOS;
    
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
    private void handleCountButtonAction() {
    	// Logic to handle action when the Count button is clicked
    }

    @FXML
    private void handleStartDayButtonAction() {
    	try {
            AnchorPane backOfficeUI = FXMLLoader.load(getClass().getResource("backOfficeUI.fxml"));
            
            Scene newScene = new Scene(backOfficeUI);
            Stage stage = (Stage) btnStartDay.getScene().getWindow();
            stage.setScene(newScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void handleExitButtonAction() {
        System.exit(0);  
    }
}

