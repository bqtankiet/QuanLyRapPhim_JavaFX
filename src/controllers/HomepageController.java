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
import utils.AlertDialog;
import utils.PaneController;

public class HomepageController implements Initializable {
	public static final String FXML = "/views/homepage/homepage.fxml";
	@FXML
	private Button rapBtn, phimBtn, suatChieuBtn, giaVeBtn, khuyenmaiBtn, banveBtn, qlVeBtn;

	@FXML
	private ScrollPane scrollpane;

	@FXML
	private BorderPane borderpane;
	
	@FXML
	private AnchorPane mainPane, parent;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		rapBtn.setOnAction(event -> rapBtnOnClick());
		phimBtn.setOnAction(event -> phimBtnOnClick());
		suatChieuBtn.setOnAction(event -> suatChieuBtnOnClick());
		giaVeBtn.setOnAction(event -> giaVeBtnOnClick());
		khuyenmaiBtn.setOnAction(event -> khuyenmaiBtnOnClick());
		banveBtn.setOnAction(event -> banveBtnOnClick());
		rapBtn.fire();
		qlVeBtn.setOnAction(event -> qlVeBtnOnClick());
	}

	private void qlVeBtnOnClick() {
//		AlertDialog.showConfirmAlert("COMING SOON: \"Chức năng đang phát triển\"");
		// ---- test
		setCurrentBtn(qlVeBtn);
		PaneController.getInstance().replacePane(currentMainPane(), QuanLyVeController.FXML);
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
	

	private void banveBtnOnClick() {
		setCurrentBtn(banveBtn);
		PaneController.getInstance().replacePane(currentMainPane(), BanVeController.FXML);
	}
	
	private void khuyenmaiBtnOnClick() {
		setCurrentBtn(khuyenmaiBtn);
//		switchMainPane(KhuyenMaiController.FXML);
		PaneController.getInstance().replacePane(currentMainPane(), KhuyenMaiController.FXML);
	}
	
	private void giaVeBtnOnClick() {
		setCurrentBtn(giaVeBtn);
//		switchMainPane(GiaVeController.FXML);
		PaneController.getInstance().replacePane(currentMainPane(), GiaVeController.FXML);
	}

	private void suatChieuBtnOnClick() {
		setCurrentBtn(suatChieuBtn);
//		switchMainPane(SuatChieuController.FXML);
		PaneController.getInstance().replacePane(currentMainPane(), SuatChieuController.FXML);
	}
	
	private void rapBtnOnClick() {
		setCurrentBtn(rapBtn);
//		switchMainPane(RapController.FXML);
		PaneController.getInstance().replacePane(currentMainPane(), RapController.FXML);
	}
	
	private void phimBtnOnClick() {
		setCurrentBtn(phimBtn);
//		switchMainPane(PhimController.FXML);
		PaneController.getInstance().replacePane(currentMainPane(), PhimController.FXML);
	}

	private Pane currentMainPane() {
		return (Pane)parent.getChildren().get(0);
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
