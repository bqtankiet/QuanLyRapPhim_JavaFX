package controllers;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import database.RapList;
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
import models.tableViewItem.PhongChieuItem;
import models.tableViewItem.RapItem;
import utils.AlertDialog;
import utils.PaneController;

public class RapController implements Initializable {
	public static final String FXML = "/views/rap/rap.fxml";

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
		PaneController.getInstance().replacePane(rootPane, SoDoGheNgoiController.FXML);
	}

	private void saveBtnOnAction() {
		if(prevDataRap.equals(dataRap)) return; //do nothing
		RapList.setAllFromObserableList(dataRap);
		System.out.println(RapList.listRap.size());
		AlertDialog.showConfirmAlert("Lưu thành công");
		updatePrevRapData();
	}

	private void themRapBtnAction() {
		// kiem tra thay doi
		boolean hasChange = !prevDataRap.equals(dataRap);
		if (hasChange) {
			AlertDialog.showConfirmAlert("Hãy lưu lại thay đổi trước khi thêm rạp mới");
			return;
		}
		// tao rap moi
		Rap rap = new Rap("NULL", "NULL");
		// clear bang chi tiet thong tin
//		phongTable.getItems().clear();
//		tenRapField.setText(rap.getTenRap());
//		diaChiField.setText(rap.getDiaChi());
		// them rap moi vao tableview
		dataRap.add(rap.createRapItem());
		tableView.setItems(dataRap);
		for (RapItem item : dataRap) {
			tenRapField.textProperty().unbindBidirectional(item.tenRap);
			diaChiField.textProperty().unbindBidirectional(item.diaChi);
		}
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
		for (Rap rap : RapList.getAll()) {
			dataRap.add(rap.createRapItem());
		}
		updatePrevRapData();
		tableView.setItems(dataRap);
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
