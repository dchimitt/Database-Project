package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class openingScreenControl {
	
	public static boolean dayStarted;

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
    	Stage stage = (Stage) btnCount.getScene().getWindow();
        stage.setScene(Main.countScreenScene);
        stage.show();
    }

    @FXML
    private void handleStartDayButtonAction() {
    	try {
            Stage stage = (Stage) btnStartDay.getScene().getWindow();
            stage.setScene(Main.backOfficeUIScene);
            stage.show();
            dayStarted = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void handleExitButtonAction() {
        System.exit(0);  
    }
}

