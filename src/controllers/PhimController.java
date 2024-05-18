package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Phim;
import models.PhimItem;

public class PhimController implements Initializable {

	@FXML
	private TableColumn<PhimItem, String> hinhAnhColumn;

	@FXML
	private TableColumn<PhimItem, String> ngayKhoiChieuColumn;

	@FXML
	private TableColumn<PhimItem, String> quocGiaColumn;

	@FXML
	private TableColumn<PhimItem, String> tenPhimColumn;

	@FXML
	private TableColumn<PhimItem, String> theLoaiColumn;

	@FXML
	private TableColumn<PhimItem, Integer> thoiLuongColumn;

	@FXML
	private TableView<PhimItem> tableView;

	private ObservableList<PhimItem> data = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setupTableView();
		loadData();
	}

	private void setupTableView() {
		hinhAnhColumn.setPrefWidth(120);
		hinhAnhColumn.setCellValueFactory(new PropertyValueFactory<>("hinhAnh"));
		theLoaiColumn.setCellValueFactory(new PropertyValueFactory<>("theLoai"));
		tenPhimColumn.setCellValueFactory(new PropertyValueFactory<>("tenPhim"));
		thoiLuongColumn.setCellValueFactory(new PropertyValueFactory<>("thoiLuong"));
		quocGiaColumn.setCellValueFactory(new PropertyValueFactory<>("quocGia"));
		ngayKhoiChieuColumn.setCellValueFactory(new PropertyValueFactory<>("ngayKhoiChieu"));
	}

	private void loadData() {
		data.add(Phim.getSamplePhim().getPhimItem());
		data.add(Phim.getSamplePhim().getPhimItem());
		data.add(Phim.getSamplePhim().getPhimItem());
		data.add(Phim.getSamplePhim().getPhimItem());
		data.add(Phim.getSamplePhim().getPhimItem());
		tableView.setItems(data);
	}
}
