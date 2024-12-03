package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
    
    // ComboBox
    @FXML private ComboBox<String> drawerComboBox;
    
    @FXML
    private void initialize() {
        // Load drawers into the dropdown list
        loadDrawerOptions();
    }
    
    @FXML
    private void loadDrawerOptions() {
        ObservableList<String> drawerOptions = FXCollections.observableArrayList("drawer1", "drawer2");
        drawerComboBox.setItems(drawerOptions);
    }
    
    @FXML
    private void handleCountButtonAction() {
    	Stage stage2 = new Stage();
        stage2.setScene(Main.countScreenScene);
        stage2.show();
    }

    @FXML
    private void handleStartDayButtonAction() {
    	try {
            Stage stage = (Stage) btnStartDay.getScene().getWindow();
            stage.setScene(Main.userInterfaceScene);
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

