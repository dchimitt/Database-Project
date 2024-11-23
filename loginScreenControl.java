package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class loginScreenControl {

	// Buttons
	@FXML private Button btnSubmit;
	
	// TextFields
	@FXML private TextField usernameField;
	
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
            // System.out.println("Invalid username or password"); // Do we want to have a label that prints something for invalid login?
        }
    }	
}
