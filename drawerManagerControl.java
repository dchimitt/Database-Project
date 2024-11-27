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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class drawerManagerControl {

	// Buttons
	@FXML private Button btnAssign;
    @FXML private Button btnCount;
    @FXML private Button btnClose;
	
    // Labels
    @FXML private Label lblAssignEmployee;
    @FXML private Label lblAssignDrawer;
    @FXML private Label lblDrawerCount;
    
    // TextFields
    @FXML private TextField drawerCountField;
    
    // ComboBoxes
    @FXML private ComboBox<String> assignEmployeeComboBox;
    @FXML private ComboBox<String> assignDrawerComboBox;

    
    @FXML
    private void initialize() {
        // Load list of employees into the dropdown list when the application starts
        loadEmployeeList();
        
        // Load drawers into the dropdown list
        loadDrawerOptions();
    }
    
    // Queries the database and loads full list of employee names into the dropdown list
    private void loadEmployeeList() {
        ObservableList<String> employeeNames = FXCollections.observableArrayList();

        try (Connection connection = DriverManager.getConnection(Main.URL, Main.USER, Main.PASSWORD)) {
            String query = "SELECT CONCAT(lname, ', ', fname) AS employee_name FROM Employee ORDER BY lname;"; 
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

        assignEmployeeComboBox.setItems(employeeNames);
    }
    
    @FXML
    private void loadDrawerOptions() {
        ObservableList<String> drawerOptions = FXCollections.observableArrayList("drawer1", "drawer2");
        assignDrawerComboBox.setItems(drawerOptions);
    }
    
    @FXML
    private void handleAssignButtonAction() {
    	// Logic to handle action when the Assign button is clicked
    }

    @FXML
    private void handleCountButtonAction() {
    	Stage stage = (Stage) btnCount.getScene().getWindow();
        stage.setScene(Main.countScreenScene);
        stage.show();
    }

    @FXML
    private void handleCloseButtonAction() {
    	try {
            Stage stage = (Stage) btnClose.getScene().getWindow();
            stage.setScene(Main.backOfficeUIScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

