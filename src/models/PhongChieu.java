package models;

import java.util.List;

public class PhongChieu {

	private String tenPhong;
	private String loaiPhong;
	private int soHang, soDay;
	private List<Ghe> dsGhe;

	public PhongChieu(String tenPhong, String loaiPhong, int soHang, int soDay) {
		super();
		this.tenPhong = tenPhong;
		this.loaiPhong = loaiPhong;
		this.soHang = soHang;
		this.soDay = soDay;
	}

	// ###### GETTER, SETTER ##########
	public String getTenPhong() {
		return tenPhong;
	}

	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}

	public String getLoaiPhong() {
		return loaiPhong;
	}

	public void setLoaiPhong(String loaiPhong) {
		this.loaiPhong = loaiPhong;
	}

	public int getSoHang() {
		return soHang;
	}

	public void setSoHang(int soHang) {
		this.soHang = soHang;
	}

	public int getSoDay() {
		return soDay;
	}

	public void setSoDay(int soDay) {
		this.soDay = soDay;
	}

	public List<Ghe> getDsGhe() {
		return dsGhe;
	}

	public void setDsGhe(List<Ghe> dsGhe) {
		this.dsGhe = dsGhe;
	}

	// ###### END GETTER, SETTER ##########

	public int getSoLuongGhe() {
		return this.soDay * this.soHang;
	}

}
