package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import utils.SceneController;

public class ThemSuatChieuController implements Initializable{
	public static final String FXML = "/views/suatchieu/themSuatChieu.fxml";
	
    @FXML
    private ChoiceBox<String> PhimChoicebox;

    @FXML
    private ChoiceBox<String> PhudeChoicebox;

    @FXML
    private ChoiceBox<String> ThoigianChoicebox;

    @FXML
    private Button closeBtn;

    @FXML
    private ChoiceBox<String> phongChoicebox;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private Button saveBtn;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		closeBtn.setOnAction(event -> closeBtnAction());
		saveBtn.setOnAction(event -> saveBtnAction());
	}

	private void saveBtnAction() {
		// TODO Xử lý sự kiện save suất chiếu mới
	}

	private void closeBtnAction() {
		SceneController.GetInstance().removePane(rootPane);
	}

    
}
