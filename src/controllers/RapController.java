package controllers;

import java.net.URL;
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
import models.tableViewItem.PhongChieuItem;
import models.tableViewItem.RapItem;
import test.RapTest;
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
	private Button themRapBtn;
	
	@FXML
	private Button themPhongChieuBtn;

	private ObservableList<RapItem> data = FXCollections.observableArrayList();
	private ObservableList<PhongChieuItem> dataPhongChieu = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		thongTinPane.setVisible(false);
		tableView.setOnMouseClicked(event -> tableviewRowOnClick());
		themRapBtn.setOnAction(event -> themRapBtnAction());
		themPhongChieuBtn.setOnAction(event -> themPhongChieuBtnAction());
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
	
	private void themRapBtnAction() {
		Rap rap = new Rap("NULL", "NULL");
		// clear bang chi tiet thong tin
		phongTable.getItems().clear();
		tenRapField.setText(rap.getTenRap());
		diaChiField.setText(rap.getDiaChi());
		// them rap moi vao tableview
		data.add(rap.createRapItem());
		tableView.setItems(data);
		tableView.getSelectionModel().select(data.size()-1);
		tableView.requestFocus();
		tableView.getFocusModel().focus(data.size()-1);
		tableView.scrollTo(data.size()-1);
	}

	private void tableviewRowOnClick() {
		RapItem clickedRap = tableView.getSelectionModel().getSelectedItem();
		if(clickedRap == null) return;
		tenRapField.setText(clickedRap.getTenRap());
		diaChiField.setText(clickedRap.getDiaChi());
		List<PhongChieu> dsPhongChieu = clickedRap.getRap().getDsPhongChieu();
		phongTable.getItems().clear();
		for (PhongChieu phong : dsPhongChieu) {
			dataPhongChieu.add(new PhongChieuItem(phong));
		}
		phongTable.setItems(dataPhongChieu);
	}

	private void loadData() {
		data.add(RapTest.getSampleRap().createRapItem());
		data.add(RapTest.getSampleRap().createRapItem());
		data.add(RapTest.getSampleRap().createRapItem());
		tableView.setItems(data);
	}

	private void setupTableView() {
		tenRapColumn.setCellValueFactory(new PropertyValueFactory<>("tenRap"));
		diaChiColumn.setCellValueFactory(new PropertyValueFactory<>("diaChi"));
		soPhongColumn.setCellValueFactory(new PropertyValueFactory<>("soPhong"));
		tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			if (newSelection != null) {
				thongTinPane.setVisible(true);
			} else {
				thongTinPane.setVisible(false);
			}
		});
		loadData();
	}

}
