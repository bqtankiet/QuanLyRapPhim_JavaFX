package controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.util.StringConverter;
import models.Rap;
import models.VeXemPhim;
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
	
	@FXML
	private TableColumn<VeXemPhimItem, String> trangThaiColumn;

	@Override
	public void eventHandling() {
		nhanVeBtn.setOnAction(event -> handleNhanVeBtn());
		chapNhanBtn.setOnAction(event -> handleChapNhanBtn());
	}

	private void handleChapNhanBtn() {
		tableView.getItems().clear();
		loadData();
	}

	private void handleNhanVeBtn() {
		if(tableView.getSelectionModel().getSelectedItem() == null) return;
		VeXemPhimItem item = tableView.getSelectionModel().getSelectedItem();
		VeXemPhim ve = item.getVe();
		if(ve.getTrangThai().equals("Đã nhận")) {
			AlertDialog.showConfirmAlert("Nhận vé thất bại: Vé đã nhận");
			return;
		} else {
			String today = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			if(!ve.getSuatChieu().getLichChieu().getNgaychieu().equals(today)) {
				AlertDialog.showConfirmAlert("Nhận vé thất bại: Chưa đến ngày chiếu");
				return;
			}
		}
		String currentDateTime = Helper.getCurrentDateTime();
		AlertDialog.showConfirmAlert(
				String.format("Bạn đã nhận vé \"%s\" thành công \nvào lúc: %s", ve.getMaVe(), currentDateTime));
		ve.setTrangThai("Đã nhận");
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
			if(!ve.getSuatChieu().getLichChieu().getRap().equals(getSelectedRap())) {
				continue;
			} else {
				String ngayChieu = ve.getSuatChieu().getLichChieu().getNgaychieu();
				String selectedNgayChieu = getSelectedDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				System.out.println(ngayChieu + " = " + selectedNgayChieu);
				if(!ngayChieu.equals(selectedNgayChieu)) continue;
			}
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
		trangThaiColumn.setCellValueFactory(cellData -> cellData.getValue().getTrangThai());
		trangThaiColumn.setCellFactory(column -> new TableCell<>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null) {
                    setText(null);
                    setStyle(""); // Clear cell style
                } else {
                    // Set cell text
                    setText(item);

                    // Set cell text color to red if trangThai is "Received"
                    if (item.equals("Đã nhận")) {
                        setStyle("-fx-text-fill: red");
                    } else {
                        setStyle("");
                    }
                }
            }
        });
	}
	
	public Rap getSelectedRap() {
		Rap selectedRap = rapChoicebox.getSelectionModel().getSelectedItem();
		return selectedRap;
	}

	public LocalDate getSelectedDate() {
		LocalDate date = ngayChieuDatepicker.getValue();
		return date;
	}
	
}
