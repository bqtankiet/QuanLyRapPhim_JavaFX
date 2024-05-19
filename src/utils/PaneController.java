package utils;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class PaneController {

	private static PaneController instance = null;

	private PaneController() {
	}

	public static PaneController getInstance() {
		if (instance == null) {
			instance = new PaneController();
		}
		return instance;
	}

	public void replacePane(Pane current, String newFXML) {
		try {
			Pane newPane = FXMLLoader.load(getClass().getResource(newFXML));
			Pane parent = (Pane) current.getParent();
			parent.getChildren().clear();
			parent.getChildren().add(newPane);
	        AnchorPane.setTopAnchor(newPane, 0.0);
	        AnchorPane.setBottomAnchor(newPane, 0.0);
	        AnchorPane.setLeftAnchor(newPane, 0.0);
	        AnchorPane.setRightAnchor(newPane, 0.0);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
