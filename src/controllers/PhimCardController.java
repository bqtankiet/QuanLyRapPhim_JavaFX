package controllers;

import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import models.DatVe;
import models.LichChieu;
import models.Phim;
import models.Rap;
import models.UserData;

public class PhimCardController extends AbstractController {
	public static final String FXML = "/views/items/PhimCard.fxml";

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
	public void eventHandling() {
		handleCardOnClicked();
		handleCardHoverEffect();
	}

	@Override
	public void initView() {
		// không cần thiết lập view ban đầu
	}

	private void handleCardOnClicked() {
		root.setOnMouseClicked(event -> {
			UserData.getInstance().putData("bookingPhim", phim);
			DatVeController.displayView();
		});
	}

	private void handleCardHoverEffect() {
		root.setOnMouseEntered(event -> root.setStyle("-fx-background-color: lightgray"));
		root.setOnMouseExited(event -> root.setStyle("-fx-background-color: #f0f0f0"));
	}

	public void setData(Phim phim) {
		this.phim = phim;
		updateCardView();
	}

	private void updateCardView() {
		setImage(phim.getHinhAnh());
		setLabels(phim);
	}

	private void setImage(String imagePath) {
		File file = new File(imagePath);
		Image image = new Image(file.toURI().toString());
		imageview.setImage(image);
	}

	private void setLabels(Phim phim) {
		tenphimLbl.setText(phim.getTenPhim());
		theloaiLbl.setText(phim.getTheLoai());
		thoiluongLbl.setText(phim.getThoiLuong() + " Phút");
	}

}
