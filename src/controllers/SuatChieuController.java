package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import utils.SceneController;

public class SuatChieuController implements Initializable {
	public static final String FXML = "/views/suatchieu/suatchieu.fxml";

	@FXML
	private Button chapNhanBtn;

	@FXML
	private DatePicker ngayChieuDatepicker;

	@FXML
	private ChoiceBox<String> rapChoicebox;

	@FXML
	private AnchorPane rootPane;

	@FXML
	private Button themSuatChieuBtn;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		themSuatChieuBtn.setOnAction(event -> themSuatChieuBtnAction());
	}
	private void themSuatChieuBtnAction() {
		try {
			Pane pane = FXMLLoader.load(getClass().getResource("/views/suatchieu/themSuatChieu.fxml"));
			SceneController.GetInstance().addPane(pane);
		} catch (IOException e) {
		}
	}

}
