package models;

import java.util.List;

public class Rap {

	private String tenRap;
	private String diaChi;
	private List<PhongChieu> dsPhongChieu;

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

	public RapItem getRapItem() {
		return new RapItem(this);
	}
	
	public static Rap getSampleRap() {
		return new Rap("Rap CGV VinCom Thu Duc", "Linh Trung, Thu Duc");
	}
	
}
