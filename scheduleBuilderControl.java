package application; 

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
            Stage stage = (Stage) btnClose.getScene().getWindow();
            stage.setScene(Main.backOfficeUIScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}