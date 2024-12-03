package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class modifyScreenControl implements Initializable{

	// Row 0 Buttons
    @FXML private Button btn0_0;
    @FXML private Button btn0_1;
    @FXML private Button btn0_2;
    @FXML private Button btn0_3;
    
    // Row 1 Buttons
    @FXML private Button btn1_0;
    @FXML private Button btn1_1;
    @FXML private Button btn1_2;
    @FXML private Button btn1_3;
    
    // Row 2 Buttons
    @FXML private Button btn2_0;
    @FXML private Button btn2_1;
    @FXML private Button btn2_2;
    @FXML private Button btn2_3;
    
    // Row 3 Buttons
    @FXML private Button btn3_0;
    @FXML private Button btn3_1;
    @FXML private Button btn3_2;
    @FXML private Button btn3_3;
    
    // Close Button
    @FXML private Button btnClose;

    @FXML
    private void handleGenericButtonAction() {
    	
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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		resetButtons();
	 	if (Main.getLastButtonPressed().equals("Hamburger")) {
	 		btn0_0.setText("+ Cheese");
	 		btn0_1.setText("XT Lett");
	 		btn0_2.setText("XT Tom");
	 		btn0_3.setText("XT Onion");
	 		btn1_0.setText("Extra Patty");
	 		btn1_1.setText("XT Ketchup");
	 		btn1_2.setText("XT Mustard ");
	 		btn1_3.setText("XT Mayo");
	 		btn2_0.setText("+ HOT");
	 		btn2_1.setText("No Bun");
	 		btn2_2.setText("- Lett");
	 		btn2_3.setText("- Tom");
	 		btn3_0.setText("- Onion");
	 		btn3_1.setText("Well Done");
	 	}
	 	else if (Main.getLastButtonPressed().equals("Salad")) {
	 		btn0_0.setText("XT Cumber");
	 		btn0_1.setText("XT Lett");
	 		btn0_2.setText("XT Tom");
	 		btn0_3.setText("XT Carrot");
	 		btn1_0.setText("+ Onion");
	 		btn1_1.setText("+ Cheese");
	 		btn1_2.setText("- Lett");
	 		btn1_3.setText("- Tom");
	 		btn2_0.setText("- Carrot");
	 		btn2_1.setText("- Cumber");
	 	}
	 	else if (Main.getLastButtonPressed().contains("Pizza")) {
	 		btn0_0.setText("XT Cheese");
	 		btn0_1.setText("XT SAUSG");
	 		btn0_2.setText("XT PEPP");
	 		btn0_3.setText("XT Sauce");
	 		btn1_0.setText("+ Onion");
	 		btn1_1.setText("Dbl Dough");
	 		btn1_2.setText("No Cheese");
	 		btn1_3.setText("Uncut");
	 		btn2_0.setText("Well Done");
	 		btn2_1.setText("Lite Cook");
	 		btn2_2.setText("+ HOT");
	 	}
	 	else if (Main.getLastButtonPressed().contentEquals("Steak")) {
	 		btn0_0.setText("XT Garlic");
	 		btn0_1.setText("XT Butter");
	 		btn0_2.setText("XT Salt");
	 		btn0_3.setText("No Garlic");
	 		btn1_0.setText("No Butter");
	 		btn1_1.setText("No Salt");
	 		btn1_2.setText("Rare");
	 		btn1_3.setText("Mid Rare");
	 		btn2_0.setText("Mid");
	 		btn2_1.setText("Mid Well");
	 		btn2_2.setText("Well Done");
	 		btn2_3.setText("+ HOT");
	 	}
	 	else if (Main.getLastButtonPressed().equals("Chicken Tenders")) {
	 		btn0_0.setText("Well Done");
	 		btn0_1.setText("XT Salt");
	 		btn0_2.setText("No Salt");
	 		btn0_3.setText("+ HOT");
	 	}
	 	else if (Main.getLastButtonPressed().equals("Spaghetti")) {
	 		btn0_0.setText("+ Cheese");
	 		btn0_1.setText("+ Onion");
	 		btn0_2.setText("XT Meat");
	 		btn0_3.setText("XT Sauce");
	 		btn1_0.setText("No Meat");
	 		btn1_1.setText("No Sauce");
	 		btn1_2.setText("Plain");
	 	}
	 	else if (Main.getLastButtonPressed().equals("Bean Burrito")) {
	 		btn0_0.setText("+ Lett");
	 		btn0_1.setText("+ Onion");
	 		btn0_2.setText("+ Cheese");
	 		btn0_3.setText("+ Tom");
	 		btn1_0.setText("XT Beans");
	 		btn1_1.setText("XT Rice");
	 		btn1_2.setText("XT Wrap");
	 		btn1_3.setText("XT Clntro");
	 		btn2_0.setText("No Beans");
	 		btn2_1.setText("No Rice");
	 		btn2_2.setText("No Wrap");
	 		btn2_3.setText("No Clntro");
	 	}
	 	else if (Main.getLastButtonPressed().equals("Fries")) {
	 		btn0_0.setText("Well Done");
	 		btn0_1.setText("XT Salt");
	 		btn0_2.setText("No Salt");
	 	}
	 	else if (Main.getLastButtonPressed().equals("Shake")) {
	 		btn0_0.setText("SRWBRY");
	 		btn0_1.setText("CHOC");
	 		btn0_2.setText("+ Oreo");
	 		btn0_3.setText("+ Brownie");
	 		btn1_0.setText("+ Cookie");
	 		btn1_1.setText("Mix Well");
	 	}
	 	setVisibility();
	}
	public void resetButtons() {
		btn0_0.setText("Button");
		btn0_0.setVisible(true);
		btn0_1.setText("Button");
		btn0_1.setVisible(true);
		btn0_2.setText("Button");
		btn0_2.setVisible(true);
		btn0_3.setText("Button");
		btn0_3.setVisible(true);
		btn1_0.setText("Button");
		btn1_0.setVisible(true);
		btn1_1.setText("Button");
		btn1_1.setVisible(true);
		btn1_2.setText("Button");
		btn1_2.setVisible(true);
		btn1_3.setText("Button");
		btn1_3.setVisible(true);
		btn2_0.setText("Button");
		btn2_0.setVisible(true);
		btn2_1.setText("Button");
		btn2_1.setVisible(true);
		btn2_2.setText("Button");
		btn2_2.setVisible(true);
		btn2_3.setText("Button");
		btn2_3.setVisible(true);
		btn3_0.setText("Button");
		btn3_0.setVisible(true);
		btn3_1.setText("Button");
		btn3_1.setVisible(true);
		btn3_2.setText("Button");
		btn3_2.setVisible(true);
		btn3_3.setText("Button");
		btn3_3.setVisible(true);
	}
	public void setVisibility() {
		if (btn0_0.getText().equals("Button")) {
			btn0_0.setVisible(false);
		}
		if (btn0_1.getText().equals("Button")) {
			btn0_1.setVisible(false);
		}
		if (btn0_2.getText().equals("Button")) {
			btn0_2.setVisible(false);
		}
		if (btn0_3.getText().equals("Button")) {
			btn0_3.setVisible(false);
		}
		if (btn1_0.getText().equals("Button")) {
			btn1_0.setVisible(false);
		}
		if (btn1_1.getText().equals("Button")) {
			btn1_1.setVisible(false);
		}
		if (btn1_2.getText().equals("Button")) {
			btn1_2.setVisible(false);
		}
		if (btn1_3.getText().equals("Button")) {
			btn1_3.setVisible(false);
		}
		if (btn2_0.getText().equals("Button")) {
			btn2_0.setVisible(false);
		}
		if (btn2_1.getText().equals("Button")) {
			btn2_1.setVisible(false);
		}
		if (btn2_2.getText().equals("Button")) {
			btn2_2.setVisible(false);
		}
		if (btn2_3.getText().equals("Button")) {
			btn2_3.setVisible(false);
		}
		if (btn3_0.getText().equals("Button")) {
			btn3_0.setVisible(false);
		}
		if (btn3_1.getText().equals("Button")) {
			btn3_1.setVisible(false);
		}
		if (btn3_2.getText().equals("Button")) {
			btn3_2.setVisible(false);
		}
		if (btn3_3.getText().equals("Button")) {
			btn3_3.setVisible(false);
		}
	}
	
}
