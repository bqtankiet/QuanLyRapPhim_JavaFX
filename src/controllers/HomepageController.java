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
	public static final String FXML = "/views/homepage/homepage.fxml";
	@FXML
	private Button rapBtn, phimBtn, suatChieuBtn, giaVeBtn, khuyenmaiBtn;

	@FXML
	private ScrollPane scrollpane;

	@FXML
	private BorderPane borderpane;
	
	@FXML
	private AnchorPane mainPane;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		rapBtn.setOnAction(event -> rapBtnOnClick());
		phimBtn.setOnAction(event -> phimBtnOnClick());
		suatChieuBtn.setOnAction(event -> suatChieuBtnOnClick());
		giaVeBtn.setOnAction(event -> giaVeBtnOnClick());
		khuyenmaiBtn.setOnAction(event -> khuyenmaiBtnOnClick());
	}

	public void switchMainPane(String fxml) {
		try {
			Pane replaceRoot = FXMLLoader.load(getClass().getResource(fxml));
			mainPane.getChildren().clear();
			mainPane.getChildren().add(replaceRoot);
	        AnchorPane.setTopAnchor(replaceRoot, 0.0);
	        AnchorPane.setBottomAnchor(replaceRoot, 0.0);
	        AnchorPane.setLeftAnchor(replaceRoot, 0.0);
	        AnchorPane.setRightAnchor(replaceRoot, 0.0);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	private void khuyenmaiBtnOnClick() {
		setCurrentBtn(khuyenmaiBtn);
		switchMainPane(KhuyenMaiController.FXML);
	}
	
	private void giaVeBtnOnClick() {
		setCurrentBtn(giaVeBtn);
		switchMainPane(GiaVeController.FXML);
	}

	private void suatChieuBtnOnClick() {
		setCurrentBtn(suatChieuBtn);
		switchMainPane(SuatChieuController.FXML);
	}
	
	private void rapBtnOnClick() {
		setCurrentBtn(rapBtn);
		switchMainPane(RapController.FXML);
	}
	
	private void phimBtnOnClick() {
		setCurrentBtn(phimBtn);
		switchMainPane(PhimController.FXML);
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
