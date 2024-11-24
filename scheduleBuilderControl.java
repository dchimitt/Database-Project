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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

public class scheduleBuilderControl { 

	// Buttons
	@FXML private Button btnAddToSchedule;
	@FXML private Button btnClose;
	
	// Labels
	@FXML private Label lblSelectAnEmployee;
	@FXML private Label lblSelectDay;
	@FXML private Label lblTimeIn;
	@FXML private Label lblTimeOut;
	
	// TextFields
    @FXML private TextField timeInField;
    @FXML private TextField timeOutField;
    
    // TextAreas
    @FXML private TextArea scheduleTextArea;
    
    // ComboBoxes
    @FXML private ComboBox<String> selectAnEmployeeComboBox;
    
    // DatePickers
    @FXML private DatePicker selectDayDatePicker;

    @FXML
    private void initialize() {
        // Load list of employees into the dropdown list when the application starts
        loadEmployeeList();
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

        selectAnEmployeeComboBox.setItems(employeeNames);
    }
    
    @FXML
    private void handleAddToScheduleButtonAction() {
    	// Logic to handle action when the Add To Schedule button is clicked
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