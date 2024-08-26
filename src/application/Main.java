package application;

import com.khanhnhi.main.LoginModule;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import utils.SceneController;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/views/homepage/homepage.fxml"));
			StackPane stackpane = new StackPane(root);
			Scene scene = new Scene(stackpane);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			SceneController.GetInstance().init(primaryStage, scene);
			primaryStage.setTitle("Cinema Management System");
			primaryStage.setScene(scene);
			primaryStage.setMinWidth(1366);
			primaryStage.setMinHeight(700);
			primaryStage.centerOnScreen();
			primaryStage.setMaximized(true);
			primaryStage.setResizable(false);
			new LoginModule(() -> {
				Platform.runLater(() -> {
					primaryStage.show();
				});
			});
		} catch (Exception e) {
			System.err.println("Khong doc duoc file");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
