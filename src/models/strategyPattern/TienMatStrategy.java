package models.strategyPattern;

public class TienMatStrategy implements ThanhToanStrategy{

	@Override
	public void handleStrategy() {
		System.out.println("Tien Mat Strategy");
	}

}
