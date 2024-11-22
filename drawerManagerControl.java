package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
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
    	// Logic to handle action when the Count button is clicked
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

