package controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import models.DatVe;
import models.SuatChieu;
import models.UserData;
import models.enums.LoaiPhong;

public class SuatChieuItemController extends AbstractController {
	public static final String FXML = "/views/banve/SuatChieuItem.fxml";

	@FXML
	private Label loaiPhong;

	@FXML
	private Label phuDe;

	@FXML
	private Label soGheConTrong;

	@FXML
	private Label tenPhong;

	@FXML
	private Button thoiGian;

	@FXML
	private Label tongSoGhe;

	@FXML
	private HBox root;

	private SuatChieu suatChieu;

	@Override
	public void eventHandling() {
		handleOnClick();
	}

	private void handleOnClick() {
		root.setOnMouseClicked(event -> {
			UserData.getInstance().putData("bookingSuatChieu", suatChieu);
			DatVeController.getInstance().nextStep();
		});
	}

	@Override
	public void initView() {
	}

	public void setData(SuatChieu suatChieu) {
		this.suatChieu = suatChieu;
		LoaiPhong loaiPhong = suatChieu.getPhong().getLoaiPhong();
		String phuDe = suatChieu.getPhude();
		String tongSoGhe = suatChieu.getPhong().getSoLuongGhe() + "";
		String thoiGian = suatChieu.getThoigian();
		String tenPhong = suatChieu.getPhong().getTenPhong();
		String soGheConTrong = suatChieu.getSoGheConTrong() + "";

		// insert data to view componenet
		this.loaiPhong.setText(loaiPhong.toString().replace("PHONG_", ""));
		this.phuDe.setText(phuDe);
		this.tongSoGhe.setText(tongSoGhe);
		this.thoiGian.setText(thoiGian);
		this.tenPhong.setText(tenPhong);
		this.soGheConTrong.setText(soGheConTrong);
	}

}
