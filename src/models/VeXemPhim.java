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
		soLuongVe = new HashMap<LoaiKhachHang, Integer>();
	}

	public String getThoiGianChieu() {
		if(suatChieu == null) return "";
		String result = suatChieu.getThoigian();
		return result == null ? "" : result;
	}

	public String getTenPhim() {
		if(suatChieu == null) return "";
		String result = suatChieu.getPhim().getTenPhim();
		return result == null ? "" : result;
	}

	public String getTenPhong() {
		if(suatChieu == null) return "";
		String result = suatChieu.getPhong().getTenPhong();
		return result == null ? "" : result;
	}

	public String getPhuDe() {
		if(suatChieu == null) return "";
		String result = suatChieu.getPhude();
		return result == null ? "" : result;
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
		String result = this.suatChieu.getThoigian();
		return result == null ? "" : result;
	}


	public void setListGhe(ArrayList<Ghe> listGhe) {
		this.listGhe = listGhe;
	}


	public void setSoLuongVe(LoaiKhachHang khachHang, int soLuongVe) {
		this.soLuongVe.put(khachHang, soLuongVe);
	}
	
	public int getSoLuongVe(LoaiKhachHang khachHang) {
		return soLuongVe.get(khachHang);
	}


}
