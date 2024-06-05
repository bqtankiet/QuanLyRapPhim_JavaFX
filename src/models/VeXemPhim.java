package models;

import java.util.List;

import models.enums.LoaiKhachHang;

public class VeXemPhim {
	private String maVe;
	private SuatChieu suatChieu;
	private List<Ghe> bookingGhe;
	private LoaiKhachHang loaiKhachHang;
	private int tongTien;

	public VeXemPhim() {
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

	public List<Ghe> getBookingGhe() {
		return bookingGhe;
	}

	public void setBookingGhe(List<Ghe> bookingGhe) {
		this.bookingGhe = bookingGhe;
	}

	public LoaiKhachHang getLoaiKhachHang() {
		return loaiKhachHang;
	}

	public void setLoaiKhachHang(LoaiKhachHang loaiKhachHang) {
		this.loaiKhachHang = loaiKhachHang;
	}

	public int getTongTien() {
		return tongTien;
	}

	public void setTongTien(int tongTien) {
		this.tongTien = tongTien;
	}

	@Override
	public String toString() {
	    return "VeXemPhim Information:\n" +
	            "Ma Ve: " + maVe + "\n" +
	            "Suat Chieu: " + suatChieu + "\n" +
	            "Booking Ghe: " + bookingGhe + "\n" +
	            "Loai KhachHang: " + loaiKhachHang + "\n" +
	            "Tong Tien: " + tongTien;
	}

	
}
