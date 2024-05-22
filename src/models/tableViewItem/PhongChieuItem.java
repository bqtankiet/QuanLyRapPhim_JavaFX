package models.tableViewItem;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import models.PhongChieu;

public class PhongChieuItem {

	private PhongChieu phongChieu;
	private SimpleStringProperty tenPhong;
	private SimpleStringProperty loaiPhong;
	private SimpleIntegerProperty soGhe;
	
	public PhongChieuItem(PhongChieu phongChieu) {
		this.phongChieu = phongChieu;
		this.tenPhong = new SimpleStringProperty(phongChieu.getTenPhong());
		this.loaiPhong = new SimpleStringProperty(phongChieu.getLoaiPhong().toString());
		this.soGhe = new SimpleIntegerProperty(phongChieu.getSoLuongGhe());
	}

	// ### GETTER SETTER ###
	public PhongChieu getPhongChieu() {
		return phongChieu;
	}

	public void setPhongChieu(PhongChieu phongChieu) {
		this.phongChieu = phongChieu;
	}

	public String getTenPhong() {
		return tenPhong.get();
	}

	public void setTenPhong(SimpleStringProperty tenPhong) {
		this.tenPhong = tenPhong;
	}

	public String getLoaiPhong() {
		return loaiPhong.get();
	}

	public void setLoaiPhong(SimpleStringProperty loaiPhong) {
		this.loaiPhong = loaiPhong;
	}

	public Integer getSoGhe() {
		return soGhe.get();
	}

	public void setSoGhe(SimpleIntegerProperty soGhe) {
		this.soGhe = soGhe;
	}
	
	// ### END GETTER SETTER ###
	
	
}
