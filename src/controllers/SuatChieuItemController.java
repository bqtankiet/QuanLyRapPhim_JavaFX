package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import models.SuatChieu;
import models.enums.LoaiPhong;

public class SuatChieuItemController {

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

	public void loadData(SuatChieu suatChieu) {
    	LoaiPhong loaiPhong = suatChieu.getPhong().getLoaiPhong();
    	String phuDe = suatChieu.getPhude();
    	String tongSoGhe = suatChieu.getPhong().getSoLuongGhe()+"";
    	String thoiGian = suatChieu.getThoigian();
    	String tenPhong = suatChieu.getPhong().getTenPhong();
    	
    	// insert data to view componenet
    	this.loaiPhong.setText(loaiPhong.toString().replace("PHONG_", ""));
    	this.phuDe.setText(phuDe);
    	this.tongSoGhe.setText(tongSoGhe);
    	this.thoiGian.setText(thoiGian);
    	this.tenPhong.setText(tenPhong);
    	
    }

}
