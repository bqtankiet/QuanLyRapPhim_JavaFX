package controllers;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import models.PhongChieu;
import models.Rap;
import models.enums.LoaiPhong;
import models.tableViewItem.PhongChieuItem;
import models.tableViewItem.RapItem;
import storage.StorageRap;
import utils.AlertDialog;
import utils.PaneController;
import utils.SceneController;

public class RapController implements Initializable {
	public static final String FXML = "/views/rap/rap.fxml";
	private static RapController instance;
	
	public static RapController getInstance() {
        if (instance == null) {
            instance = new RapController();
        }
        return instance;
    }

	@FXML
	private TableView<RapItem> tableView;

	@FXML
	private TableView<PhongChieuItem> phongTable;

	@FXML
	private AnchorPane rootPane;

	@FXML
	private AnchorPane thongTinPane;

	@FXML
	private TableColumn<RapItem, String> soPhongColumn, tenRapColumn, trangThaiColumn, diaChiColumn;

	@FXML
	private TableColumn<PhongChieuItem, String> tenPhongColumn, loaiPhongColumn, soGheColumn;

	@FXML
	private TextField diaChiField;

	@FXML
	private TextField tenRapField;

	@FXML
	private Button themRapBtn, saveBtn;

	@FXML
	private Button themPhongChieuBtn;

	private ObservableList<RapItem> dataRap = FXCollections.observableArrayList();
	private ObservableList<PhongChieuItem> dataPhongChieu = FXCollections.observableArrayList();
	private ObservableList<RapItem> prevDataRap = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		instance = this;
		thongTinPane.setVisible(false);
//		tableView.setOnMouseClicked(event -> tableviewRowOnClick());
		themRapBtn.setOnAction(event -> themRapBtnAction());
		themPhongChieuBtn.setOnAction(event -> themPhongChieuBtnAction());
		saveBtn.setOnAction(event -> saveBtnOnAction());
		setupTableView();
		setupPhongtable();
	}

	private void setupPhongtable() {
		tenPhongColumn.setCellValueFactory(new PropertyValueFactory<>("tenPhong"));
		loaiPhongColumn.setCellValueFactory(new PropertyValueFactory<>("loaiPhong"));
		soGheColumn.setCellValueFactory(new PropertyValueFactory<>("soGhe"));
	}

	private void themPhongChieuBtnAction() {
//		PaneController.getInstance().replacePane(rootPane, SoDoGheNgoiController.FXML);
		PaneController.getInstance().addPane(PaneController.getInstance().getRootPane(), SoDoGheNgoiController.FXML);
	}
	
	public void themPhongChieu(PhongChieu phongChieu) {
		Rap rap = tableView.getSelectionModel().getSelectedItem().getRap();
		rap.themPhongChieu(phongChieu);
		ObservableList<RapItem> temp = FXCollections.observableArrayList();
		for (RapItem rapItem : dataRap) {
			temp.add(rapItem.getRap().createRapItem());
			System.out.println(rapItem.getRap().getTenRap());
		}
		tableView.getItems().clear();
		dataRap.clear();
		dataRap.setAll(temp);
		tableView.setItems(dataRap);
	}

	private boolean hasChange() {
		return !prevDataRap.equals(dataRap);
	}
	
	private void saveBtnOnAction() {
		if (!hasChange())
			return; // do nothing
		StorageRap.setAllFromObserableList(dataRap);
		for (RapItem rapItem : dataRap) {
			rapItem.getRap().setTenRap(rapItem.tenRap.get());
			rapItem.getRap().setDiaChi(rapItem.diaChi.get());
		}
		updatePrevRapData();
		AlertDialog.showConfirmAlert("Lưu thành công");
		System.out.println(StorageRap.data.toString());
	}

	private void themRapBtnAction() {
		for (RapItem item : dataRap) {
			tenRapField.textProperty().unbindBidirectional(item.tenRap);
			diaChiField.textProperty().unbindBidirectional(item.diaChi);
		}
		// kiem tra thay doi
		if (hasChange()) {
			AlertDialog.showConfirmAlert("Hãy lưu lại thay đổi trước khi thêm rạp mới");
			return;
		}
		// tao rap moi
		Rap rap = new Rap("NULL", "NULL");
		// them rap moi vao tableview
		dataRap.add(rap.createRapItem());
		tableView.setItems(dataRap);
		tableView.getSelectionModel().clearSelection();
		tableView.getSelectionModel().select(dataRap.size() - 1);
		tableView.requestFocus();
		tableView.getFocusModel().focus(dataRap.size() - 1);
		tableView.scrollTo(dataRap.size() - 1);
	}

	private void tableviewRowOnClick() {
		RapItem clickedRap = tableView.getSelectionModel().getSelectedItem();
		if (clickedRap == null)
			return;
		tenRapField.setText(clickedRap.getTenRap().get());
		diaChiField.setText(clickedRap.getDiaChi().get());
		List<PhongChieu> dsPhongChieu = clickedRap.getRap().getDsPhongChieu();
		phongTable.getItems().clear();
		for (PhongChieu phong : dsPhongChieu) {
			dataPhongChieu.add(new PhongChieuItem(phong));
		}
		phongTable.setItems(dataPhongChieu);
	}

	private void loadData() {
		for (Rap rap : StorageRap.getAll()) {
			dataRap.add(rap.createRapItem());
		}
		tableView.setItems(dataRap);
		updatePrevRapData();
	}

	private void updatePrevRapData() {
		prevDataRap.clear();
		for (RapItem item : dataRap) {
			prevDataRap.add(new RapItem(item.getRap()));
		}
	}

	private void setupTableView() {
		tenRapColumn.setCellValueFactory(cellData -> cellData.getValue().getTenRap());
		diaChiColumn.setCellValueFactory(cellData -> cellData.getValue().getDiaChi());
		soPhongColumn.setCellValueFactory(cellData -> cellData.getValue().getSoPhong());
//		tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
//			if (newSelection != null) {
//				thongTinPane.setVisible(true);
//                tenRapField.textProperty().bindBidirectional(newSelection.tenRap);
//			} else {
//				thongTinPane.setVisible(false);
//				tenRapColumn.textProperty().unbind();
//            	tenRapColumn.setText("");
//			}
//		});
		tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			if (oldSelection != null) {
				// huy rang buoc
				tenRapField.textProperty().unbindBidirectional(oldSelection.tenRap);
				diaChiField.textProperty().unbindBidirectional(oldSelection.diaChi);
				// clear table DS phong chieu
				phongTable.getItems().clear();
			}
			if (newSelection != null) {
				for (RapItem item : dataRap) {
					tenRapField.textProperty().unbindBidirectional(item.tenRap);
					diaChiField.textProperty().unbindBidirectional(item.diaChi);
				}
				// hien thi bang thong tin chi tiet
				thongTinPane.setVisible(true);
				// rang buoc cot du lieu vs text field
				tenRapField.textProperty().bindBidirectional(newSelection.tenRap);
				diaChiField.textProperty().bindBidirectional(newSelection.diaChi);
				// update table DS phong chieu
				List<PhongChieu> dsPhongChieu = newSelection.getRap().getDsPhongChieu();
				for (PhongChieu phong : dsPhongChieu) {
					dataPhongChieu.add(new PhongChieuItem(phong));
				}
				phongTable.setItems(dataPhongChieu);
			} else {
				thongTinPane.setVisible(false);
				tenRapField.setText("");
				diaChiField.setText("");
			}
		});

		loadData();
	}

}
