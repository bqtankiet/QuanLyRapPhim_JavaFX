package models.strategyPattern;

import controllers.ThanhToanController;
import utils.AlertDialog;

public class VNPayStrategy implements ThanhToanStrategy {
	private ThanhToanController context;
	
	
	public VNPayStrategy(ThanhToanController context) {
		this.context = context;
	}

	@Override
	public void handleStrategy() {
		System.out.println("VNPay Strategy");
		AlertDialog.showConfirmAlert("COMING SOON: Thanh toán qua VNPay đang phát triển, sẽ được hỗ trợ trong tương lai");
	}

}
