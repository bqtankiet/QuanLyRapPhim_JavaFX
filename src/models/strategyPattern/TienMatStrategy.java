package models.strategyPattern;

import controllers.ThanhToanBangTienMatController;
import controllers.ThanhToanController;

public class TienMatStrategy implements ThanhToanStrategy{
	private ThanhToanController context;

	public TienMatStrategy(ThanhToanController context) {
		this.context = context;
	}

	@Override
	public void handleStrategy() {
		System.out.println("Tien Mat Strategy");
		context.loadSubView(ThanhToanBangTienMatController.FXML);
	}

}
