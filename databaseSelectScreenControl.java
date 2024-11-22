package application; 

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class databaseSelectScreenControl { 

	// Buttons
    @FXML private Button btnEmployeeOnboard;
    @FXML private Button btnEmployeeDeletion;
    @FXML private Button btnUpdateEmployee;
    @FXML private Button btnClose;

    @FXML
    private void handleEmployeeOnboardButtonAction() {
    	try {
            AnchorPane employeeAddScreen = FXMLLoader.load(getClass().getResource("employeeAddScreen.fxml"));
            
            Scene newScene = new Scene(employeeAddScreen);
            Stage stage = (Stage) btnEmployeeOnboard.getScene().getWindow();
            stage.setScene(newScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }   
    }

    @FXML
    private void handleEmployeeDeletionButtonAction() {
    	try {
            AnchorPane deleteEmployeeScreen = FXMLLoader.load(getClass().getResource("deleteEmployeeScreen.fxml"));
            
            Scene newScene = new Scene(deleteEmployeeScreen);
            Stage stage = (Stage) btnEmployeeDeletion.getScene().getWindow();
            stage.setScene(newScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }   
    }

    @FXML
    private void handleUpdateEmployeeButtonAction() {
    	// Unsure on this transition
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
