package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import models.DatVe;
import models.LichChieu;
import models.Phim;
import models.SuatChieu;
import models.UserData;

public class ChonSuatChieuController extends AbstractController {
	public static final String FXML = "/views/banve/ChonSuatChieu.fxml";

	@FXML
	private Button huyDatVeBtn;

	@FXML
	private VBox scItemsContainer;

	@Override
	public void initView() {
		loadSuatChieuItems();
	}

	@Override
	public void eventHandling() {
		handleHuyDatVeBtnAction();
	}

	private void loadSuatChieuItems() {
		
		scItemsContainer.getChildren().clear();
		// load and render cac suat chieu dang co
		DatVe datVe = DatVeController.getInstance().getDatVe();
		loadSuatChieuItems(datVe.getAvailabeSuatChieu());
	}

	private void loadSuatChieuItems(List<SuatChieu> listSC) {
		for (SuatChieu sc : listSC) {
			try {
				FXMLLoader fxmlLoader = new FXMLLoader();
				fxmlLoader.setLocation(getClass().getResource(SuatChieuItemController.FXML));
				HBox scItem = fxmlLoader.load();
				SuatChieuItemController scItemController = fxmlLoader.getController();
				scItemController.setData(sc);
				scItemsContainer.getChildren().add(scItem);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void handleHuyDatVeBtnAction() {
		huyDatVeBtn.setOnAction(event -> {
			DatVeController.getInstance().closeView();
		});
	}

}
