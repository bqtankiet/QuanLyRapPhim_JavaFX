package controllers;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.util.StringConverter;
import models.PhongChieu;
import models.Rap;
import storage.StorageRap;
import utils.PaneController;

public class SuatChieuController implements Initializable {
	public static final String FXML = "/views/suatchieu/suatchieu.fxml";
	private static SuatChieuController instance;

	public static SuatChieuController getInstance() {
		if (instance == null) {
			instance = new SuatChieuController();
		}
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
	private Button themSuatChieuBtn;

	@FXML
	private Accordion phongChieuAccordion;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO chưa xử lý phần cập nhật khi data rạp thay đổi.
		instance = this;
		ngayChieuDatepicker.setValue(LocalDate.now());
		themSuatChieuBtn.setOnAction(event -> themSuatChieuBtnAction());
		handleChapNhanButton();
		clearAccordion();
		setupRapChoicebox();
	}

	private void handleChapNhanButton() {
		chapNhanBtn.setOnAction(event -> {
			Rap selectedRap = rapChoicebox.getSelectionModel().getSelectedItem();
			if (selectedRap == null)
				return;
			clearAccordion();
			setupAccordion(selectedRap);
		});
	}

	private void setupAccordion(Rap selectedRap) {
		for (PhongChieu phong : selectedRap.getDsPhongChieu()) {
	        String title = phong.getTenPhong() + phong.getLoaiPhong().toString().substring(5);
			DSSuatChieuPane pane = new DSSuatChieuPane(title);
		}
	}

	private void clearAccordion() {
		phongChieuAccordion.getPanes().clear();
	}

	private void setupRapChoicebox() {
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
		rapChoicebox.setOnAction(event -> rapChoiceboxAction());
		rapChoicebox.getSelectionModel().selectFirst();
		setupAccordion(rapChoicebox.getItems().get(0));
	}

	private void rapChoiceboxAction() {
//		Rap selectedRap = rapChoicebox.getSelectionModel().getSelectedItem();
	}

	private void themSuatChieuBtnAction() {
		PaneController.getInstance().addPane(PaneController.getInstance().getRootPane(), ThemSuatChieuController.FXML);
	}

	public Rap getSelectedRap() {
		Rap selectedRap = rapChoicebox.getSelectionModel().getSelectedItem();
		return selectedRap;
	}
	
	public LocalDate getSelectedDate() {
		LocalDate date = ngayChieuDatepicker.getValue();
		return date;
	}
	
	private class DSSuatChieuPane extends TitledPane {
		public DSSuatChieuPane(String title) {
			// Init TableColumn
			TableColumn<String, String> colThoiGian = new TableColumn<>("Thời gian");
			TableColumn<String, String> colTenPhim = new TableColumn<>("Tên phim");
			TableColumn<String, String> colPhuDe = new TableColumn<>("Phụ đề");
			TableColumn<String, String> colTrangThai = new TableColumn<>("Trạng thái");
			colThoiGian.setPrefWidth(150);
			colThoiGian.setResizable(false);
			colPhuDe.setPrefWidth(150);
			colPhuDe.setResizable(false);
			colTrangThai.setPrefWidth(150);
			colTrangThai.setResizable(false);

			// Initialize TableView
			TableView<String> tableView = new TableView<>();
			tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);
			tableView.getColumns().add(colThoiGian);
			tableView.getColumns().add(colTenPhim);
			tableView.getColumns().add(colPhuDe);
			tableView.getColumns().add(colTrangThai);

			// Initialize AnchorPane
			AnchorPane anchorPane = new AnchorPane();
			anchorPane.getChildren().add(tableView);

			// Set constraints to fit TableView with AnchorPane
			AnchorPane.setTopAnchor(tableView, 0.0);
			AnchorPane.setLeftAnchor(tableView, 0.0);
			AnchorPane.setRightAnchor(tableView, 0.0);
			AnchorPane.setBottomAnchor(tableView, 0.0);

			// Add anchorpane to accordion
			phongChieuAccordion.getPanes().add(new TitledPane(title, anchorPane));
		}
	}

	

}
