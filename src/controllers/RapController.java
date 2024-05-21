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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import models.Rap;
import models.RapItem;
import utils.PaneController;

public class RapController implements Initializable {
	public static final String FXML = "/views/rap/rap.fxml";
	
	@FXML
	private TableView<RapItem> tableView;

	@FXML
	private TableColumn<RapItem, String> diaChiColumn;

	@FXML
	private AnchorPane rootPane;

	@FXML
	private AnchorPane thongTinPane;

	@FXML
	private TableColumn<RapItem, String> soPhongColumn;

	@FXML
	private TableColumn<RapItem, String> tenRapColumn;

	@FXML
	private TableColumn<RapItem, String> trangThaiColumn;

	@FXML
	private TextField diaChiField;

	@FXML
	private TextField tenRapField;

	@FXML
	private Button themRapBtn;
	
	@FXML
	private Button themPhongChieuBtn;

	private ObservableList<RapItem> data = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		thongTinPane.setVisible(false);
		tableView.setOnMouseClicked(event -> rowClicked());
		themRapBtn.setOnAction(event -> themRapBtnAction());
		themPhongChieuBtn.setOnAction(event -> themPhongChieuBtnAction());
		setupTableView();
		loadData();
	}

	private Object themPhongChieuBtnAction() {
		PaneController.getInstance().replacePane(rootPane, SoDoGheNgoiController.FXML);
		return null;
	}

	private Object themRapBtnAction() {
		Rap rap = new Rap("NULL", "NULL");
		tenRapField.setText(rap.getTenRap());
		diaChiField.setText(rap.getDiaChi());
		data.add(rap.getRapItem());
		tableView.setItems(data);
		tableView.getSelectionModel().select(data.size()-1);
		tableView.requestFocus();
		tableView.getFocusModel().focus(data.size()-1);
		tableView.scrollTo(data.size()-1);
		return null;
	}

	private Object rowClicked() {
		RapItem clickedRap = tableView.getSelectionModel().getSelectedItem();
		if(clickedRap == null) return null;
		tenRapField.setText(clickedRap.getTenRap());
		diaChiField.setText(clickedRap.getDiaChi());
		return null;
	}

	private void loadData() {
		data.add(Rap.getSampleRap().getRapItem());
		data.add(Rap.getSampleRap().getRapItem());
		data.add(Rap.getSampleRap().getRapItem());
		tableView.setItems(data);

	}

	private void setupTableView() {
		tenRapColumn.setCellValueFactory(new PropertyValueFactory<>("tenRap"));
		diaChiColumn.setCellValueFactory(new PropertyValueFactory<>("diaChi"));
		tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			if (newSelection != null) {
				thongTinPane.setVisible(true);
			} else {
				thongTinPane.setVisible(false);
			}
		});
	}

}
