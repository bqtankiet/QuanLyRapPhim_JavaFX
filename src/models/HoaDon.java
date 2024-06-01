package models;

public class HoaDon {
	
	private String maHoaDon;
	private VeXemPhim veXemPhim;
	private String hinhThucThanhToan;
	private String ngayThanhToan;

	public HoaDon(VeXemPhim veXemPhim) {
		super();
		this.veXemPhim = veXemPhim;
		this.maHoaDon = veXemPhim.getMaVe();
	}

	public VeXemPhim getVeXemPhim() {
		return veXemPhim;
	}

	public String getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public void setVeXemPhim(VeXemPhim veXemPhim) {
		this.veXemPhim = veXemPhim;
	}

	public String getHinhThucThanhToan() {
		return hinhThucThanhToan;
	}

	public void setHinhThucThanhToan(String hinhThucThanhToan) {
		this.hinhThucThanhToan = hinhThucThanhToan;
	}

	public String getNgayThanhToan() {
		return ngayThanhToan;
	}

	public void setNgayThanhToan(String ngayThanhToan) {
		this.ngayThanhToan = ngayThanhToan;
	}
	
	public int getTotalPrice() {
		return veXemPhim.getTongTien();
	}
	
}
