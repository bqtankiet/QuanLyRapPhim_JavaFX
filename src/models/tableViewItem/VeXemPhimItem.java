package models.tableViewItem;

import javafx.beans.property.SimpleStringProperty;
import models.VeXemPhim;

public class VeXemPhimItem {

	private VeXemPhim ve;
	public SimpleStringProperty maVe;
	public SimpleStringProperty thoiGian;
	public SimpleStringProperty phong;
	public SimpleStringProperty phim;
	public SimpleStringProperty gheDaDat;
	public SimpleStringProperty trangThai;

	public VeXemPhimItem(VeXemPhim ve) {
		this.ve = ve;
		this.maVe = new SimpleStringProperty(ve.getMaVe() + "");
		this.thoiGian = new SimpleStringProperty(ve.getSuatChieu().getThoigian() + "");
		this.phong = new SimpleStringProperty(ve.getSuatChieu().getPhong().getTenPhong());
		this.phim = new SimpleStringProperty(ve.getSuatChieu().getPhim().getTenPhim());
		this.gheDaDat = new SimpleStringProperty(ve.getBookingGhe().toString());
		this.trangThai = new SimpleStringProperty(ve.getTrangThai());
	}

	public VeXemPhim getVe() {
		return ve;
	}

	public void setVe(VeXemPhim ve) {
		this.ve = ve;
	}

	public SimpleStringProperty getMaVe() {
		return maVe;
	}

	public void setMaVe(SimpleStringProperty maVe) {
		this.maVe = maVe;
	}

	public SimpleStringProperty getThoiGian() {
		return thoiGian;
	}

	public void setThoiGian(SimpleStringProperty thoiGian) {
		this.thoiGian = thoiGian;
	}

	public SimpleStringProperty getPhong() {
		return phong;
	}

	public SimpleStringProperty getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(SimpleStringProperty trangThai) {
		this.trangThai = trangThai;
	}

	public void setPhong(SimpleStringProperty phong) {
		this.phong = phong;
	}

	public SimpleStringProperty getPhim() {
		return phim;
	}

	public void setPhim(SimpleStringProperty phim) {
		this.phim = phim;
	}

	public SimpleStringProperty getGheDaDat() {
		return gheDaDat;
	}

	public void setGheDaDat(SimpleStringProperty gheDaDat) {
		this.gheDaDat = gheDaDat;
	}

}
