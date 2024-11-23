package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	public static final String URL = "jdbc:mysql://localhost:3306/pointofsale";
	public static final String USER = "dchimitt";
	public static final String PASSWORD = "testpassword";
	
	public static Scene backOfficeUIScene;
	public static Scene countScreenScene;
	public static Scene databaseSelectScreenScene;
	public static Scene deleteEmployeeScreenScene;
	public static Scene drawerManagerScene;
	public static Scene editPOSScreenScene;
	public static Scene employeeAddScreenScene;
	public static Scene inventoryScreenScene;
	public static Scene loginScreenScene;
	public static Scene modifyScreenScene;
	public static Scene noteScreenScene;
	public static Scene openingScreenScene;
	public static Scene recallTicketScreenScene;
	public static Scene scheduleBuilderScene;
	public static Scene tenderScreenScene;
	public static Scene timeClockUIScene;
	public static Scene userInterfaceScene;
	
	// Global variables to change the height and width of the stage (all scenes)
	// double fixedWidth = 800;  
    // double fixedHeight = 600; 
	
	public void start(Stage primaryStage) {   	
		try {
			// Add sizes (custom or fixedWidth and fixedHeight) to constructor tuples to change scene sizes
			AnchorPane backOfficeUI = FXMLLoader.load(getClass().getResource("backOfficeUI.fxml"));
			backOfficeUIScene = new Scene(backOfficeUI); 
			
			AnchorPane countScreen = FXMLLoader.load(getClass().getResource("countScreen.fxml"));
			countScreenScene = new Scene(countScreen);
			
			AnchorPane databaseSelectScreen = FXMLLoader.load(getClass().getResource("databaseSelectScreen.fxml"));
			databaseSelectScreenScene = new Scene(databaseSelectScreen);
			
			AnchorPane deleteEmployeeScreen = FXMLLoader.load(getClass().getResource("deleteEmployeeScreen.fxml"));
			deleteEmployeeScreenScene = new Scene(deleteEmployeeScreen);
			
			AnchorPane drawerManager = FXMLLoader.load(getClass().getResource("drawerManager.fxml"));
			drawerManagerScene = new Scene(drawerManager);
			
			AnchorPane editPOSScreen = FXMLLoader.load(getClass().getResource("editPOSScreen.fxml"));
			editPOSScreenScene = new Scene(editPOSScreen);
			
			AnchorPane employeeAddScreen = FXMLLoader.load(getClass().getResource("employeeAddScreen.fxml"));
			employeeAddScreenScene = new Scene(employeeAddScreen);
			
			AnchorPane inventoryScreen = FXMLLoader.load(getClass().getResource("inventoryScreen.fxml"));
			inventoryScreenScene = new Scene(inventoryScreen);
			
			AnchorPane loginScreen = FXMLLoader.load(getClass().getResource("loginScreen.fxml"));
			loginScreenScene = new Scene(loginScreen);
			
			AnchorPane modifyScreen = FXMLLoader.load(getClass().getResource("modifyScreen.fxml"));
			modifyScreenScene = new Scene(modifyScreen);
			
			AnchorPane noteScreen = FXMLLoader.load(getClass().getResource("noteScreen.fxml"));
			noteScreenScene = new Scene(noteScreen);
			
			AnchorPane openingScreen = FXMLLoader.load(getClass().getResource("openingScreen.fxml"));
			openingScreenScene = new Scene(openingScreen);
			
			AnchorPane recallTicketScreen = FXMLLoader.load(getClass().getResource("recallTicketScreen.fxml"));
			recallTicketScreenScene = new Scene(recallTicketScreen);
			
			AnchorPane scheduleBuilder = FXMLLoader.load(getClass().getResource("scheduleBuilder.fxml"));
			scheduleBuilderScene = new Scene(scheduleBuilder);
			
			AnchorPane tenderScreen = FXMLLoader.load(getClass().getResource("tenderScreen.fxml"));
			tenderScreenScene = new Scene(tenderScreen);
			
			AnchorPane timeClockUI = FXMLLoader.load(getClass().getResource("timeClockUI.fxml"));
			timeClockUIScene = new Scene(timeClockUI);
			
			BorderPane userInterface = (BorderPane)FXMLLoader.load(getClass().getResource("userInterface.fxml"));
			userInterfaceScene = new Scene(userInterface);
			
			/* 
			// Use these for sizing
			primaryStage.setWidth(fixedWidth);
	        primaryStage.setHeight(fixedHeight);
	        primaryStage.setResizable(false); // Change this to true if you want to be able to resize the application
	        */

			loginScreen.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(loginScreenScene);
			primaryStage.setTitle("POS System v1.0");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
