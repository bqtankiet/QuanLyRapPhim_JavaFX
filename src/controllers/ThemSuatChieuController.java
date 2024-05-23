package controllers;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.util.StringConverter;
import models.LichChieu;
import models.Phim;
import models.PhongChieu;
import models.Rap;
import models.SuatChieu;
import storage.StorageLichChieu;
import storage.StoragePhim;
import utils.AlertDialog;
import utils.SceneController;

public class ThemSuatChieuController implements Initializable {
	public static final String FXML = "/views/suatchieu/themSuatChieu.fxml";
	private static ThemSuatChieuController instance;

	public static ThemSuatChieuController getInstance() {
		if (instance == null) {
			instance = new ThemSuatChieuController();
		}
		return instance;
	}

	@FXML
	private ChoiceBox<Phim> PhimChoicebox;

	@FXML
	private ChoiceBox<String> PhudeChoicebox;

	@FXML
	private ChoiceBox<String> ThoigianChoicebox;

	@FXML
	private Button closeBtn;

	@FXML
	private ChoiceBox<PhongChieu> phongChoicebox;

	@FXML
	private AnchorPane rootPane;

	@FXML
	private Button saveBtn;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		instance = this;
		closeBtn.setOnAction(event -> closeBtnAction());
		saveBtn.setOnAction(event -> saveBtnAction());
		setupChoiceBox();
	}

	private void setupChoiceBox() {
		// Setup PhongChoicebox
		Rap rap = SuatChieuController.getInstance().getSelectedRap();
		phongChoicebox.setItems(FXCollections.observableArrayList(rap.getDsPhongChieu()));
		phongChoicebox.getSelectionModel().selectFirst();
		phongChoicebox.setConverter(new StringConverter<PhongChieu>() {
			@Override
			public String toString(PhongChieu object) {
				return object != null ? object.getTenPhong() : "";
			}

			@Override
			public PhongChieu fromString(String string) {
				return null; // not implemented
			}
		});
	
		// Setup PhimChoicebox
		PhimChoicebox.setItems(FXCollections.observableArrayList(StoragePhim.data));
		PhimChoicebox.getSelectionModel().selectFirst();
		PhimChoicebox.setConverter(new StringConverter<Phim>() {
			
			@Override
			public String toString(Phim object) {
				return object != null ? object.getTenPhim() : "";
			}
			
			@Override
			public Phim fromString(String string) {
				return null;
			}
		});
	
		// Setup PhuDeChoicebox
		PhudeChoicebox.getItems().addAll("Tieng Viet", "Tieng Anh");
		PhudeChoicebox.getSelectionModel().selectFirst();
		
		// Setup ThoiGianChoicebox
		List<String> listThoiGian = Arrays.asList(
	            "08:00", "08:15", "08:30", "08:45",
	            "09:00", "09:15", "09:30", "09:45",
	            "10:00", "10:15", "10:30", "10:45",
	            "11:00", "11:15", "11:30", "11:45",
	            "12:00", "12:15", "12:30", "12:45",
	            "13:00", "13:15", "13:30", "13:45",
	            "14:00", "14:15", "14:30", "14:45",
	            "15:00", "15:15", "15:30", "15:45",
	            "16:00", "16:15", "16:30", "16:45",
	            "17:00", "17:15", "17:30", "17:45",
	            "18:00", "18:15", "18:30", "18:45",
	            "19:00", "19:15", "19:30", "19:45",
	            "20:00", "20:15", "20:30", "20:45",
	            "21:00", "21:15", "21:30", "21:45",
	            "22:00"
	        );
		ThoigianChoicebox.getItems().addAll(listThoiGian);
		ThoigianChoicebox.getSelectionModel().selectFirst();
	}

	private void saveBtnAction() {
		// TODO Xử lý sự kiện save suất chiếu mới
		Rap rap = SuatChieuController.getInstance().getSelectedRap();
		LocalDate date = SuatChieuController.getInstance().getSelectedDate();
		String ngayChieu = date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		PhongChieu phongChieu = phongChoicebox.getValue();
		Phim phim = PhimChoicebox.getValue();
		String thoiGian = ThoigianChoicebox.getValue();
		String phuDe = PhudeChoicebox.getValue();
		
		// Test
		LichChieu lichChieu = new LichChieu(rap, phongChieu, ngayChieu);
		SuatChieu suatChieu = new SuatChieu(thoiGian, phim, phuDe, "Available");
		lichChieu.themSuatChieu(suatChieu);
		StorageLichChieu.themLichChieu(lichChieu);
//		System.out.println(StorageLichChieu.getLichChieu(lichChieu));
//		System.out.println(lichChieu);
		SuatChieuController.getInstance().clearAccordion();
		SuatChieuController.getInstance().setupAccordion(rap);
		SceneController.GetInstance().removePane(rootPane);
		AlertDialog.showConfirmAlert("Lưu thành công");
	}

	private void closeBtnAction() {
		SceneController.GetInstance().removePane(rootPane);
	}

}
