package models;

import java.util.ArrayList;
import java.util.List;

import models.tableViewItem.RapItem;

public class Rap {
	private String tenRap;
	private String diaChi;
	private List<PhongChieu> dsPhongChieu;

	public Rap(String tenRap, String diaChi) {
		super();
		this.tenRap = tenRap;
		this.diaChi = diaChi;
		this.dsPhongChieu = new ArrayList<>();
	}

	// ###### GETTER, SETTER ##########
	
	public List<PhongChieu> getDsPhongChieu() {
		return dsPhongChieu;
	}

	public void setDsPhongChieu(List<PhongChieu> dsPhongChieu) {
		this.dsPhongChieu = dsPhongChieu;
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
	// ###### END GETTER, SETTER ##########

	public RapItem createRapItem() {
		return new RapItem(this);
	}

	public void themPhongChieu(PhongChieu phongChieu) {
		dsPhongChieu.add(phongChieu);
	}

	public int getSoPhong() {
		return this.dsPhongChieu.size();
	}

}
