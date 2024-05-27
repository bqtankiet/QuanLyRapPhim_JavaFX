package models;

import models.enums.LoaiKhachHang;

public class GiaVe {
	private LoaiKhachHang loaiKhachHang;
	private int giaVeNgayThuong;
	private int giaVeCuoiTuan;

	public GiaVe(LoaiKhachHang loaiKhachHang, int giaVeNgayThuong, int giaVeCuoiTuan) {
		super();
		this.loaiKhachHang = loaiKhachHang;
		this.giaVeNgayThuong = giaVeNgayThuong;
		this.giaVeCuoiTuan = giaVeCuoiTuan;
	}

	public int getGiaVeNgayThuong() {
		return giaVeNgayThuong;
	}

	public void setGiaVeNgayThuong(int giaVeNgayThuong) {
		this.giaVeNgayThuong = giaVeNgayThuong;
	}

	public int getGiaVeCuoiTuan() {
		return giaVeCuoiTuan;
	}

	public void setGiaVeCuoiTuan(int giaVeCuoiTuan) {
		this.giaVeCuoiTuan = giaVeCuoiTuan;
	}

	public void setLoaiKhachHang(LoaiKhachHang loaiKhachHang) {
		this.loaiKhachHang = loaiKhachHang;
	}

	public LoaiKhachHang getLoaiKhachHang() {
		return this.loaiKhachHang;
	}
	
	public String toString(int indentLevel) {
        String indent = " ".repeat(indentLevel);
        return indent + "GiaVe {\n" +
               indent + "  loaiKhachHang: " + loaiKhachHang + ",\n" +
               indent + "  giaVeNgayThuong: " + giaVeNgayThuong + ",\n" +
               indent + "  giaVeCuoiTuan: " + giaVeCuoiTuan + "\n" +
               indent + "}";
    }

    @Override
    public String toString() {
        return toString(0);
    }
	
}
