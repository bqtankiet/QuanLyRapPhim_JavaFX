package controllers;

import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.util.StringConverter;
import models.Rap;
import models.VeXemPhim;
import models.tableViewItem.PhimItem;
import models.tableViewItem.VeXemPhimItem;
import storage.StorageRap;
import storage.StorageVeXemPhim;
import utils.AlertDialog;
import utils.Helper;

public class QuanLyVeController extends AbstractController {
	public static final String FXML = "/views/quanlyve/QuanLyVe.fxml";

	@FXML
	private Button chapNhanBtn;

	@FXML
	private TableColumn<VeXemPhimItem, String> gheDaDatColumn;

	@FXML
	private TableColumn<VeXemPhimItem, String> maVeColumn;

	@FXML
	private DatePicker ngayChieuDatepicker;

	@FXML
	private TableColumn<VeXemPhimItem, String> phimColumn;

	@FXML
	private TableColumn<VeXemPhimItem, String> phongColumn;

	@FXML
	private ChoiceBox<Rap> rapChoicebox;

	@FXML
	private AnchorPane rootPane;

	@FXML
	private TableView<VeXemPhimItem> tableView;

	@FXML
	private Button nhanVeBtn;

	@FXML
	private TableColumn<VeXemPhimItem, String> thoiGianColumn;

	@Override
	public void eventHandling() {
		nhanVeBtn.setOnAction(event -> handleNhanVeBtn());
	}

	private void handleNhanVeBtn() {
		VeXemPhimItem item = tableView.getSelectionModel().getSelectedItem();
		VeXemPhim ve = item.getVe();
		String currentDateTime = Helper.getCurrentDateTime();
		AlertDialog.showConfirmAlert(String.format("Bạn đã nhận vé %s thành công \nvào lúc: %s", ve.getMaVe(),currentDateTime));
		StorageVeXemPhim.data.remove(ve.getMaVe());
		tableView.getItems().clear();
		loadData();
	}

	@Override
	public void initView() {
		setupDatePicker();
		setupRapChoicebox();
		setupTableView();
		loadData();
	}

	private void setupDatePicker() {
		ngayChieuDatepicker.setValue(LocalDate.now());
		ngayChieuDatepicker.setDisable(false);
		ngayChieuDatepicker.setEditable(false);
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
		rapChoicebox.getSelectionModel().selectFirst();
	}

	private void loadData() {
		for (String maVe : StorageVeXemPhim.data.keySet()) {
			VeXemPhim ve = StorageVeXemPhim.data.get(maVe);
			VeXemPhimItem veItem = new VeXemPhimItem(ve);
			tableView.getItems().add(veItem);
		}
	}

	private void setupTableView() {
		maVeColumn.setCellValueFactory(cellData -> cellData.getValue().getMaVe());
		thoiGianColumn.setCellValueFactory(cellData -> cellData.getValue().getThoiGian());
		phongColumn.setCellValueFactory(cellData -> cellData.getValue().getPhong());
		phimColumn.setCellValueFactory(cellData -> cellData.getValue().getPhim());
		gheDaDatColumn.setCellValueFactory(cellData -> cellData.getValue().getGheDaDat());
		
	}
}
