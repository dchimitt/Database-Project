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

public class editPOSScreenControl {

	// Buttons
    @FXML private Button btnAssignLeft;
    @FXML private Button btnAssignRight;
    @FXML private Button btnMoveRight;
    @FXML private Button btnMoveLeft;
    @FXML private Button btnClose;
    
    // Labels
    @FXML private Label lblAddIngredient;
    @FXML private Label lblAssignAButtonLeft;
    @FXML private Label lblAssignAButtonRight;
    @FXML private Label lblAddMenuItem;
    @FXML private Label lblSelectIngredient;
    @FXML private Label lblSelectMenuItem;
    @FXML private Label lblAssignToButtonLeft;
    @FXML private Label lblAssignToButtonRight;
    
    // TextFields
    @FXML private TextField addIngredientField;
    @FXML private TextField addMenuItemField;
    
    // ComboBoxes
    @FXML private ComboBox<String> assignAButtonComboBoxLeft;
    @FXML private ComboBox<String> assignAButtonComboBoxRight;
    @FXML private ComboBox<String> ingredientComboBox;
    @FXML private ComboBox<String> ingredientComboBoxRight;
    @FXML private ComboBox<String> selectMenuComboBox;
    @FXML private ComboBox<String> assignToButtonComboBoxLeft;
    @FXML private ComboBox<String> assignToButtonComboBoxRight;

    @FXML
    private void handleAssignLeftButtonAction() {
    	// Logic to handle action when the left Assign button is clicked
    }
    
    @FXML
    private void handleAssignRightButtonAction() {
    	// Logic to handle action when the right Assign button is clicked
    }
    
    @FXML
    private void handleMoveLeftButtonAction() {
    	// Logic to handle action when the left Move button is clicked
    }
    
    @FXML
    private void handleMoveRightButtonAction() {
    	// Logic to handle action when the right Move button is clicked
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
