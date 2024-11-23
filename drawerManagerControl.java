package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class drawerManagerControl {

	// Buttons
	@FXML private Button btnAssign;
    @FXML private Button btnCount;
    @FXML private Button btnClose;
	
    // Labels
    @FXML private Label lblAssignEmployee;
    @FXML private Label lblAssignDrawer;
    @FXML private Label lblDrawerCount;
    
    // TextFields
    @FXML private TextField drawerCountField;
    
    // ComboBoxes
    @FXML private ComboBox<String> assignEmployeeComboBox;
    @FXML private ComboBox<String> assignDrawerComboBox;

    @FXML
    private void handleAssignButtonAction() {
    	// Logic to handle action when the Assign button is clicked
    }

    @FXML
    private void handleCountButtonAction() {
    	Stage stage = (Stage) btnCount.getScene().getWindow();
        stage.setScene(Main.countScreenScene);
        stage.show();
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

