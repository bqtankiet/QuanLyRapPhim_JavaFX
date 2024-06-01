package controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import models.HoaDon;
import models.strategyPattern.ThanhToanStrategy;

public class ThanhToanController extends AbstractController {
	public static final String FXML = "/views/banve/ThanhToan.fxml";

	private static ThanhToanController instance;

	public static ThanhToanController getInstance() {
		return instance;
	}

	private ThanhToanStrategy thanhToanStrategy;
	
	private HoaDon hoaDon;

	@FXML
	private Button huyDatVeBtn;

	@FXML
	private AnchorPane mainPane;

	@FXML
	private Button step1Btn;

	@FXML
	private Button step2Btn;

	@Override
	public void eventHandling() {
		setupButtonHandlers();
	}

	@Override
	public void initView() {
		instance = this;
		loadSubView(ChonHinhThucThanhToanController.FXML);
	}

	public void loadSubView(String fxml) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxml));
			Parent subView = fxmlLoader.load();
			mainPane.getChildren().clear();
			mainPane.getChildren().add(subView);
			AnchorPane.setBottomAnchor(subView, 0d);
			AnchorPane.setLeftAnchor(subView, 0d);
			AnchorPane.setTopAnchor(subView, 0d);
			AnchorPane.setRightAnchor(subView, 0d);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void setupButtonHandlers() {
		huyDatVeBtn.setOnAction(event -> DatVeController.getInstance().closeView());
		step1Btn.setOnAction(event -> DatVeController.getInstance().goBackStep1());
		step2Btn.setOnAction(event -> DatVeController.getInstance().goBackStep2());
	}

	public void doStrategy(ThanhToanStrategy strategy) {
		this.thanhToanStrategy = strategy;
		thanhToanStrategy.handleStrategy();
	}

	public void setHoaDon(HoaDon thanhToan) {
		this.hoaDon = thanhToan;
	}
	
	public HoaDon getHoaDon() {
		return this.hoaDon;
	}
	
}
