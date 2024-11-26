package application; 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class deleteEmployeeScreenControl { 

	// Buttons
    @FXML private Button btnDeleteEmployee;
    @FXML private Button btnClose;
    
    // Labels
    @FXML private Label lblSelectAnEmployee;
	
    // ComboBoxes
    @FXML private ComboBox<String> selectAnEmployeeComboBox;

    @FXML
    private void initialize() {
        // Load list of employees into the dropdown list when the application starts
        loadEmployeeList();
    }
    
    // Queries the database and loads full list of employee names into the dropdown list
    private void loadEmployeeList() {
        ObservableList<String> employeeNames = FXCollections.observableArrayList();

        try (Connection connection = DriverManager.getConnection(Main.URL, Main.USER, Main.PASSWORD)) {
        	String query = "SELECT CONCAT(lname, ', ', fname) AS employee_name, isActive FROM Employee WHERE isActive = TRUE ORDER BY lname;"; 
            try (Statement stmt = connection.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {

                while (rs.next()) {
                    String employeeName = rs.getString("employee_name");
                    boolean isActive = rs.getBoolean("isActive");
                    
                    // Do not load employees into the list if their isActive attribute is currently false
                    if (isActive) {
                    	employeeNames.add(employeeName); 
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        selectAnEmployeeComboBox.setItems(employeeNames);
    }
    
    @FXML
    private void handleDeleteEmployeeButtonAction() {
    	// Put first and last name into an array of Strings
        String[] employeeName = selectAnEmployeeComboBox.getValue().split(", ");
        String lname = employeeName[0].trim();
        String fname = employeeName[1].trim();

        try (Connection connection = DriverManager.getConnection(Main.URL, Main.USER, Main.PASSWORD)) {
            try (Statement stmt = connection.createStatement()) {
                String query = "UPDATE Employee SET isActive = FALSE WHERE lname = '" + lname + "' AND fname = '" + fname + "';";
                
                // Update the employee tuple with isActive = false, then reload the list of employees
                stmt.executeUpdate(query);
                loadEmployeeList();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleCloseButtonAction() {
    	try {
            Stage stage = (Stage) btnClose.getScene().getWindow();
            stage.setScene(Main.databaseSelectScreenScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
