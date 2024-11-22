package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class backOfficeControl {	
	
	// Buttons
	// NOTE: some redundancy in toolbar transition buttons. Unsure if intended
	@FXML private Button btnRecallTickets;
	@FXML private Button btnBackOffice;
	@FXML private Button btnManagerFunction;
	@FXML private Button btnManageDrawers;
	@FXML private Button btnTimeClock;
	@FXML private Button btnInventoryManagement;
	@FXML private Button btnSchedules;
	@FXML private Button btnEditPOS;
	@FXML private Button btnEmployeeDatabase;
	@FXML private Button btnDrawerManagement;
	@FXML private Button btnSalesReport;
	@FXML private Button btnExitPOS;
	@FXML private Button btnReturnToPOS; // what scene will this transition to?
	
	@FXML
	private void handleRecallTicketsButtonAction() {
		try {
            AnchorPane recallTicketScreen = FXMLLoader.load(getClass().getResource("recallTicketScreen.fxml"));
            
            Scene newScene = new Scene(recallTicketScreen);
            Stage stage = (Stage) btnRecallTickets.getScene().getWindow();
            stage.setScene(newScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	@FXML
	private void handleBackOfficeButtonAction() {
		// Already in backOfficeUI, redundant button
	}
	
	@FXML
	private void handleManagerFunctionButtonAction() {
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
	
	@FXML
	private void handleManageDrawersButtonAction() {
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
	
	@FXML
	private void handleTimeClockButtonAction() {
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
	
	@FXML
	private void handleInventoryManagementButtonAction() {
		try {
            AnchorPane inventoryManagement = FXMLLoader.load(getClass().getResource("inventoryScreen.fxml"));
            
            Scene newScene = new Scene(inventoryManagement);
            Stage stage = (Stage) btnInventoryManagement.getScene().getWindow();
            stage.setScene(newScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	@FXML
	private void handleSchedulesButtonAction() {
		try {
            AnchorPane scheduleBuilder = FXMLLoader.load(getClass().getResource("scheduleBuilder.fxml"));
            
            Scene newScene = new Scene(scheduleBuilder);
            Stage stage = (Stage) btnSchedules.getScene().getWindow();
            stage.setScene(newScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	@FXML
	private void handleEditPOSButtonAction() {
		try {
            AnchorPane editPOSScreen = FXMLLoader.load(getClass().getResource("editPOSScreen.fxml"));
            
            Scene newScene = new Scene(editPOSScreen);
            Stage stage = (Stage) btnEditPOS.getScene().getWindow();
            stage.setScene(newScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	@FXML
	private void handleEmployeeDatabaseButtonAction() {
		try {
            AnchorPane databaseSelectScreen = FXMLLoader.load(getClass().getResource("databaseSelectScreen.fxml"));
            
            Scene newScene = new Scene(databaseSelectScreen);
            Stage stage = (Stage) btnEmployeeDatabase.getScene().getWindow();
            stage.setScene(newScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	@FXML
	private void handleDrawerManagementButtonAction() {
		// NOTE: same functionality as Manage Drawers button. Redundancy
		try {
            AnchorPane countScreen = FXMLLoader.load(getClass().getResource("countScreen.fxml"));
            
            Scene newScene = new Scene(countScreen);
            Stage stage = (Stage) btnDrawerManagement.getScene().getWindow();
            stage.setScene(newScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	@FXML
	private void handleSalesReportButtonAction() {
		// Scene not implemented yet?
	}
	
	@FXML
	private void handleExitPOSButtonAction() {
		System.exit(0);
	}
	
	@FXML
	private void handleReturnToPOSButtonAction() {
		try {
            BorderPane userInterface = FXMLLoader.load(getClass().getResource("userInterface.fxml"));
            
            Scene newScene = new Scene(userInterface);
            Stage stage = (Stage) btnReturnToPOS.getScene().getWindow();
            stage.setScene(newScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
