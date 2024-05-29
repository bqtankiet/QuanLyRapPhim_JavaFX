package controllers;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import models.Phim;

public class PhimCardController implements Initializable{
	public static String FXML = "/views/items/PhimCard.fxml";

    @FXML
    private ImageView imageview;

    @FXML
    private Label tenphimLbl;

    @FXML
    private Label theloaiLbl;

    @FXML
    private Label thoiluongLbl;
    
    @FXML
    private VBox root;
    
    private Phim phim;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		handleCardOnClicked();
		handleCardHoverEffect();
		
	}

	private void handleCardOnClicked() {
		root.setOnMouseClicked(event -> {
			//TODO: 
//			System.out.println(phim);
			System.out.println(BanVeController.getInstance().mapSuatChieu.get(phim));
		});
	}

	private void handleCardHoverEffect() {
		root.setOnMouseEntered(event -> {
			root.setStyle("-fx-background-color: lightgray");
		});
		root.setOnMouseExited(event -> {
			root.setStyle("-fx-background-color: #f0f0f0");
		});
	}

	public void setData(Phim phim) {
		this.phim = phim;
		// set image
		File file = new File(phim.getHinhAnh());
		Image image = new Image(file.toURI().toString());
		imageview.setImage(image);
		
		// set label
		tenphimLbl.setText(phim.getTenPhim());
		theloaiLbl.setText(phim.getTheLoai());
		thoiluongLbl.setText(phim.getThoiLuong()+" Phút");
	}
	
}
