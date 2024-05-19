package models;

public class Rap {

	private String tenRap;
	private String diaChi;

	public Rap(String tenRap, String diaChi) {
		super();
		this.tenRap = tenRap;
		this.diaChi = diaChi;
	}

	public String getTenRap() {
		return tenRap;
	}

	public void setTenRap(String tenRap) {
		this.tenRap = tenRap;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

}
