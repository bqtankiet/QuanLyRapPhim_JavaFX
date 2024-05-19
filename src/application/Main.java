package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.SceneController;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/views/homepage/homepage.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			SceneController.GetInstance().init(primaryStage, scene);
			primaryStage.setScene(scene);
//			primaryStage.sizeToScene();
			primaryStage.setWidth(1366);
			primaryStage.setHeight(700);
			primaryStage.centerOnScreen();
			primaryStage.show();
		} catch(Exception e) {
			System.err.println("Khong doc duoc file");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
