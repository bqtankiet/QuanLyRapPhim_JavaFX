package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class ThanhToanBangTienMatController extends AbstractController{
	public static final String FXML = "/views/banve/ThanhToanBangTienMat.fxml";
	private ThanhToanController parentController;


    @FXML
    private AnchorPane root;
    
    @FXML 
    private Button backButton;

	@Override
	public void eventHandling() {
		// TODO Auto-generated method stub
		backButton.setOnAction(event -> handleBackButton());
	}

	private void handleBackButton() {
		parentController.loadSubView(ChonHinhThucThanhToanController.FXML);
	}
	
	@Override
	public void initView() {
		// TODO Auto-generated method stub
		parentController = ThanhToanController.getInstance();
	}

}
