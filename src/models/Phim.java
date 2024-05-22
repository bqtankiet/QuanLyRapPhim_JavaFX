package models;

import models.tableViewItem.PhimItem;

public class Phim {

	private String tenPhim;
	private String daoDien;
	private String dienVien;
	private String theLoai;
	private int thoiLuong;
	private String quocGia;
	private String ngayKhoiChieu;
	private int doTuoi;
	private String hinhAnh;
	private String moTa;
	
	private Phim(PhimBuilder builder) {
        this.tenPhim = builder.tenPhim;
        this.daoDien = builder.daoDien;
        this.dienVien = builder.dienVien;
        this.theLoai = builder.theLoai;
        this.thoiLuong = builder.thoiLuong;
        this.quocGia = builder.quocGia;
        this.ngayKhoiChieu = builder.ngayKhoiChieu;
        this.doTuoi = builder.doTuoi;
        this.hinhAnh = builder.hinhAnh;
        this.moTa = builder.moTa;
    }
	
	public static PhimBuilder builder() {
		return new PhimBuilder();
	}
	
	public PhimItem getPhimItem() {
		return new PhimItem(this);
	}
	
	// ########## GETTER, SETTER ############
	public String getTenPhim() {
		return tenPhim;
	}
	public void setTenPhim(String tenPhim) {
		this.tenPhim = tenPhim;
	}
	public String getDaoDien() {
		return daoDien;
	}
	public void setDaoDien(String daoDien) {
		this.daoDien = daoDien;
	}
	public String getDienVien() {
		return dienVien;
	}
	public void setDienVien(String dienVien) {
		this.dienVien = dienVien;
	}
	public String getTheLoai() {
		return theLoai;
	}
	public void setTheLoai(String theLoai) {
		this.theLoai = theLoai;
	}
	public int getThoiLuong() {
		return thoiLuong;
	}
	public void setThoiLuong(int thoiLuong) {
		this.thoiLuong = thoiLuong;
	}
	public String getQuocGia() {
		return quocGia;
	}
	public void setQuocGia(String quocGia) {
		this.quocGia = quocGia;
	}
	public String getNgayKhoiChieu() {
		return ngayKhoiChieu;
	}
	public void setNgayKhoiChieu(String ngayKhoiChieu) {
		this.ngayKhoiChieu = ngayKhoiChieu;
	}
	public int getDoTuoi() {
		return doTuoi;
	}
	public void setDoTuoi(int doTuoi) {
		this.doTuoi = doTuoi;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	// ########## END GETTER, SETTER ############

	 @Override
		public String toString() {
			return "Phim [tenPhim=" + tenPhim + ", daoDien=" + daoDien + ", dienVien=" + dienVien + ", theLoai="
					+ theLoai + ", thoiLuong=" + thoiLuong + ", quocGia=" + quocGia + ", ngayKhoiChieu=" + ngayKhoiChieu
					+ ", doTuoi=" + doTuoi + ", hinhAnh=" + hinhAnh + ", moTa=" + moTa + "]";
		}
	
	 // PhimBuilder class
    public static class PhimBuilder {
		private String tenPhim;
        private String daoDien;
        private String dienVien;
        private String theLoai;
        private int thoiLuong;
        private String quocGia;
        private String ngayKhoiChieu;
        private int doTuoi;
        private String hinhAnh;
        private String moTa;

        public PhimBuilder tenPhim(String tenPhim) {
            this.tenPhim = tenPhim;
            return this;
        }

        public PhimBuilder daoDien(String daoDien) {
            this.daoDien = daoDien;
            return this;
        }

        public PhimBuilder dienVien(String dienVien) {
            this.dienVien = dienVien;
            return this;
        }

        public PhimBuilder theLoai(String theLoai) {
            this.theLoai = theLoai;
            return this;
        }

        public PhimBuilder thoiLuong(int thoiLuong) {
            this.thoiLuong = thoiLuong;
            return this;
        }

        public PhimBuilder quocGia(String quocGia) {
            this.quocGia = quocGia;
            return this;
        }

        public PhimBuilder ngayKhoiChieu(String ngayKhoiChieu) {
            this.ngayKhoiChieu = ngayKhoiChieu;
            return this;
        }

        public PhimBuilder doTuoi(int doTuoi) {
            this.doTuoi = doTuoi;
            return this;
        }

        public PhimBuilder hinhAnh(String hinhAnh) {
            this.hinhAnh = hinhAnh;
            return this;
        }

        public PhimBuilder moTa(String moTa) {
            this.moTa = moTa;
            return this;
        }

        public Phim build() {
            return new Phim(this);
        }
    }
	
}
