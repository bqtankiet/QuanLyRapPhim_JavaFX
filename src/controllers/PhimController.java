package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import models.Phim;
import models.tableViewItem.PhimItem;
import storage.StoragePhim;
import utils.PaneController;

public class PhimController implements Initializable {
	public static final String FXML = "/views/phim/phim.fxml";
	private static PhimController instance;

	public static PhimController getInstance() {
		if (instance == null) {
			instance = new PhimController();
		}
		return instance;
	}

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

	@FXML
	private AnchorPane rootPane;

	@FXML
	private Button themphimBtn;

	private ObservableList<PhimItem> data = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("test");
		instance = this;
		setupTableView();
		loadData();
		themphimBtn.setOnAction(event -> themphimBtnOnClick());
	}

	private void themphimBtnOnClick() {
//		PaneController.getInstance().replacePane(rootPane, ThemPhimController.FXML);
		Pane masterpane = PaneController.getInstance().getRootPane();
		PaneController.getInstance().addPane(masterpane, ThemPhimController.FXML);
		ThemPhimController.getInstance().setState("add");
	}

	public void themPhim(Phim phim) {
		StoragePhim.data.add(phim);
		this.data.add(new PhimItem(phim));
		tableView.setItems(data);
		System.out.println(StoragePhim.data.toString());
	}

	private void setupTableView() {
		hinhAnhColumn.setPrefWidth(120);
		hinhAnhColumn.setCellValueFactory(new PropertyValueFactory<>("hinhAnh"));
		theLoaiColumn.setCellValueFactory(new PropertyValueFactory<>("theLoai"));
		tenPhimColumn.setCellValueFactory(new PropertyValueFactory<>("tenPhim"));
		thoiLuongColumn.setCellValueFactory(new PropertyValueFactory<>("thoiLuong"));
		quocGiaColumn.setCellValueFactory(new PropertyValueFactory<>("quocGia"));
		ngayKhoiChieuColumn.setCellValueFactory(new PropertyValueFactory<>("ngayKhoiChieu"));
		tableView.setRowFactory(tv -> {
			TableRow<PhimItem> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (event.getClickCount() == 2 && (!row.isEmpty())) {
					PhimItem rowData = row.getItem();
//					PaneController.getInstance().replacePane(rootPane, ThemPhimController.FXML);
					Pane masterpane = PaneController.getInstance().getRootPane();
					PaneController.getInstance().addPane(masterpane, ThemPhimController.FXML);
					ThemPhimController.getInstance().loadData(rowData.getPhim());
					ThemPhimController.getInstance().setState("edit");
				}
			});
			return row;
		});
	}

	private void loadData() {
		for (Phim phim : StoragePhim.data) {
			data.add(new PhimItem(phim));
		}
		tableView.setItems(data);
	}

	public void chinhSua(Phim phim) {
		StoragePhim.data.set(getSelectedIndex(), phim);
		data.set(getSelectedIndex(), new PhimItem(phim));
	}
	
	public int getSelectedIndex() {
		return tableView.getSelectionModel().getSelectedIndex();
	}
}
