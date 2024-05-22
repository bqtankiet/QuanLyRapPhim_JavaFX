package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import models.PhongChieu;
import models.enums.LoaiPhong;
import models.tableViewItem.RapItem;
import utils.PaneController;
import utils.SceneController;

public class SoDoGheNgoiController implements Initializable {
	public static final String FXML = "/views/rap/soDoGheNgoi.fxml";

	@FXML
	private AnchorPane rootPane;

	@FXML
	private GridPane gridpane;

	@FXML
	private ChoiceBox<LoaiPhong> loaiPhongChoiceBox;

	@FXML
	private TextField soDayField;

	@FXML
	private TextField soHangField;

	@FXML
	private Button taoSoDoGheBtn;

	@FXML
	private Button huyBtn;

	@FXML
	private Button luuBtn;

	@FXML
	private TextField tenPhongField;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		taoSoDoGheBtn.setOnAction(event -> taoSoDoGheBtnAction());
		huyBtn.setOnAction(event -> huyBtnAction());
		luuBtn.setOnAction(event -> luuBtnAction());
		ObservableList<LoaiPhong> choiceboxData = FXCollections.observableArrayList();
		choiceboxData.add(LoaiPhong.PHONG_2D);
		choiceboxData.add(LoaiPhong.PHONG_3D);
		choiceboxData.add(LoaiPhong.Phong_4D);
		choiceboxData.add(LoaiPhong.Phong_IMAX);
		loaiPhongChoiceBox.setItems(choiceboxData);
		loaiPhongChoiceBox.setValue(LoaiPhong.PHONG_2D);
	}

	private void luuBtnAction() {
//		AlertDialog.showConfirmAlert("Lưu thành công");
		String tenPhong = tenPhongField.getText();
		LoaiPhong loaiPhong = loaiPhongChoiceBox.getValue();
		int soDay = 0, soHang = 0;
		try {
			soDay = Integer.parseInt(soDayField.getText());
			soHang = Integer.parseInt(soHangField.getText());
		} catch (NumberFormatException e) {
		}
		PhongChieu phongChieu = new PhongChieu(tenPhong, loaiPhong, soDay, soHang);
		//
		RapController.getInstance().themPhongChieu(phongChieu);
		SceneController.GetInstance().removePane(rootPane);
	}

	private void huyBtnAction() {
//		PaneController.getInstance().replacePane(rootPane, RapController.FXML);
		SceneController.GetInstance().removePane(rootPane);
	}

	private Object taoSoDoGheBtnAction() {
		int rows = 0, columns = 0;
		try {
			rows = Integer.parseInt(soHangField.getText());
			columns = Integer.parseInt(soDayField.getText());
		} catch (Exception e) {
		}
		generateSeatingChart(rows, columns);
		return null;
	}

	private void generateSeatingChart(int rows, int columns) {
		gridpane.getChildren().clear();

		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < columns; col++) {
				Button seatButton = new Button();
				seatButton.setMinSize(40, 40);
				seatButton.setMaxSize(40, 40);

				// Set button text to row letter and column number
				String seatLabel = (char) ('A' + row) + String.valueOf(col + 1);
				seatButton.setText(seatLabel);

				// Optional: Add event handler for button clicks
				seatButton.setOnAction(event -> {
					// TODO: xử lý sự kiện khi ấn vào ghế
					System.out.println("Seat " + seatButton.getText() + " clicked");
				});
				// Add button to gridPane
				gridpane.add(seatButton, col, row);
			}
		}
	}

}
