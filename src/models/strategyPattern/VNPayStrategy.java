package models.strategyPattern;

public class VNPayStrategy implements ThanhToanStrategy {

	@Override
	public void handleStrategy() {
		System.out.println("VNPay Strategy");
	}

}
