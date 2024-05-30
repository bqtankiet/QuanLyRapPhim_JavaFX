package controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;

public class ChonGheNgoiController extends AbstractController {
	public static final String FXML = "/views/banve/ChonGheNgoi.fxml";

	@FXML
	private Button huyDatVeBtn, step1Btn;
	
	@FXML
	private ScrollPane scrollPane;

	@Override
	public void eventHandling() {
		handleHuyDatVeBtnAction();
		handleStep1Btn();
	}

	
	@Override
	public void initView() {
		loadChonSoLuongVe();		
	}


	private void loadChonSoLuongVe() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ChonSoLuongVeController.FXML));
			HBox hbox = fxmlLoader.load();
			scrollPane.setContent(null);
			scrollPane.setContent(hbox);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void handleStep1Btn() {
		step1Btn.setOnAction(event -> DatVeController.getInstance().goBackStep1());
	}


	private void handleHuyDatVeBtnAction() {
		huyDatVeBtn.setOnAction(event -> {
			DatVeController.getInstance().closeView();
		});
	}
}
