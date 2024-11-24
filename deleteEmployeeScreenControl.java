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

        selectAnEmployeeComboBox.setItems(employeeNames);
    }
    
    @FXML
    private void handleDeleteEmployeeButtonAction() {
    	// Logic to handle action when the Delete Employee button is clicked
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
