package controllers;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import models.HoaDon;
import models.VeXemPhim;
import models.statePattern.StateDatVe;

public class ThanhToanState implements StateDatVe {
	
	private DatVeController context;
	private FXMLLoader fxmlLoader;
	
	
	public ThanhToanState(DatVeController context) {
		this.context = context;
	}

	@Override
	public void handleStep() {
		loadThanhToanView();
		createThanhToan();
	}

	private void createThanhToan() {
		VeXemPhim veXemPhim = context.getDatVe().createVeXemPhim();
		HoaDon hoaDon = new HoaDon(veXemPhim);
		hoaDon.setHinhThucThanhToan("Tien Mat");
		ThanhToanController controller = fxmlLoader.getController();
		controller.setHoaDon(hoaDon);
	}

	private void loadThanhToanView() {
		try {
			fxmlLoader = new FXMLLoader(getClass().getResource(ThanhToanController.FXML));
			VBox thanhToanView = fxmlLoader.load();
			context.getStepDatVeArea().getChildren().add(thanhToanView);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

}
