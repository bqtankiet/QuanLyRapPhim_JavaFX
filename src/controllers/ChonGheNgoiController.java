package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import models.DatVe;
import models.Ghe;
import models.PhongChieu;
import models.enums.LoaiGhe;
import models.enums.LoaiKhachHang;
import utils.AlertDialog;

public class ChonGheNgoiController extends AbstractController {
	public static final String FXML = "/views/banve/ChonGheNgoi.fxml";
	private static ChonGheNgoiController instance;

	public static ChonGheNgoiController getInstance() {
		return instance;
	}

	private DatVe datVe;

	@FXML
	private Button huyDatVeBtn, step1Btn, xacNhanDatVe;
	@FXML
	private GridPane gridpane;
	@FXML
	private AnchorPane mainPane;
	@FXML
	private Button gheThuong, gheVIP, gheCouple, gheDangChon;
	
	private int slGheDaChon;

	@Override
	public void eventHandling() {
		setupButtonHandlers();
	}

	@Override
	public void initView() {
		loadChonSoLuongVe();
		PhongChieu phongChieu = datVe.getVeXemPhim().getSuatChieu().getPhong();
		generateSeatingChart(phongChieu.getSoDoGhe());
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		datVe = DatVeController.getInstance().getDatVe();
		instance = this;
		super.initialize(location, resources);
	}

	private void setupButtonHandlers() {
		huyDatVeBtn.setOnAction(event -> DatVeController.getInstance().closeView());
		step1Btn.setOnAction(event -> DatVeController.getInstance().goBackStep1());
	}

	private void loadChonSoLuongVe() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ChonSoLuongVeController.FXML));
			HBox hbox = fxmlLoader.load();
			mainPane.getChildren().add(hbox);
			AnchorPane.setBottomAnchor(hbox, 0d);
			AnchorPane.setLeftAnchor(hbox, 0d);
			AnchorPane.setTopAnchor(hbox, 0d);
			AnchorPane.setRightAnchor(hbox, 0d);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void closePane(Parent pane) {
		mainPane.getChildren().remove(pane);
	}

	private void generateSeatingChart(Ghe[][] soDoGhe) {
		gridpane.getChildren().clear();
		for (int hang = 0; hang < soDoGhe.length; hang++) {
			int soDay = soDoGhe[hang].length;
			for (int day = 0; day < soDay; day++) {
				Ghe ghe = soDoGhe[hang][day];
				gridpane.add(new GheButton(ghe), day, hang);
			}
		}
	}

	private class GheButton extends Button {
		private final Ghe ghe;

		public GheButton(Ghe ghe) {
			this.ghe = ghe;
			init();
		}

		private void init() {
			this.setMinSize(40, 40);
			this.setMaxSize(40, 40);
			this.setStyle(getSeatStyle(ghe.getLoaiGhe()));
			this.setText(ghe.getHang() + "" + ghe.getDay());
			this.setOnAction(event -> handleOnClick());
			this.setFocusTraversable(false);
		}

		private void handleOnClick() {
			toggleSeatSelection();
			updateXacNhanDatVeState();
		}

		private void updateXacNhanDatVeState() {
			boolean datGioiHan = slGheDaChon >= datVe.getVeXemPhim().getSoLuongVe(LoaiKhachHang.ADULT);
			if(datGioiHan) xacNhanDatVe.setVisible(true);
			else xacNhanDatVe.setVisible(false);
		}

		private void toggleSeatSelection() {
			boolean datGioiHan = slGheDaChon >= datVe.getVeXemPhim().getSoLuongVe(LoaiKhachHang.ADULT);
			boolean isSelected = datVe.getListGheDangChon().contains(ghe);
			if (isSelected) {
				datVe.boChonGhe(ghe);
				this.setStyle(getSeatStyle(ghe.getLoaiGhe()));
				if(slGheDaChon > 0) slGheDaChon--;
			} else if(!datGioiHan){
				datVe.chonGhe(ghe);
				this.setStyle(gheDangChon.getStyle());
				slGheDaChon++;
			} else {
				AlertDialog.showConfirmAlert("Không thể chọn thêm vì đã đạt giới hạn vé mua");
			}
		}

		private String getSeatStyle(LoaiGhe loaiGhe) {
			return switch (loaiGhe) {
			case THUONG -> gheThuong.getStyle();
			case VIP -> gheVIP.getStyle();
			case COUPLE -> gheCouple.getStyle();
			default -> "";
			};
		}
	}
}
