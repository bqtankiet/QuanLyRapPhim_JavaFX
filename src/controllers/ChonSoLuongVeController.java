package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import models.DatVe;
import models.enums.LoaiKhachHang;

public class ChonSoLuongVeController extends AbstractController {
	public static final String FXML = "/views/banve/ChonSoLuongVe.fxml";
	private int numOfAdult = 0;
	private DatVe datVe;

	@FXML
	private HBox root;

	@FXML
	private Button adultDecreaseBtn;

	@FXML
	private Button adultIncreaseBtn;

	@FXML
	private TextField adultNumField;

	@FXML
	private Button xacNhanBtn;

	@Override
	public void eventHandling() {
		// Listener for text field changes
		adultNumField.textProperty().addListener(this::onTextFieldChange);

		// Button event handlers
		adultIncreaseBtn.setOnAction(event -> incrementAdultNum());
		adultDecreaseBtn.setOnAction(event -> decrementAdultNum());
		xacNhanBtn.setOnAction(event -> closeView());
	}

	@Override
	public void initView() {
		xacNhanBtn.setDisable(true);
		adultNumField.setEditable(false);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		super.initialize(location, resources);
		datVe = DatVeController.getInstance().getDatVe();
	}

	private void closeView() {
		ChonGheNgoiController.getInstance().closePane(root);
	}

	private void onTextFieldChange(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		xacNhanBtn.setDisable(newValue.equals("0") || newValue.isEmpty());
	}

	private void incrementAdultNum() {
		numOfAdult = parseTextField(adultNumField.getText());
		numOfAdult++;
		adultNumField.setText(String.valueOf(numOfAdult));
		updateSoLuongVe();
	}

	private void updateSoLuongVe() {
		ThongTinVeController controller = DatVeController.getInstance().getThongTinVeController();
		controller.getSoLuongVeLbl().setText(numOfAdult == 0 ? "" : "Adult x" + numOfAdult);
		datVe.setSoLuongVe(LoaiKhachHang.ADULT, numOfAdult);
	}

	private void decrementAdultNum() {
		numOfAdult = parseTextField(adultNumField.getText());
		if (numOfAdult > 0) {
			numOfAdult--;
			adultNumField.setText(String.valueOf(numOfAdult));
			updateSoLuongVe();
		}
	}

	private int parseTextField(String text) {
		try {
			return Integer.parseInt(text);
		} catch (NumberFormatException e) {
			return 0;
		}
	}
}
