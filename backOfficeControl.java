package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
            Stage stage = (Stage) btnRecallTickets.getScene().getWindow();
            stage.setScene(Main.recallTicketScreenScene);
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
            Stage stage = (Stage) btnManagerFunction.getScene().getWindow();
            stage.setScene(Main.modifyScreenScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	@FXML
	private void handleManageDrawersButtonAction() {
		try {
            Stage stage = (Stage) btnManageDrawers.getScene().getWindow();
            stage.setScene(Main.drawerManagerScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	@FXML
	private void handleTimeClockButtonAction() {
		try {
			Stage stage = (Stage) btnTimeClock.getScene().getWindow();           
            stage.setScene(Main.timeClockUIScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	@FXML
	private void handleInventoryManagementButtonAction() {
		try {
            Stage stage = (Stage) btnInventoryManagement.getScene().getWindow();
            stage.setScene(Main.inventoryScreenScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	@FXML
	private void handleSchedulesButtonAction() {
		try {
            Stage stage = (Stage) btnSchedules.getScene().getWindow();
            stage.setScene(Main.scheduleBuilderScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	@FXML
	private void handleEditPOSButtonAction() {
		try {
            Stage stage = (Stage) btnEditPOS.getScene().getWindow();
            stage.setScene(Main.editPOSScreenScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	@FXML
	private void handleEmployeeDatabaseButtonAction() {
		try {
            Stage stage = (Stage) btnEmployeeDatabase.getScene().getWindow();
            stage.setScene(Main.databaseSelectScreenScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	@FXML
	private void handleDrawerManagementButtonAction() {
		// NOTE: same functionality as Manage Drawers button. Redundancy
		try {
            Stage stage = (Stage) btnDrawerManagement.getScene().getWindow();
            stage.setScene(Main.drawerManagerScene);
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
	
	// New way to change scenes without reloading (data is preserved)
	@FXML
	private void handleReturnToPOSButtonAction() {
		try {
            Stage stage = (Stage) btnReturnToPOS.getScene().getWindow();           
            stage.setScene(Main.userInterfaceScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
