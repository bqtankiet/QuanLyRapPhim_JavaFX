package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import utils.PaneController;

public class SoDoGheNgoiController implements Initializable {
	public static final String FXML = "/views/rap/soDoGheNgoi.fxml";

	@FXML
	private AnchorPane rootPane;
	
	@FXML
	private GridPane gridpane;

	@FXML
	private ChoiceBox<String> loaiPhongChoiceBox;

	@FXML
	private TextField soDayField;

	@FXML
	private TextField soHangField;

	@FXML
	private Button taoSoDoGheBtn;
	
	@FXML
	private Button huyBtn;
	
	@FXML
	private Button luuBtn;

	@FXML
	private TextField tenPhongField;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		taoSoDoGheBtn.setOnAction(event -> taoSoDoGheBtnAction());
		huyBtn.setOnAction(event -> huyBtnAction());
	}

	private Object huyBtnAction() {
		PaneController.getInstance().replacePane(rootPane, RapController.FXML);
		return null;
	}

	private Object taoSoDoGheBtnAction() {
		int rows = 0, columns = 0;
		try {
			rows = Integer.parseInt(soHangField.getText());
			columns = Integer.parseInt(soDayField.getText());
		} catch (Exception e) {
		}
		generateSeatingChart(rows, columns);
		return null;
	}

	private void generateSeatingChart(int rows, int columns) {
		gridpane.getChildren().clear();

		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < columns; col++) {
				Button seatButton = new Button();
				seatButton.setMinSize(40, 40);
				seatButton.setMaxSize(40, 40);
				
				// Set button text to row letter and column number
				String seatLabel = (char) ('A' + row) + String.valueOf(col + 1);
				seatButton.setText(seatLabel);

				// Optional: Add event handler for button clicks
				seatButton.setOnAction(event -> {
					// TODO: xử lý sự kiện khi ấn vào ghế
					System.out.println("Seat " + seatButton.getText() + " clicked");
				});
				// Add button to gridPane
				gridpane.add(seatButton, col, row);
			}
		}
	}

}
