package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.AnchorPane;
import javafx.util.converter.IntegerStringConverter;
import models.HoaDon;
import storage.StorageVeXemPhim;
import utils.AlertDialog;
import utils.Helper;

public class ThanhToanBangTienMatController extends AbstractController {
	public static final String FXML = "/views/banve/ThanhToanBangTienMat.fxml";
	private ThanhToanController parentController;
	private HoaDon hoaDon;

	@FXML
	private Button backButton;

	@FXML
	private TextField khachDuaField;

	@FXML
	private Label orderCode;

	@FXML
	private Button paymentButton;

	@FXML
	private AnchorPane root;

	@FXML
	private Label totalPriceLbl;

	@FXML
	private TextField traKhachField;

	private int tienKhachDua;

	@Override
	public void eventHandling() {
		backButton.setOnAction(event -> handleBackButton());
		khachDuaField.textProperty().addListener(this::onTextFieldChange);
		paymentButton.setOnAction(event -> handlePaymentButton());
	}

	@Override
	public void initView() {
		int total = hoaDon.getTotalPrice();
		totalPriceLbl.setText(Helper.formatNumber(total));
		String maHD = hoaDon.getMaHoaDon();
		orderCode.setText(maHD);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		parentController = ThanhToanController.getInstance();
		hoaDon = parentController.getHoaDon();
		super.initialize(location, resources);
	}

	private void onTextFieldChange(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		if (newValue.isBlank() || !newValue.matches("\\d*")) {
			khachDuaField.setText(newValue.replaceAll("[^\\d]", ""));
		} else {
			tienKhachDua = Integer.parseInt(newValue);
			int tienTraKhach = tienKhachDua - hoaDon.getTotalPrice();
			traKhachField.setText(Helper.formatNumber(tienTraKhach));
			if (tienTraKhach < 0) {
				traKhachField.setStyle("-fx-text-fill: red");
			} else {
				traKhachField.setStyle("-fx-text-fill: black");
			}
		}
	}

	private void handlePaymentButton() {
		int tienTraKhach = tienKhachDua - hoaDon.getTotalPrice();
		if (tienTraKhach < 0) {
			AlertDialog.showConfirmAlert("Chưa đủ tiền thanh toán");
		} else {
			AlertSuccessController.display();
			DatVeController.getInstance().closeView();
			StorageVeXemPhim.data.put(hoaDon.getVeXemPhim().getMaVe(), hoaDon.getVeXemPhim());
			System.out.println(StorageVeXemPhim.data.get(hoaDon.getMaHoaDon()));
			hoaDon.getVeXemPhim().getSuatChieu().getDsGheDaDat().addAll(hoaDon.getVeXemPhim().getBookingGhe());
		}
	}

	private void handleBackButton() {
		parentController.loadSubView(ChonHinhThucThanhToanController.FXML);
	}
}
