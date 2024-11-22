package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent; // this import allows us to make generic methods for the 999999999999999999 buttons in this scene

public class UIControl {	
    
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
	
	// Use pin "4321" to access toolbar button functionality
	@FXML
	private void handleToolbarButtonAction(ActionEvent event) {
		Object source = event.getSource();
		String managerPIN = "4321"; // not yet implemented
		
		if (source == btnRecallTicket) {
			try {
                AnchorPane recallTicketScreen = FXMLLoader.load(getClass().getResource("recallTicketScreen.fxml"));
                
                Scene newScene = new Scene(recallTicketScreen);
                Stage stage = (Stage) btnRecallTicket.getScene().getWindow();
                stage.setScene(newScene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
		}
		else if (source == btnBackOffice) {
			try {
                AnchorPane backOfficeUI = FXMLLoader.load(getClass().getResource("backOfficeUI.fxml"));
                
                Scene newScene = new Scene(backOfficeUI);
                Stage stage = (Stage) btnBackOffice.getScene().getWindow();
                stage.setScene(newScene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
		}
		else if (source == btnManagerFunction) {
			try {
                AnchorPane modifyScreen = FXMLLoader.load(getClass().getResource("modifyScreen.fxml"));
                
                Scene newScene = new Scene(modifyScreen);
                Stage stage = (Stage) btnManagerFunction.getScene().getWindow();
                stage.setScene(newScene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
		}
		else if (source == btnManageDrawers) {
			try {
                AnchorPane drawerManager = FXMLLoader.load(getClass().getResource("drawerManager.fxml"));
                
                Scene newScene = new Scene(drawerManager);
                Stage stage = (Stage) btnManageDrawers.getScene().getWindow();
                stage.setScene(newScene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
		}
		else if (source == btnTimeClock) {
			try {
                AnchorPane timeClockUI = FXMLLoader.load(getClass().getResource("timeClockUI.fxml"));
                
                Scene newScene = new Scene(timeClockUI);
                Stage stage = (Stage) btnTimeClock.getScene().getWindow();
                stage.setScene(newScene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
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
	            AnchorPane noteScreen = FXMLLoader.load(getClass().getResource("noteScreen.fxml"));
	            
	            Scene newScene = new Scene(noteScreen);
	            Stage stage = (Stage) btnAddNote.getScene().getWindow();
	            stage.setScene(newScene);
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
	            AnchorPane tenderScreen = FXMLLoader.load(getClass().getResource("tenderScreen.fxml"));
	            
	            Scene newScene = new Scene(tenderScreen);
	            Stage stage = (Stage) btnTender.getScene().getWindow();
	            stage.setScene(newScene);
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
}
