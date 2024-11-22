package application; 

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class deleteEmployeeScreenControl { 

	// Buttons
    @FXML private Button btnDeleteEmployee;
    @FXML private Button btnClose;
    
    // Labels
    @FXML private Label lblSelectAnEmployee;
	
    // ComboBoxes
    @FXML private ComboBox<String> selectAnEmployeeComboBox;

    @FXML
    private void handleDeleteEmployeeButtonAction() {
    	// Logic to handle action when the Delete Employee button is clicked
    }

    @FXML
    private void handleCloseButtonAction() {
    	try {
            AnchorPane databaseSelectScreen = FXMLLoader.load(getClass().getResource("databaseSelectScreen.fxml"));
            
            Scene newScene = new Scene(databaseSelectScreen);
            Stage stage = (Stage) btnClose.getScene().getWindow();
            stage.setScene(newScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
