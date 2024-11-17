package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

// Added JavaFX import statements related to SQL
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

// Added SQL import statements
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class UIControl {	
	
	// MySQL Database Credentials
	private static final String URL = "jdbc:mysql://localhost:3306/pointofsale";
    private static final String USER = "dchimitt";
    private static final String PASSWORD = "testpassword";
    
	@FXML
	private Button btnEntrees;
	@FXML
	private Button btnSides;
	@FXML
	private Button btnDrinks;
	@FXML
	private Button btnDesserts;
	@FXML
	private Button btnAllergy;
	@FXML
	private Button btnVegetarian;
	@FXML
	private Button btnRecall;
	@FXML
	private Button btnOffice;
	@FXML
	private Button btnMgrFn;
	@FXML
	private Button btnDrawers;
	@FXML
	private Button btnTimeClock;
	@FXML
	private Button btnNote;
	@FXML
	private Button btnMeal;
	@FXML
	private Button btnModify;
	@FXML
	private Button btnAlert;
	@FXML
	private Button btnTender;
	@FXML
	private Button btnItem1;
	@FXML
	private Button btnItem2;
	@FXML
	private Button btnItem3;
	@FXML
	private Button btnItem4;
	@FXML
	private Button btnItem5;
	@FXML
	private Button btnItem6;
	@FXML
	private Button btnItem7;
	@FXML
	private Button btnItem8;
	@FXML
	private Button btnItem9;
	@FXML
	private Button btnItem10;
	@FXML
	private Button btnItem11;
	@FXML
	private Button btnItem12;
	@FXML
	private Button btnItem13;
	@FXML
	private Button btnItem14;
	@FXML
	private Button btnItem15;
	@FXML
	private Button btnItem16;
	@FXML
	private Button btnItem17;
	@FXML
	private Button btnItem18;
	@FXML
	private Button btnItem19;
	@FXML
	private Button btnItem20;
	@FXML
	private TextArea ticketText;
	
	@FXML
	private void handleEntreesButtonAction() {
		// Query the database for all entrees
        String query = "SELECT ssn FROM EMPLOYEE WHERE lname = 'Cook';";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            // Build a string to display the results
            StringBuilder result = new StringBuilder("Entrees List:\n\n");
            
            /*
        	 * TO RETRIEVE MULTIPLE RESULTS IN COLUMNS
            while (rs.next()) {
                result.append("ID: ").append(rs.getInt("id"))
                      .append(", Name: ").append(rs.getString("name"))
                      .append(", Description: ").append(rs.getString("description"))
                      .append(", Price: $").append(rs.getBigDecimal("price"))
                      .append("\n");
            */
        	
        	while (rs.next()) {
        		String ssn = rs.getString("ssn");
        		
        		result.append("SSN: " + ssn);
            }
            
            // Display the result in the TextArea
            ticketText.setText(result.toString());

        } catch (Exception e) {
            // Handle any exceptions (e.g., SQL errors, connection issues)
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Database Error");
            alert.setHeaderText("Error connecting to the database");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }
}