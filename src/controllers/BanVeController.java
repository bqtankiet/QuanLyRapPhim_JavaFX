package controllers;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.Set;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;
import models.LichChieu;
import models.Phim;
import models.Rap;
import models.SuatChieu;
import storage.StorageLichChieu;
import storage.StorageRap;

public class BanVeController implements Initializable {
	public static String FXML = "/views/banve/banve.fxml";
	private static BanVeController instance;
	public static BanVeController getInstance() {
		return instance;
	}
	
	@FXML
	private Button chapNhanBtn;

	@FXML
	private DatePicker ngayChieuDatepicker;

	@FXML
	private ChoiceBox<Rap> rapChoicebox;

	@FXML
	private AnchorPane rootPane;

	@FXML
	private AnchorPane scrollAnchorPane;

	@FXML
	private ScrollPane scrollpane;

	@FXML
	private Button themSuatChieuBtn;

	@FXML
	private FlowPane cardLayout;

	public HashMap<Phim, ArrayList<SuatChieu>> mapSuatChieu;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		instance = this;
		setupDatePicker();
		setupRapChoiceBox();
//		setupPhimCards();
		handleChapNhanBtnAction();
		loadAvailablePhimCards();
	}

	private void loadAvailablePhimCards() {
		// clear card layout
		cardLayout.getChildren().clear();
		// lay ra ds cac phim co suat chieu dang co
		mapSuatChieu = new HashMap<>();
		for (LichChieu lichchieu : StorageLichChieu.data) {
			// duyet qua cac lich chieu co cung rap va ngay
			if (lichchieu.getRap().equals(getSelectedRap())
					&& lichchieu.getNgaychieu().equals(getSelectedNgayChieu())) {
				for (SuatChieu sc : lichchieu.getDsSuatChieu()) {
					ArrayList<SuatChieu> listSuatChieu = mapSuatChieu.get(sc.getPhim());
					if(listSuatChieu == null) {
						listSuatChieu = new ArrayList<>();
						mapSuatChieu.put(sc.getPhim(), listSuatChieu);
					}
					listSuatChieu.add(sc);
				}
			}
		}
		// neu khong co suat chieu nao thi return
		if (mapSuatChieu.isEmpty())
			return;
		// them phimcard vao cardlayout
		Set<Phim> setPhim = mapSuatChieu.keySet();
		addPhimCards(setPhim);
	}

	private void addPhimCards(Collection<Phim> setPhim) {
		try {
			cardLayout.getChildren().clear();
			for (Phim phim : setPhim) {
				FXMLLoader fxmlLoader = new FXMLLoader();
				fxmlLoader.setLocation(getClass().getResource(PhimCardController.FXML));
				VBox phimCard = fxmlLoader.load();
				PhimCardController cardController = fxmlLoader.getController();
				cardController.setData(phim);
				cardLayout.getChildren().add(phimCard);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Rap getSelectedRap() {
		return rapChoicebox.getSelectionModel().getSelectedItem();
	}

	private String getSelectedNgayChieu() {
		return ngayChieuDatepicker.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

	private void setupDatePicker() {
		ngayChieuDatepicker.setValue(LocalDate.now());
	}

	private void setupRapChoiceBox() {
		rapChoicebox.setItems(FXCollections.observableArrayList(StorageRap.data));
		rapChoicebox.setConverter(new StringConverter<Rap>() {
			@Override
			public String toString(Rap rap) {
				return rap != null ? rap.getTenRap() : "";
			}

			@Override
			public Rap fromString(String string) {
				return null; // not implemented
			}
		});
		rapChoicebox.getSelectionModel().selectFirst();
	}

	private void handleChapNhanBtnAction() {
		chapNhanBtn.setOnAction(event -> {
			// TODO: xu ly su kien khi nhan vao button
			loadAvailablePhimCards();
		});
	}
}
