package models.strategyPattern;

import controllers.ThanhToanController;

public class VNPayStrategy implements ThanhToanStrategy {
	private ThanhToanController context;
	
	
	public VNPayStrategy(ThanhToanController context) {
		this.context = context;
	}

	@Override
	public void handleStrategy() {
		System.out.println("VNPay Strategy");
	}

}
