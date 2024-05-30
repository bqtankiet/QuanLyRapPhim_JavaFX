package controllers;


import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class ThongTinVeController implements Initializable{
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
	private HBox soLuongVeLbl;

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
	public void initialize(URL location, ResourceBundle resources) {
	}

	public void test() {
		System.out.println("TEST IN thong tin dat ve controller");
		File file = new File(/* phim.getHinhAnh() */"resource/images/mai.jpg");
		Image image = new Image(file.toURI().toString());
		imageView.setImage(image);
	}
	
}
