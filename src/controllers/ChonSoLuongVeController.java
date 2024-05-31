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
	private int numOfTicket = 0;
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
		numOfTicket = parseTextField(adultNumField.getText());
		numOfTicket++;
		adultNumField.setText(String.valueOf(numOfTicket));
		updateSoLuongVe();
	}

	private void updateSoLuongVe() {
		LoaiKhachHang khachHang = datVe.getLoaiKhachHang();
		ThongTinVeController controller = DatVeController.getInstance().getThongTinVeController();
		controller.getSoLuongVeLbl().setText(numOfTicket == 0 ? "" : khachHang+" x" + numOfTicket);
		datVe.setSlVe(numOfTicket);
	}

	private void decrementAdultNum() {
		numOfTicket = parseTextField(adultNumField.getText());
		if (numOfTicket > 0) {
			numOfTicket--;
			adultNumField.setText(String.valueOf(numOfTicket));
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
