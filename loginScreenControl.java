package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class loginScreenControl {
	
	@FXML
	private TextField usernameField;
	@FXML
	private PasswordField passwordField;
	@FXML
	private Button submitButton;
	@FXML
	private void login() {
		if (usernameField.getText().equals("Devyn") && passwordField.getText().equals("1234")) {
			
		}
	}
	
}
