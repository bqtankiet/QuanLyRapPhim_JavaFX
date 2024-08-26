package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import utils.AlertDialog;

public class KhuyenMaiController implements Initializable{
	public static final String FXML = "/views/khuyenmai/khuyenmai.fxml";
	
	@FXML
	private Button themKhuyenMaiBtn;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		themKhuyenMaiBtn.setOnAction(event -> handleThemKhuyenMaiBtn());
	}


	private void handleThemKhuyenMaiBtn() {
		AlertDialog.showConfirmAlert("COMING SOON: Chức năng đang phát triển");
	}

	
	
}
