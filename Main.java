package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane loginScreen = FXMLLoader.load(getClass().getResource("loginScreen.fxml"));
			AnchorPane countScreen = FXMLLoader.load(getClass().getResource("countScreen.fxml"));
			BorderPane userInterface = (BorderPane)FXMLLoader.load(getClass().getResource("userInterface.fxml"));
			Scene scene = new Scene(countScreen,600,400);
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
