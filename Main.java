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
	
	@Override
	public void start(Stage primaryStage) {   	
		try {
			AnchorPane backOfficeUI = FXMLLoader.load(getClass().getResource("backOfficeUI.fxml"));
			AnchorPane countScreen = FXMLLoader.load(getClass().getResource("countScreen.fxml"));
			AnchorPane databaseSelectScreen = FXMLLoader.load(getClass().getResource("databaseSelectScreen.fxml"));
			AnchorPane deleteEmployeeScreen = FXMLLoader.load(getClass().getResource("deleteEmployeeScreen.fxml"));
			AnchorPane drawerManager = FXMLLoader.load(getClass().getResource("drawerManager.fxml"));
			AnchorPane editPOSScreen = FXMLLoader.load(getClass().getResource("editPOSScreen.fxml"));
			AnchorPane employeeAddScreen = FXMLLoader.load(getClass().getResource("employeeAddScreen.fxml"));
			AnchorPane inventoryScreen = FXMLLoader.load(getClass().getResource("inventoryScreen.fxml"));
			AnchorPane loginScreen = FXMLLoader.load(getClass().getResource("loginScreen.fxml"));
			AnchorPane modifyScreen = FXMLLoader.load(getClass().getResource("modifyScreen.fxml"));
			AnchorPane noteScreen = FXMLLoader.load(getClass().getResource("noteScreen.fxml"));
			AnchorPane openingScreen = FXMLLoader.load(getClass().getResource("openingScreen.fxml"));
			AnchorPane recallTicketScreen = FXMLLoader.load(getClass().getResource("recallTicketScreen.fxml"));
			AnchorPane scheduleBuilder = FXMLLoader.load(getClass().getResource("scheduleBuilder.fxml"));
			AnchorPane tenderScreen = FXMLLoader.load(getClass().getResource("tenderScreen.fxml"));
			AnchorPane timeClockUI = FXMLLoader.load(getClass().getResource("timeClockUI.fxml"));
			BorderPane userInterface = (BorderPane)FXMLLoader.load(getClass().getResource("userInterface.fxml"));
			Scene scene = new Scene(scheduleBuilder, 600, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
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
