package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
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

	private Object themphimBtnOnClick() {
//		try {
//			Pane replacePane = FXMLLoader.load(getClass().getResource("/views/phim/themphim.fxml"));
//			BorderPane parent = (BorderPane) rootPane.getParent();
//			parent.setCenter(replacePane);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		PaneController.getInstance().replacePane(rootPane, ThemPhimController.FXML);
		return null;
	}
	
	public void themPhim(Phim phim) {
		data.add(new PhimItem(phim));
		tableView.setItems(data);
		StoragePhim.data.add(phim);
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
	}

	private void loadData() {
		for (Phim phim : StoragePhim.data) {
			data.add(new PhimItem(phim));
		}
		tableView.setItems(data);
	}
}
