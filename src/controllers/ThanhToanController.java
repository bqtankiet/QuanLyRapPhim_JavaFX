package controllers;

import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import models.strategyPattern.ThanhToanStrategy;
import models.strategyPattern.TienMatStrategy;
import models.strategyPattern.VNPayStrategy;

public class ThanhToanController extends AbstractController{
	public static final String FXML = "/views/banve/ThanhToan.fxml";
	
	private ThanhToanStrategy thanhToanStrategy;

	@FXML
	private HBox cashPayment;

	@FXML
	private Button huyDatVeBtn;

	@FXML
	private AnchorPane mainPane;

	@FXML
	private Button step1Btn;

	@FXML
	private Button step2Btn;

	@FXML
	private HBox vnpayPayment;

	@FXML
	private ImageView cashImage, vnpayImage;
	
	@Override
	public void eventHandling() {
		setupButtonHandlers();
	}

	@Override
	public void initView() {
		// TODO Auto-generated method stub
		loadImage();
	}

	private void loadImage() {
		File file = new File("resource/images/cash-payment.png");
		Image image = new Image(file.toURI().toString());
		cashImage.setImage(image);
		
		file = new File("resource/images/vnpay-payment.png");
		image = new Image(file.toURI().toString());
		vnpayImage.setImage(image);
	}
	
	private void setupButtonHandlers() {
		huyDatVeBtn.setOnAction(event -> DatVeController.getInstance().closeView());
		step1Btn.setOnAction(event -> DatVeController.getInstance().goBackStep1());
		step2Btn.setOnAction(event -> DatVeController.getInstance().goBackStep2());
		cashPayment.setOnMouseClicked(event -> handleCashPaymentClicked());
		vnpayPayment.setOnMouseClicked(event -> handleVNPayPaymentClicked());
	}

	
	private void handleVNPayPaymentClicked() {
		thanhToanStrategy = new VNPayStrategy();
		thanhToanStrategy.handleStrategy();
	}

	private void handleCashPaymentClicked() {
		thanhToanStrategy = new TienMatStrategy();
		thanhToanStrategy.handleStrategy();
	}
	

}
