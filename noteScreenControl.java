package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class noteScreenControl {

	// Buttons
    @FXML private Button btnAddNote;
    @FXML private Button btnClose;
    
    // TextArea
    @FXML private TextArea noteText;

    @FXML
    private void handleAddNoteButtonAction() {
    	// Logic to handle action when the Add Note button is clicked
    }

    @FXML
    private void handleCloseButtonAction() {
    	try {
            Stage stage = (Stage) btnClose.getScene().getWindow();
            stage.setScene(Main.userInterfaceScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
