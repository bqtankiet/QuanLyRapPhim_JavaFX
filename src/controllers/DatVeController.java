package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import models.Phim;

public class DatVeController implements Initializable {
	public static final String FXML = "/views/banve/DatVe.fxml";
	public static DatVeController instance;

	public static DatVeController getInstance() {
		return instance;
	}

	@FXML
	private HBox mainPane;

	@FXML
	private AnchorPane root;

	@FXML
	private StackPane stepDatVeArea;

	@FXML
	private VBox thongTinVeArea;

	private FXMLLoader fxmlLoader;
	
	private ThongTinVeController thongTinVeController;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		instance = this;
		mainPane.getChildren().remove(0);
		// TODO Auto-generated method stub
		try {
			// load thong tin ve area
			fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource(ThongTinVeController.FXML));
			thongTinVeArea = fxmlLoader.load();
			thongTinVeController = fxmlLoader.getController();
			thongTinVeController.test();
			mainPane.getChildren().add(0, thongTinVeArea);
			

//			thongTinVeController.setData(phim);

			// load step dat ve area
			fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource(ChonSuatChieuController.FXML));
			VBox chonSuatChieuView = fxmlLoader.load();
			ChonSuatChieuController chonSuatChieuController = fxmlLoader.getController();
			stepDatVeArea.getChildren().clear();
			stepDatVeArea.getChildren().add(chonSuatChieuView);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
