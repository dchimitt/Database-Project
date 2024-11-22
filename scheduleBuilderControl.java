package application; 

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

public class scheduleBuilderControl { 

	// Buttons
	@FXML private Button btnAddToSchedule;
	@FXML private Button btnClose;
	
	// Labels
	@FXML private Label lblSelectAnEmployee;
	@FXML private Label lblSelectDay;
	@FXML private Label lblTimeIn;
	@FXML private Label lblTimeOut;
	
	// TextFields
    @FXML private TextField timeInField;
    @FXML private TextField timeOutField;
    
    // TextAreas
    @FXML private TextArea scheduleTextArea;
    
    // ComboBoxes
    @FXML private ComboBox<String> selectAnEmployeeComboBox;
    
    // DatePickers
    @FXML private DatePicker selectDayDatePicker;

    @FXML
    private void handleAddToScheduleButtonAction() {
    	// Logic to handle action when the Add To Schedule button is clicked
    }
    
    @FXML
    private void handleCloseButtonAction() {
    	try {
            AnchorPane backOfficeUI = FXMLLoader.load(getClass().getResource("backOfficeUI.fxml"));
            
            Scene newScene = new Scene(backOfficeUI);
            Stage stage = (Stage) btnClose.getScene().getWindow();
            stage.setScene(newScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}