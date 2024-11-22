package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.sql.*;

public class timeClockControl {

    // Buttons
    @FXML private Button btnPunch;
    @FXML private Button btnClose;
    
    // Labels
    @FXML private Label lblTimeIn;
    @FXML private Label lblTimeInOutput;
    @FXML private Label lblTimeOutOutput;
    @FXML private Label lblTimeWorked;
    @FXML private Label lblTitle;
    
    // PasswordField
    @FXML private PasswordField employeePinField; 
    
    // ChoiceBox
    @FXML private ChoiceBox<String> employeeListChoiceBox; 
    
    // Other global variables
    private boolean isClockedIn = false;
    private int currentHours;
    private int currentMinutes;
    
    // Initialize is a special JavaFX method that is automatically called by the JavaFX runtime. Use this in any scene that needs to populate data after loading!
    @FXML
    private void initialize() {
        // Load list of employees into the dropdown list when the application starts
        loadEmployeeList();
    }
    
    // Queries the database and loads full list of employee names into the dropdown list
    private void loadEmployeeList() {
        ObservableList<String> employeeNames = FXCollections.observableArrayList();

        try (Connection connection = DriverManager.getConnection(Main.URL, Main.USER, Main.PASSWORD)) {
            String query = "SELECT CONCAT(lname, ', ', fname) AS employee_name FROM Employee;"; 
            try (Statement stmt = connection.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {

                while (rs.next()) {
                    String employeeName = rs.getString("employee_name");
                    employeeNames.add(employeeName); 
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        employeeListChoiceBox.setItems(employeeNames);
    }

    // To clock in and out, use local pin "1234" 
    @FXML
    private void handlePunchButtonAction() {
    	String pin = employeePinField.getText();
    	
    	if (!pin.equals("1234")) {
    		// System.out.println("Invalid PIN."); // print statement for testing invalid pin
    		return;
    	}
    	
    	// Currently does not save clock in time after swapping scenes
    	// Also, does not handle cases where user punches in and then swaps to new employee in dropdown
    	if (!isClockedIn) {
    		// Employee clocks in
    		currentHours = java.time.LocalTime.now().getHour();
    		currentMinutes = java.time.LocalTime.now().getMinute();
    		lblTimeInOutput.setText(String.format("%02d:%02d", currentHours, currentMinutes));
    		lblTimeOutOutput.setText("");
    		lblTimeWorked.setText("0 hours, 0 minutes");
    		isClockedIn = true;
    	}
    	else {
    		// Employee clocks out
    		int punchOutHour = java.time.LocalTime.now().getHour();
    		int punchOutMinute = java.time.LocalTime.now().getMinute();
    		lblTimeOutOutput.setText(String.format("%02d:%02d", punchOutHour, punchOutMinute));
    		int hoursWorked = punchOutHour - currentHours;
    		int minutesWorked = punchOutMinute - currentMinutes;
    		if (minutesWorked < 0) {
    			minutesWorked += 60;
    			hoursWorked--;
    		}
    		lblTimeWorked.setText(String.format("%d hours, %d minutes", hoursWorked, minutesWorked));
    		isClockedIn = false;
    	}
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

