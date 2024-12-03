package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent; // this import allows us to make generic methods for the 999999999999999999 buttons in this scene
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.AnchorPane;

public class UIControl implements Initializable{	
    
	// Toolbar Buttons
	@FXML private Button btnRecallTicket;
	@FXML private Button btnBackOffice;
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
	
	//Handles toolbar button actions
	@FXML
	private void handleToolbarButtonAction(ActionEvent event) {
		Object source = event.getSource();
		String managerPIN = "4321";
		//Opens screen to recall tickets
		if (source == btnRecallTicket) {
			String enteredPIN = promptForPIN();
			if (enteredPIN.equals(managerPIN)) {
				try {
					Stage stage2 = new Stage();
					stage2.setScene(Main.recallTicketScreenScene);
					stage2.show();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		//Back office access. Requires manager pin
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
		//Manage the drawer count and which employee it is assigned to. Requires manager pin.
		else if (source == btnManageDrawers) {
			String enteredPIN = promptForPIN();
			if (enteredPIN.equals(managerPIN)) {
				try {
					Stage stage2  = new Stage();
					stage2.setScene(Main.drawerManagerScene);
					stage2.show();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		//Clock in screen. Will only allow employees to clock in if they are on the schedule
		else if (source == btnTimeClock) {
				try {
					Stage stage2 = new Stage();
					stage2.setScene(Main.timeClockUIScene);
					stage2.show();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	
	//Implements the side bar buttons. See logical methods for reset and load buttons implementations.
	@FXML
	private void handleSideButtonAction(ActionEvent event) {
		Object source = event.getSource();
		
		if (source == btnEntrees) {
			resetButtons();
			loadButtons("Entree");
		}
		else if (source == btnSides) {
			resetButtons();
			loadButtons("Side");
		}
		else if (source == btnDrinks) {
			resetButtons();
			loadButtons("Drink");
		}
		else if (source == btnDesserts) {
			resetButtons();
			loadButtons("Dessert");
		}
		else if (source == btnAllergyFriendly) {
			resetButtons();
			loadButtons("Allergy Friendly");
		}
		else if (source == btnVegetarian) {
			resetButtons();
			loadButtons("Vegetarian");
		}
	}
	
	//Handles the bottom row buttons
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
		 	if (Main.getLastButtonPressed().equals("Hamburger")) {
		 		ticketText.appendText("     + Fries\n     + Fountian Drink\n");
		 		removeFromInventory("Fries");
		 		removeFromInventory("Fountain Drink");
		 	}
		 	else if (Main.getLastButtonPressed().equals("Salad")) {
		 		ticketText.appendText("     + Fountain Drink\n");
		 		removeFromInventory("Fountain Drink");
		 	}
		 	else if (Main.getLastButtonPressed().contains("Pizza")) {
		 		ticketText.appendText("     + Fries\n     + Fountian Drink\n");
		 		removeFromInventory("Fries");
		 		removeFromInventory("Fountain Drink");
		 	}
		 	else if (Main.getLastButtonPressed().equals("Steak")) {
		 		ticketText.appendText("     + Fries\n     + Fountian Drink\n");
		 		removeFromInventory("Fries");
		 		removeFromInventory("Fountain Drink");
		 	}
		 	else if (Main.getLastButtonPressed().equals("Chicken Tenders")) {
		 		ticketText.appendText("     + Fries\n     + Fountian Drink\n");
		 		removeFromInventory("Fries");
		 		removeFromInventory("Fountain Drink");
		 	}
		 	else if (Main.getLastButtonPressed().equals("Spaghetti")) {
		 		ticketText.appendText("     + Chicken Noodle Soup\n     + Fountian Drink\n");
		 		removeFromInventory("Chicken Noodle Soup");
		 		removeFromInventory("Fountain Drink");
		 	}
		 	else if (Main.getLastButtonPressed().equals("Bean Burrito")) {
		 		ticketText.appendText("     + Chips\n     + Fountian Drink\n");
		 		removeFromInventory("Chips");
		 		removeFromInventory("Fountain Drink");
		 	}
		}
		else if (source == btnModify) {
			if (Main.getLastButtonPressed().equals("Hamburger") || Main.getLastButtonPressed().equals("Salad") || 
					Main.getLastButtonPressed().equals("Chicken Tenders") || Main.getLastButtonPressed().equals("Bean Burrito") 
					|| Main.getLastButtonPressed().contains("Pizza") || Main.getLastButtonPressed().equals("Steak") 
					|| Main.getLastButtonPressed().equals("Spaghetti") || Main.getLastButtonPressed().equals("Fries") 
					|| Main.getLastButtonPressed().equals("Shake")) 
			{
				Stage stage2 = new Stage();
				AnchorPane modifyScreen;
				try {
					modifyScreen = FXMLLoader.load(getClass().getResource("modifyScreen.fxml"));
					Scene modifyScreenScene = new Scene(modifyScreen);
					stage2.setScene(modifyScreenScene);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				stage2.show();
			}
		}
		else if (source == btnAllergyAlert) {
			ticketText.appendText("***ALLERGY ALLERT***\n");
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
	
	//Grid buttons will load menu items from the database according to the currently active tab.
	//Buttons with no value are invisible. See logical methods for implementation.
	@FXML
	private void handleGenericButtonAction(ActionEvent event) {
		Object source = event.getSource();
	    
		// Row 0 buttons
	    if (source == btn0_0) {
	    	ticketText.appendText(btn0_0.getText() + "\n");
	    	Main.setLastButtonPressed(btn0_0.getText());
	    	removeFromInventory(btn0_0.getText());
	    } 
	    else if (source == btn0_1) {
	    	ticketText.appendText(btn0_1.getText() + "\n");
	    	Main.setLastButtonPressed(btn0_1.getText());
	    	removeFromInventory(btn0_1.getText());
	    } 
	    else if (source == btn0_2) {
	    	ticketText.appendText(btn0_2.getText() + "\n");
	    	Main.setLastButtonPressed(btn0_2.getText());
	    	removeFromInventory(btn0_2.getText());
	    } 
	    else if (source == btn0_3) {
	    	ticketText.appendText(btn0_3.getText() + "\n");
	    	Main.setLastButtonPressed(btn0_3.getText());
	    	removeFromInventory(btn0_3.getText());
	    }
	    
		// Row 1 buttons
	    else if (source == btn1_0) {
	    	ticketText.appendText(btn1_0.getText() + "\n");
	    	Main.setLastButtonPressed(btn1_0.getText());
	    	removeFromInventory(btn1_0.getText());
	    } 
	    else if (source == btn1_1) {
	    	ticketText.appendText(btn1_1.getText() + "\n");
	    	Main.setLastButtonPressed(btn1_1.getText());
	    	removeFromInventory(btn1_1.getText());
	    } 
	    else if (source == btn1_2) {
	    	ticketText.appendText(btn1_2.getText() + "\n");
	    	Main.setLastButtonPressed(btn1_2.getText());
	    	removeFromInventory(btn1_2.getText());
	    } 
	    else if (source == btn1_3) {
	    	ticketText.appendText(btn1_3.getText() + "\n");
	    	Main.setLastButtonPressed(btn1_3.getText());
	    	removeFromInventory(btn1_3.getText());
	    }
	    
		// Row 2 buttons
	    else if (source == btn2_0) {
	    	ticketText.appendText(btn2_0.getText() + "\n");
	    	Main.setLastButtonPressed(btn2_0.getText());
	    	removeFromInventory(btn2_0.getText());
	    } 
	    else if (source == btn2_1) {
	    	ticketText.appendText(btn2_1.getText() + "\n");
	    	Main.setLastButtonPressed(btn2_1.getText());
	    	removeFromInventory(btn2_1.getText());
	    } 
	    else if (source == btn2_2) {
	    	ticketText.appendText(btn2_2.getText() + "\n");
	    	Main.setLastButtonPressed(btn2_2.getText());
	    	removeFromInventory(btn2_2.getText());
	    } 
	    else if (source == btn2_3) {
	    	ticketText.appendText(btn2_3.getText() + "\n");
	    	Main.setLastButtonPressed(btn2_3.getText());
	    	removeFromInventory(btn2_3.getText());
	    }
	    
		// Row 3 buttons
	    else if (source == btn3_0) {
	    	ticketText.appendText(btn3_0.getText() + "\n");
	    	Main.setLastButtonPressed(btn3_0.getText());
	    	removeFromInventory(btn3_0.getText());
	    } 
	    else if (source == btn3_1) {
	    	ticketText.appendText(btn3_1.getText() + "\n");
	    	Main.setLastButtonPressed(btn3_1.getText());
	    	removeFromInventory(btn3_1.getText());
	    } 
	    else if (source == btn3_2) {
	    	ticketText.appendText(btn3_2.getText() + "\n");
	    	Main.setLastButtonPressed(btn3_2.getText());
	    	removeFromInventory(btn3_2.getText());
	    } 
	    else if (source == btn3_3) {
	    	ticketText.appendText(btn3_3.getText() + "\n");
	    	Main.setLastButtonPressed(btn3_3.getText());
	    	removeFromInventory(btn3_3.getText());
	    }
	    
		// Row 4 buttons
	    else if (source == btn4_0) {
	    	ticketText.appendText(btn4_0.getText() + "\n");
	    	Main.setLastButtonPressed(btn4_0.getText());
	    	removeFromInventory(btn4_0.getText());
	    } 
	    else if (source == btn4_1) {
	    	ticketText.appendText(btn4_1.getText() + "\n");
	    	Main.setLastButtonPressed(btn4_1.getText());
	    	removeFromInventory(btn4_1.getText());
	    } 
	    else if (source == btn4_2) {
	    	ticketText.appendText(btn4_2.getText() + "\n");
	    	Main.setLastButtonPressed(btn4_2.getText());
	    	removeFromInventory(btn4_2.getText());
	    } 
	    else if (source == btn4_3) {
	    	ticketText.appendText(btn4_3.getText() + "\n");
	    	Main.setLastButtonPressed(btn4_3.getText());
	    	removeFromInventory(btn4_3.getText());
	    }
	}
	
	//Logical methods
	
	private String promptForPIN() {
	    // Show a dialog for PIN input and return the entered value
	    TextInputDialog dialog = new TextInputDialog();
	    dialog.setHeaderText("Enter PIN to proceed");
	    dialog.setContentText("PIN:");
	    return dialog.showAndWait().orElse(""); // Returns the PIN entered by the user
	}
	private void loadButtons(String tab) {
		ArrayList<String> items = new ArrayList<String>();
		if (tab.contentEquals("Allergy Friendly")) {
		 	try (Connection connection = DriverManager.getConnection(Main.URL, Main.USER, Main.PASSWORD)) {
		 		String query = "SELECT itemName AS menu_item FROM MenuItem WHERE glutenFreeStatus = 'Yes';";
		 		try (Statement stmt = connection.createStatement();
		 				ResultSet rs = stmt.executeQuery(query)) {
		 			while (rs.next()) {
		 				String menuItems = rs.getString("menu_item");
		 				items.add(menuItems);
		 			}
		 		}
		 	} catch (SQLException e) {
		 		e.printStackTrace();
		 	}
		}
		else if (tab.contentEquals("Vegetarian")) {
		 	try (Connection connection = DriverManager.getConnection(Main.URL, Main.USER, Main.PASSWORD)) {
		 		String query = "SELECT itemName AS menu_item FROM MenuItem WHERE vegetarianStatus = 'Yes';";
		 		try (Statement stmt = connection.createStatement();
		 				ResultSet rs = stmt.executeQuery(query)) {
		 			while (rs.next()) {
		 				String menuItems = rs.getString("menu_item");
		 				items.add(menuItems);
		 			}
		 		}
		 	} catch (SQLException e) {
		 		e.printStackTrace();
		 	}
		}
		else {
		 	try (Connection connection = DriverManager.getConnection(Main.URL, Main.USER, Main.PASSWORD)) {
		 		String query = String.format( "SELECT itemName AS menu_item FROM MenuItem WHERE typeItem = '%s';", tab);
		 		try (Statement stmt = connection.createStatement();
		 				ResultSet rs = stmt.executeQuery(query)) {
		 			while (rs.next()) {
		 				String menuItems = rs.getString("menu_item");
		 				items.add(menuItems);
		 			}
		 		}
		 	} catch (SQLException e) {
		 		e.printStackTrace();
		 	}
		}
			int numberOfItems = items.size();
			if (numberOfItems > 0 && btn0_0.getText().contains("Button")) {
				btn0_0.setText(items.get(numberOfItems - 1));
				numberOfItems--;
			}
			else {
				btn0_0.setVisible(false);
			}
			if (numberOfItems > 0 && btn0_1.getText().contains("Button")) {
				btn0_1.setText(items.get(numberOfItems - 1));
				numberOfItems--;
			}
			else {
				btn0_1.setVisible(false);
			}
			if (numberOfItems > 0 && btn0_2.getText().contains("Button")) {
				btn0_2.setText(items.get(numberOfItems - 1));
				numberOfItems--;
			}
			else {
				btn0_2.setVisible(false);
			}
			if (numberOfItems > 0 && btn0_3.getText().contains("Button")) {
				btn0_3.setText(items.get(numberOfItems - 1));
				numberOfItems--;
			}
			else {
				btn0_3.setVisible(false);
			}
			if (numberOfItems > 0 && btn1_0.getText().contains("Button")) {
				btn1_0.setText(items.get(numberOfItems - 1));
				numberOfItems--;
			}
			else {
				btn1_0.setVisible(false);
			}
			if (numberOfItems > 0 && btn1_1.getText().contains("Button")) {
				btn1_1.setText(items.get(numberOfItems - 1));
				numberOfItems--;
			}
			else {
				btn1_1.setVisible(false);
			}
			if (numberOfItems > 0 && btn1_2.getText().contains("Button")) {
				btn1_2.setText(items.get(numberOfItems - 1));
				numberOfItems--;
			}
			else {
				btn1_2.setVisible(false);
			}
			if (numberOfItems > 0 && btn1_3.getText().contains("Button")) {
				btn1_3.setText(items.get(numberOfItems - 1));
				numberOfItems--;
			}
			else {
				btn1_3.setVisible(false);
			}
			if (numberOfItems > 0 && btn2_0.getText().contains("Button")) {
				btn2_0.setText(items.get(numberOfItems - 1));
				numberOfItems--;
			}
			else {
				btn2_0.setVisible(false);
			}
			if (numberOfItems > 0 && btn2_1.getText().contains("Button")) {
				btn2_1.setText(items.get(numberOfItems - 1));
				numberOfItems--;
			}
			else {
				btn2_1.setVisible(false);
			}
			if (numberOfItems > 0 && btn2_2.getText().contains("Button")) {
				btn2_2.setText(items.get(numberOfItems - 1));
				numberOfItems--;
			}
			else {
				btn2_2.setVisible(false);
			}
			if (numberOfItems > 0 && btn2_3.getText().contains("Button")) {
				btn2_3.setText(items.get(numberOfItems - 1));
				numberOfItems--;
			}
			else {
				btn2_3.setVisible(false);
			}
			if (numberOfItems > 0 && btn3_0.getText().contains("Button")) {
				btn3_0.setText(items.get(numberOfItems - 1));
				numberOfItems--;
			}
			else {
				btn3_0.setVisible(false);
			}
			if (numberOfItems > 0 && btn3_1.getText().contains("Button")) {
				btn3_1.setText(items.get(numberOfItems - 1));
				numberOfItems--;
			}
			else {
				btn3_1.setVisible(false);
			}
			if (numberOfItems > 0 && btn3_2.getText().contains("Button")) {
				btn3_2.setText(items.get(numberOfItems - 1));
				numberOfItems--;
			}
			else {
				btn3_2.setVisible(false);
			}
			if (numberOfItems > 0 && btn3_3.getText().contains("Button")) {
				btn3_3.setText(items.get(numberOfItems - 1));
				numberOfItems--;
			}
			else {
				btn3_3.setVisible(false);
			}
			if (numberOfItems > 0 && btn4_0.getText().contains("Button")) {
				btn4_0.setText(items.get(numberOfItems - 1));
				numberOfItems--;
			}
			else {
				btn4_0.setVisible(false);
			}
			if (numberOfItems > 0 && btn4_1.getText().contains("Button")) {
				btn4_1.setText(items.get(numberOfItems - 1));
				numberOfItems--;
			}
			else {
				btn4_1.setVisible(false);
			}
			if (numberOfItems > 0 && btn4_2.getText().contains("Button")) {
				btn4_2.setText(items.get(numberOfItems - 1));
				numberOfItems--;
			}
			else {
				btn4_2.setVisible(false);
			}
			if (numberOfItems > 0 && btn4_3.getText().contains("Button")) {
				btn4_3.setText(items.get(numberOfItems - 1));
				numberOfItems--;
			}
			else {
				btn4_3.setVisible(false);
			}
	}
	private void resetButtons() {
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
		btn4_0.setText("Button");
		btn4_0.setVisible(true);
		btn4_1.setText("Button");
		btn4_1.setVisible(true);
		btn4_2.setText("Button");
		btn4_2.setVisible(true);
		btn4_3.setText("Button");
		btn4_3.setVisible(true);
	}
	private void removeFromInventory(String item) {
		ArrayList <String> ingredientNames = new ArrayList<String>();
		ArrayList <Integer> ingredientUsage = new ArrayList<Integer>();
	 	try (Connection connection = DriverManager.getConnection(Main.URL, Main.USER, Main.PASSWORD)) {
	 		String query = String.format( "SELECT inventoryIngredientName AS name_ingredient, ingredientAmntUsed AS"
	 				+ " num_ingredient FROM MenuIngredientUsage WHERE menuItemName = '%s';", item);
	 		try (Statement stmt = connection.createStatement();
	 				ResultSet rs = stmt.executeQuery(query)) {
	 			while (rs.next()) {
	 				String name = rs.getString("name_ingredient");
	 				String usage = rs.getString("num_ingredient");
	 				ingredientNames.add(name);
	 				ingredientUsage.add(Integer.parseInt(usage));
	 			}
	 		}
	 	} catch (SQLException e) {
	 		e.printStackTrace();
	 	}
	 	for(int i = 0; i < ingredientNames.size(); i++) {
		 	try (Connection connection = DriverManager.getConnection(Main.URL, Main.USER, Main.PASSWORD)) {
		 		String query = String.format( "UPDATE Inventory SET ingredientQuantity = ingredientQuantity - %d "
		 				+ "WHERE ingredientName = '%s';", ingredientUsage.get(i), ingredientNames.get(i));
		 		Statement stmt = connection.createStatement();
		 		stmt.executeUpdate(query);
		 	} catch (SQLException e) {
		 		e.printStackTrace();
		 	}
	 	}
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		loadButtons("Entree");
	}
}
