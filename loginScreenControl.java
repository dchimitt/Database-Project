package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class loginScreenControl implements Initializable {

	// Buttons
	@FXML private Button btnSubmit;
	
	// TextFields
	@FXML private TextField usernameField;
	
	//Labels
	@FXML private Label lblValid;
	
	// PasswordFields
	@FXML private PasswordField passwordField;
	
	// Use username "Devyn" and password "4321" to log into POS system
	@FXML
	private void handleSubmitButtonAction() {
        if (usernameField.getText().equals("Devyn") && passwordField.getText().equals("4321")) {
            try {
                Stage stage = (Stage) btnSubmit.getScene().getWindow();
                stage.setScene(Main.openingScreenScene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } 
        else {
            lblValid.setVisible(true);
        }
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblValid.setVisible(false);
		
	}	
}
