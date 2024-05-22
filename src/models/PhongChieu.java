package models;

import java.util.List;
import java.util.Objects;

import models.enums.LoaiPhong;

public class PhongChieu {

	private String tenPhong;
	private LoaiPhong loaiPhong;
	private int soHang, soDay;
	private List<Ghe> dsGhe;

	public PhongChieu(String tenPhong, LoaiPhong loaiPhong, int soHang, int soDay) {
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

	public LoaiPhong getLoaiPhong() {
		return loaiPhong;
	}

	public void setLoaiPhong(LoaiPhong loaiPhong) {
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

	@Override
	public String toString() {
		return String.format("%s, %s, %s day, %s hang", tenPhong, loaiPhong, soDay, soHang);
	}
	
	public int getSoLuongGhe() {
		return this.soDay * this.soHang;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhongChieu that = (PhongChieu) o;
        return soHang == that.soHang &&
                soDay == that.soDay &&
                Objects.equals(tenPhong, that.tenPhong) &&
                loaiPhong == that.loaiPhong &&
                Objects.equals(dsGhe, that.dsGhe);
    }
	
}
