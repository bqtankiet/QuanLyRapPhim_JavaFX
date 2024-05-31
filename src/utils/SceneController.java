package utils;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public final class SceneController {
	private static SceneController instance = null;

	private SceneController() {
	};

	public static SceneController GetInstance() {
		if (instance == null)
			instance = new SceneController();
		return instance;
	}

	private Scene primarySence;
	private Stage primaryStage;

	public Stage getCurrentStage() {
		return primaryStage;
	}
	
	public Scene getCurrentScene() {
		return primarySence;
	}

	public void init(Stage primaryStage, Scene mainScene) {
		this.primarySence = mainScene;
		this.primaryStage = primaryStage;
		PaneController.getInstance().init((Pane)primarySence.getRoot());
	}


	public void addPane(Pane pane) {
		StackPane root = (StackPane) primarySence.getRoot();
		root.getChildren().add(pane);
	}
	
	public void removePane(Pane pane) {
		StackPane root = (StackPane) primarySence.getRoot();
		root.getChildren().remove(pane);
	}
	
}