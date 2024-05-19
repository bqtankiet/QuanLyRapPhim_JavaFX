package utils;

import java.util.HashMap;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
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

	private final HashMap<String, Pane> screenMap = new HashMap<>();
	private Scene primarySence;
	private Stage primaryStage;

	public Stage getCurrentStage() {
		return primaryStage;
	}

	public void init(Stage primaryStage, Scene mainScene) {
		this.primarySence = mainScene;
		this.primaryStage = primaryStage;
	}

	public void replaceScene(String scene) throws Exception {
		String location = Helper.VIEW_FOLDER + scene + ".fxml";
		Pane replaceRoot = screenMap.get(scene);
		try {
			if (replaceRoot == null) {
				replaceRoot = FXMLLoader.load(getClass().getResource(location));
				screenMap.put(scene, replaceRoot);
			}
		} catch (Exception e) {
			throw new Exception("Không thể load scene " + scene + " tại " + location);
		}
		try {
			primarySence.setRoot(replaceRoot);
			primaryStage.sizeToScene();
			primaryStage.centerOnScreen();
		} catch (Exception e) {
			throw new Exception("Scene chưa được khởi tạo");
		}
//		if (replaceRoot.getUserData() == null)
//			throw new Exception("Chưa đặt tên cho Scene");
//		else
//			primaryStage.setTitle(replaceRoot.getUserData().toString());
	}

	public void tryReplaceScene(String scene) {
		try {
			replaceScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}