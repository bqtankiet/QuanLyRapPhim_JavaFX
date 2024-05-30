package models;

import java.util.ArrayList;
import java.util.HashMap;

import models.enums.LoaiKhachHang;

public class VeXemPhim {
	private String maVe;
	private SuatChieu suatChieu;
	private ArrayList<Ghe> listGhe;
	private HashMap<LoaiKhachHang, Integer> soLuongVe;
	
	public VeXemPhim(SuatChieu suatChieu) {
		this.suatChieu = suatChieu;
	}
	
	public String getThoiGianChieu() {
		return suatChieu.getThoigian();
	}
	
	public String getTenPhim() {
		return suatChieu.getPhim().getTenPhim();
	}
	
	public String getTenPhong() {
		return suatChieu.getPhong().getTenPhong();
	}

	public String getPhuDe() {
		return suatChieu.getPhude();
	}

	public String getMaVe() {
		return maVe;
	}

	public void setMaVe(String maVe) {
		this.maVe = maVe;
	}

	public SuatChieu getSuatChieu() {
		return suatChieu;
	}

	public void setSuatChieu(SuatChieu suatChieu) {
		this.suatChieu = suatChieu;
	}

	public String getThoiGian() {
		return this.suatChieu.getThoigian();
	}
	
	public ArrayList<Ghe> getListGhe() {
		return listGhe;
	}

	public void setListGhe(ArrayList<Ghe> listGhe) {
		this.listGhe = listGhe;
	}

	public HashMap<LoaiKhachHang, Integer> getSoLuongVe() {
		return soLuongVe;
	}

	public void setSoLuongVe(HashMap<LoaiKhachHang, Integer> soLuongVe) {
		this.soLuongVe = soLuongVe;
	}
	
	
}
