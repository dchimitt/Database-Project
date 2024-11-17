package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class modifyScreenControl {

	// FXML Object Linking
	
	// Row 0 Buttons
    @FXML private Button btn0_1;
    @FXML private Button btn0_2;
    @FXML private Button btn0_3;
    @FXML private Button btn0_4;
    
    // Row 1 Buttons
    @FXML private Button btn1_1;
    @FXML private Button btn1_2;
    @FXML private Button btn1_3;
    @FXML private Button btn1_4;
    
    // Row 2 Buttons
    @FXML private Button btn2_1;
    @FXML private Button btn2_2;
    @FXML private Button btn2_3;
    @FXML private Button btn2_4;
    
    // Row 3 Buttons
    @FXML private Button btn3_1;
    @FXML private Button btn3_2;
    @FXML private Button btn3_3;
    @FXML private Button btn3_4;
    
    // Close Button
    @FXML private Button btnClose;

    private void handleGenericButtonClick() {
        // Do we want 16 methods here, or just choose with conditionals based on button .getText()? Probably the latter.
    }

    private void handleCloseButtonClick() {
    	// Logic to handle action when the Close button is clicked
    }
}
