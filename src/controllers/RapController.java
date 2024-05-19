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

public class RapController implements Initializable {
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

	private ObservableList<RapItem> data = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		thongTinPane.setVisible(false);
		tableView.setOnMouseClicked(event -> rowClicked());
		setupTableView();
		loadData();
	}

	private Object rowClicked() {
		RapItem clickedRap = tableView.getSelectionModel().getSelectedItem();
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
