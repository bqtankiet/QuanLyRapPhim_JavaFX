package controllers;

import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import models.strategyPattern.TienMatStrategy;
import models.strategyPattern.VNPayStrategy;

public class ChonHinhThucThanhToanController extends AbstractController {
	public static final String FXML = "/views/banve/ChonHinhThucThanhToan.fxml";
	
	private ThanhToanController parentController;

	@FXML
	private ImageView cashImage;

	@FXML
	private HBox cashPayment;

	@FXML
	private AnchorPane root;

	@FXML
	private ImageView vnpayImage;

	@FXML
	private HBox vnpayPayment;

	@Override
	public void eventHandling() {
		// TODO Auto-generated method stub
		cashPayment.setOnMouseClicked(event -> handleCashPaymentClicked());
		vnpayPayment.setOnMouseClicked(event -> handleVNPayPaymentClicked());

	}

	@Override
	public void initView() {
		// TODO Auto-generated method stub
		parentController = ThanhToanController.getInstance();
		loadImage();

	}

	private void handleVNPayPaymentClicked() {
		parentController.doStrategy(new VNPayStrategy(parentController));
	}

	private void handleCashPaymentClicked() {
		parentController.doStrategy(new TienMatStrategy(parentController));
	}

	private void loadImage() {
		File file = new File("resource/images/cash-payment.png");
		Image image = new Image(file.toURI().toString());
		cashImage.setImage(image);

		file = new File("resource/images/vnpay-payment.png");
		image = new Image(file.toURI().toString());
		vnpayImage.setImage(image);
	}
	
	public void setParentController(ThanhToanController controller) {
		this.parentController = controller;
	}

}
