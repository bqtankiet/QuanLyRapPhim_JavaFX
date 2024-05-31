package controllers;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import models.DatVe;
import models.VeXemPhim;
import models.statePattern.StateDatVe;

public class ThanhToanState implements StateDatVe {
	
	private DatVeController context;
	private DatVe datVe;
	
	
	public ThanhToanState(DatVeController context) {
		this.context = context;
		this.datVe = context.getDatVe();
	}

	@Override
	public void handleStep() {
		VeXemPhim veXemPhim = datVe.createVeXemPhim();
		loadThanhToanView();
	}

	private void loadThanhToanView() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ThanhToanController.FXML));
			VBox thanhToanView = fxmlLoader.load();
			context.getStepDatVeArea().getChildren().add(thanhToanView);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

}
