package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class HomepageController implements Initializable {
// FXML file: "/views/homepage/homepage.fxml"
	@FXML
	private Button rapBtn, phimBtn;

	@FXML
	private ScrollPane scrollpane;
	
	@FXML
	private BorderPane borderpane;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		rapBtn.setOnAction(event -> rapBtnOnClick());
		phimBtn.setOnAction(event -> phimBtnOnClick());
	}

	private Object rapBtnOnClick() {
		setCurrentBtn(rapBtn);
		try {
			Pane replaceRoot = FXMLLoader.load(getClass().getResource("/views/homepage/rap.fxml"));
			borderpane.setCenter(replaceRoot);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Object phimBtnOnClick() {
		setCurrentBtn(phimBtn);
		try {
			Pane replaceRoot = FXMLLoader.load(getClass().getResource("/views/homepage/phim.fxml"));
			borderpane.setCenter(replaceRoot);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private Button currentButton;
	private void setCurrentBtn(Button button) {
		Button prevButton = currentButton;
		currentButton = button;
		if (prevButton != null) {
			prevButton.setStyle(".button{-fx-background-color: Transparent}");
			prevButton.setDisable(false);
		}
		currentButton.setStyle("-fx-background-color: black");
		currentButton.setDisable(true);
	}

}
