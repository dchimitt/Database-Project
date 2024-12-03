package application; 

import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
            Stage stage = (Stage) btnEmployeeOnboard.getScene().getWindow();
            stage.setScene(Main.employeeAddScreenScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }   
    }

    @FXML
    private void handleEmployeeDeletionButtonAction() {
    	try {
            Stage stage = (Stage) btnEmployeeDeletion.getScene().getWindow();
            stage.setScene(Main.deleteEmployeeScreenScene);
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
            Stage stage = (Stage) btnClose.getScene().getWindow();
            stage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }   
    }
}
