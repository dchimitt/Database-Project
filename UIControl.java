package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.event.ActionEvent; // this import allows us to make generic methods for the 999999999999999999 buttons in this scene
import javafx.scene.control.TextInputDialog;

public class UIControl {	
	
	public static boolean managerEnteredPINForTimeClock; // Used to choose which scene to swap from timeClockUI depending where it was accessed (employee view vs manager view)
    
	// Toolbar Buttons
	@FXML private Button btnRecallTicket;
	@FXML private Button btnBackOffice;
	@FXML private Button btnManagerFunction;
	@FXML private Button btnManageDrawers;
	@FXML private Button btnTimeClock;
	
	// Side Buttons
	@FXML private Button btnEntrees;
	@FXML private Button btnSides;
	@FXML private Button btnDrinks;
	@FXML private Button btnDesserts;
	@FXML private Button btnAllergyFriendly;
	@FXML private Button btnVegetarian;
	
	// Bottom Row Buttons
	@FXML private Button btnAddNote;
	@FXML private Button btnMakeMeal;
	@FXML private Button btnModify;
	@FXML private Button btnAllergyAlert;
	@FXML private Button btnTender;
	
	// Row 0 buttons
	@FXML private Button btn0_0;
	@FXML private Button btn0_1;
	@FXML private Button btn0_2;
	@FXML private Button btn0_3;
	
	// Row 1 buttons
	@FXML private Button btn1_0;
	@FXML private Button btn1_1;
	@FXML private Button btn1_2;
	@FXML private Button btn1_3;
	
	// Row 2 buttons
	@FXML private Button btn2_0;
	@FXML private Button btn2_1;
	@FXML private Button btn2_2;
	@FXML private Button btn2_3;
	
	// Row 3 buttons
	@FXML private Button btn3_0;
	@FXML private Button btn3_1;
	@FXML private Button btn3_2;
	@FXML private Button btn3_3;
	
	// Row 4 buttons
	@FXML private Button btn4_0;
	@FXML private Button btn4_1;
	@FXML private Button btn4_2;
	@FXML private Button btn4_3;
	
	// TextAreas
	@FXML private TextArea ticketText;
	
	// Use this for access to toolbar buttons
	
	
	// Use pin "4321" to access toolbar button functionality
	@FXML
	private void handleToolbarButtonAction(ActionEvent event) {
		Object source = event.getSource();
		String managerPIN = "4321"; // not yet implemented
		
		if (source == btnRecallTicket) {
			String enteredPIN = promptForPIN();
			if (enteredPIN.equals(managerPIN)) {
				try {
					Stage stage = (Stage) btnRecallTicket.getScene().getWindow();
					stage.setScene(Main.recallTicketScreenScene);
					stage.show();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		else if (source == btnBackOffice) {
			String enteredPIN = promptForPIN();
			if (enteredPIN.equals(managerPIN)) {
				try {
					Stage stage = (Stage) btnBackOffice.getScene().getWindow();
					stage.setScene(Main.backOfficeUIScene);
					stage.show();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		else if (source == btnManagerFunction) {
			String enteredPIN = promptForPIN();
			if (enteredPIN.equals(managerPIN)) {
				try {
					Stage stage = (Stage) btnManagerFunction.getScene().getWindow();
					stage.setScene(Main.modifyScreenScene);
					stage.show();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		else if (source == btnManageDrawers) {
			String enteredPIN = promptForPIN();
			if (enteredPIN.equals(managerPIN)) {
				try {
					Stage stage = (Stage) btnManageDrawers.getScene().getWindow();
					stage.setScene(Main.drawerManagerScene);
					stage.show();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		else if (source == btnTimeClock) {
			String enteredPIN = promptForPIN();
			if (enteredPIN.equals(managerPIN)) {
				try {
					managerEnteredPINForTimeClock = true;
					Stage stage = (Stage) btnTimeClock.getScene().getWindow();
					stage.setScene(Main.timeClockUIScene);
					stage.show();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	@FXML
	private void handleSideButtonAction(ActionEvent event) {
		Object source = event.getSource();
		
		if (source == btnEntrees) {
			
		}
		else if (source == btnSides) {
			
		}
		else if (source == btnDrinks) {
			
		}
		else if (source == btnDesserts) {
			
		}
		else if (source == btnAllergyFriendly) {
			
		}
		else if (source == btnVegetarian) {
			
		}
	}
	
	@FXML
	private void handleBottomRowButtonAction(ActionEvent event) {
		Object source = event.getSource();
		
		if (source == btnAddNote) {
			try {
	            Stage stage = (Stage) btnAddNote.getScene().getWindow();
	            stage.setScene(Main.noteScreenScene);
	            stage.show();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		}
		else if (source == btnMakeMeal) {
			
		}
		else if (source == btnModify) {
			
		}
		else if (source == btnAllergyAlert) {
			
		}
		else if (source == btnTender) {
			try {
	            Stage stage = (Stage) btnTender.getScene().getWindow();
	            stage.setScene(Main.tenderScreenScene);
	            stage.show();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		}
	}
	
	@FXML
	private void handleGenericButtonAction(ActionEvent event) {
		Object source = event.getSource();
	    
		// Row 0 buttons
	    if (source == btn0_0) {

	    } 
	    else if (source == btn0_1) {

	    } 
	    else if (source == btn0_2) {

	    } 
	    else if (source == btn0_3) {

	    }
	    
		// Row 1 buttons
	    else if (source == btn1_0) {

	    } 
	    else if (source == btn1_1) {

	    } 
	    else if (source == btn1_2) {

	    } 
	    else if (source == btn1_3) {

	    }
	    
		// Row 2 buttons
	    else if (source == btn2_0) {

	    } 
	    else if (source == btn2_1) {

	    } 
	    else if (source == btn2_2) {

	    } 
	    else if (source == btn2_3) {

	    }
	    
		// Row 3 buttons
	    else if (source == btn3_0) {

	    } 
	    else if (source == btn3_1) {

	    } 
	    else if (source == btn3_2) {

	    } 
	    else if (source == btn3_3) {

	    }
	    
		// Row 4 buttons
	    else if (source == btn4_0) {

	    } 
	    else if (source == btn4_1) {

	    } 
	    else if (source == btn4_2) {

	    } 
	    else if (source == btn4_3) {

	    }
	}
	
	private String promptForPIN() {
	    // Show a dialog for PIN input and return the entered value
	    TextInputDialog dialog = new TextInputDialog();
	    dialog.setHeaderText("Enter PIN to proceed");
	    dialog.setContentText("PIN:");
	    return dialog.showAndWait().orElse(""); // Returns the PIN entered by the user
	}
}
