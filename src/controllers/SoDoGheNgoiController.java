package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import models.Ghe;
import models.PhongChieu;
import models.enums.LoaiGhe;
import models.enums.LoaiPhong;
import utils.SceneController;

public class SoDoGheNgoiController extends AbstractController {
    public static final String FXML = "/views/rap/soDoGheNgoi.fxml";

    @FXML private AnchorPane rootPane;
    @FXML private GridPane gridpane;
    @FXML private ChoiceBox<LoaiPhong> loaiPhongChoiceBox;
    @FXML private TextField soDayField;
    @FXML private TextField soHangField;
    @FXML private TextField tenPhongField;
    @FXML private Button taoSoDoGheBtn;
    @FXML private Button huyBtn;
    @FXML private Button luuBtn;
    @FXML private Button gheThuong;
    @FXML private Button gheVIP;
    @FXML private Button gheCouple;

    private PhongChieu phong;

    @Override
	public void eventHandling() {
    	 taoSoDoGheBtn.setOnAction(event -> handleCreateSeatingChart());
         huyBtn.setOnAction(event -> handleCancel());
         luuBtn.setOnAction(event -> handleSave());
	}

	@Override
	public void initView() {
        initializeChoiceBox();
	}
    
    // Initialize choice box with room types
    private void initializeChoiceBox() {
        ObservableList<LoaiPhong> choiceboxData = FXCollections.observableArrayList(
            LoaiPhong.PHONG_2D,
            LoaiPhong.PHONG_3D,
            LoaiPhong.Phong_4D,
            LoaiPhong.Phong_IMAX
        );
        loaiPhongChoiceBox.setItems(choiceboxData);
        loaiPhongChoiceBox.setValue(LoaiPhong.PHONG_2D);
    }

    // Save the room layout
    private void handleSave() {
        if (phong == null) return;
        RapController.getInstance().themPhongChieu(phong);
        SceneController.GetInstance().removePane(rootPane);
    }

    // Cancel the operation
    private void handleCancel() {
        SceneController.GetInstance().removePane(rootPane);
    }

    // Create the seating chart
    private void handleCreateSeatingChart() {
        try {
            int soDay = Integer.parseInt(soDayField.getText());
            int soHang = Integer.parseInt(soHangField.getText());
            String tenPhong = tenPhongField.getText();
            LoaiPhong loaiPhong = loaiPhongChoiceBox.getValue();
            phong = new PhongChieu(tenPhong, loaiPhong, soHang, soDay);
            Ghe[][] soDoGhe = phong.getSoDoGhe();
            generateSeatingChart(soDoGhe);
        } catch (NumberFormatException e) {
            // Handle the exception (e.g., show an error message)
        }
    }

    // Generate the seating chart
    private void generateSeatingChart(Ghe[][] soDoGhe) {
        gridpane.getChildren().clear();

        for (int hang = 0; hang < soDoGhe.length; hang++) {
        	int soDay = soDoGhe[hang].length;
            for (int day = 0; day < soDay; day++) {
                Button seatButton = createSeatButton(soDoGhe[hang][day]);
                gridpane.add(seatButton, day, hang);
            }
        }
    }

    // Create a button for a seat
    private Button createSeatButton(Ghe ghe) {
        Button seatButton = new Button(ghe.getHang() + "" + ghe.getDay());
        seatButton.setMinSize(40, 40);
        seatButton.setMaxSize(40, 40);
        seatButton.setStyle(getSeatStyle(ghe.getLoaiGhe()));
        seatButton.setOnAction(event -> handleSeatButtonClick(seatButton));
        return seatButton;
    }

    // Get the style for a seat based on its type
    private String getSeatStyle(LoaiGhe loaiGhe) {
        return switch (loaiGhe) {
            case THUONG -> gheThuong.getStyle();
            case VIP -> gheVIP.getStyle();
            case COUPLE -> gheCouple.getStyle();
            default -> "";
        };
    }

    // Handle seat button click
    private void handleSeatButtonClick(Button seatButton) {
        System.out.println("Seat " + seatButton.getText() + " clicked");
    }

}
