package models.statePattern;

import java.io.IOException;
import java.util.ArrayList;

import controllers.ChonGheNgoiController;
import controllers.DatVeController;
import controllers.ThongTinVeController;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import models.DatVe;
import models.SuatChieu;
import models.UserData;
import models.enums.LoaiKhachHang;

public class ChonGheNgoiState implements StateDatVe {
	private DatVeController context;
	private DatVe datVe;

	public ChonGheNgoiState(DatVeController context) {
		this.context = context;
		this.datVe = context.getDatVe();
	}

	@Override
	public void handleStep() {
		updateBookingData();
		updateThongTinVe();
		loadChonGheNgoiView();
	}

	private void updateBookingData() {
		SuatChieu sc = (SuatChieu) UserData.getInstance().getData("bookingSuatChieu");
		datVe.setBookingSuatChieu(sc);
		datVe.setLoaiKhachHang(LoaiKhachHang.ADULT);
		datVe.setBookingGhe(new ArrayList<>());
		datVe.setSlVe(0);
	}

	private void updateThongTinVe() {
		ThongTinVeController thongTinVeController = context.getThongTinVeController();
		thongTinVeController.getThoiGianLbl().setText(datVe.getBookingSuatChieu().getThoigian());
		thongTinVeController.getTenPhongLbl().setText(datVe.getBookingSuatChieu().getPhong().getTenPhong());
		thongTinVeController.getPhuDeLbl().setText(datVe.getBookingSuatChieu().getPhude());
		thongTinVeController.getSoLuongVeLbl().setText("---");
		thongTinVeController.getGheLbl().setText("---");
		thongTinVeController.getTongTienLbl().setText("---");
	}

	private void loadChonGheNgoiView() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ChonGheNgoiController.FXML));
			VBox chonGheNgoi = fxmlLoader.load();
			context.getStepDatVeArea().getChildren().add(chonGheNgoi);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
