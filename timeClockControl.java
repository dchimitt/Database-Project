package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import java.sql.*;

public class timeClockControl {

	//FXML Object Linking
	
    // Buttons
    @FXML private Button btnPunch;
    @FXML private Button btnExit;
    
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
            String query = "SELECT CONCAT(fname, ', ', lname) AS employee_name FROM Employee;"; 
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
    	
    	// Do we want to limit the number of clock in/out's per day to one? 
    	// If not, how should we handle user accidentally clocking out prior to shift end, if at all?
    	// Also currently does not properly handle cases where user switches name in dropdown list and hits punch again (will just clock out) since there is no
    	//      Employee class with a clockedIn variable to track each individually. May want to consider adding one depending on time constraints.
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
    private void handleExitButtonAction() {
        // Assuming this button will not exit the application but transition scenes. Which scene will it go to?
    }
}

