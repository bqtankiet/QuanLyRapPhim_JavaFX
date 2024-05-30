package controllers;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import models.DatVe;
import models.LichChieu;
import models.Phim;
import models.UserData;
import models.VeXemPhim;

public class ThongTinVeController extends AbstractController {
	public static final String FXML = "/views/banve/ThongTinDatVe.fxml";

	@FXML
	private Label gheLbl;

	@FXML
	private ImageView imageView;

	@FXML
	private Label ngayChieuLbl;

	@FXML
	private Label phuDeLbl;

	@FXML
	private Label soLuongVeLbl;

	@FXML
	private Label tenPhimLbl;

	@FXML
	private Label tenPhongLbl;

	@FXML
	private Label tenRapLbl;

	@FXML
	private Label thoiGianLbl;

	@FXML
	private Label tongTienLbl;

	@Override
	public void eventHandling() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initView() {
		clearData();
	}
	
	public void clearData() {
		tenPhimLbl.setText("---");
		tenRapLbl.setText("---");
		ngayChieuLbl.setText("---");
		thoiGianLbl.setText("---");
		tenPhongLbl.setText("---");
		phuDeLbl.setText("---");
		gheLbl.setText("---");
		soLuongVeLbl.setText("---");
		tongTienLbl.setText("---");
		imageView.setImage(null);
	}

	public void updateThongTin(VeXemPhim veXemPhim) {
		thoiGianLbl.setText(veXemPhim.getThoiGianChieu());
		tenPhongLbl.setText(veXemPhim.getTenPhong());
		phuDeLbl.setText(veXemPhim.getPhuDe());
	}

	public Label getGheLbl() {
		return gheLbl;
	}

	public ImageView getImageView() {
		return imageView;
	}

	public Label getNgayChieuLbl() {
		return ngayChieuLbl;
	}

	public Label getPhuDeLbl() {
		return phuDeLbl;
	}

	public Label getSoLuongVeLbl() {
		return soLuongVeLbl;
	}

	public Label getTenPhimLbl() {
		return tenPhimLbl;
	}

	public Label getTenPhongLbl() {
		return tenPhongLbl;
	}

	public Label getTenRapLbl() {
		return tenRapLbl;
	}

	public Label getThoiGianLbl() {
		return thoiGianLbl;
	}

	public Label getTongTienLbl() {
		return tongTienLbl;
	}

	
}
