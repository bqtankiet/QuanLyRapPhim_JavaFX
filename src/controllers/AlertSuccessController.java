package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import utils.PaneController;
import utils.SceneController;

public class AlertSuccessController implements Initializable{
	public static final String FXML = "/views/items/AlertSucess.fxml";

    @FXML
    private Button closeBtn;

    @FXML
    private Label message;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private Label title;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		closeBtn.setOnAction(event -> {
			SceneController.GetInstance().removePane(rootPane);
		});
	}
	
	public static void display() {
		PaneController.getInstance().addPane(PaneController.getInstance().getRootPane(), FXML);
	}

    
}
