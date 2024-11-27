package application; 

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;

public class employeeAddScreenControl { 

	// Buttons
    @FXML private Button btnSubmit;
    @FXML private Button btnClose;
	
	// TextFields
    @FXML private TextField firstNameField;
    @FXML private TextField lastNameField;
    @FXML private TextField ssnField;
	
	// ChoiceBoxes
    @FXML private ChoiceBox<String> selectPositionChoiceBox;
	
	// DatePicker
    @FXML private DatePicker birthdayDatePicker;

    @FXML 
    private void handleSubmitButtonAction() {
    	// Logic to handle action when the Submit button is clicked
    }

    @FXML
    private void handleCloseButtonAction() {
    	try {
            Stage stage = (Stage) btnClose.getScene().getWindow();
            stage.setScene(Main.databaseSelectScreenScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

