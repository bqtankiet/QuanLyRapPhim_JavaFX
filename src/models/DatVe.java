package models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import models.enums.LoaiKhachHang;
import storage.StorageSuatChieu;

public class DatVe {

	private VeXemPhim veXemPhim;
	private Phim bookingPhim;
	private LichChieu bookingLichChieu;
	private List<Ghe> listGheDangChon;

	public DatVe(LichChieu lichChieu, Phim bookingPhim) {
		this.bookingPhim = bookingPhim;
		this.bookingLichChieu = lichChieu;
		this.veXemPhim = new VeXemPhim(null);
		listGheDangChon = new ArrayList<Ghe>();
	}

	public List<SuatChieu> getAvailabeSuatChieu() {
		HashSet<SuatChieu> setSC = StorageSuatChieu.data.get(bookingLichChieu);
		if (setSC == null)
			return null;
		// java 8 Stream API
		List<SuatChieu> availableSuatChieu = setSC.stream().filter(sc -> sc.getPhim().equals(bookingPhim))
				.sorted(Comparator.comparing(SuatChieu::getThoigian)).collect(Collectors.toList());

		return availableSuatChieu;
	}
	
	public void chonGhe(Ghe ghe) {
		if(listGheDangChon == null) {
			listGheDangChon = new ArrayList<Ghe>();
		}
		listGheDangChon.add(ghe);
	}
	
	public void boChonGhe(Ghe ghe) {
		listGheDangChon.remove(ghe);
	}

	public VeXemPhim getVeXemPhim() {
		return veXemPhim;
	}

	public void setVeXemPhim(VeXemPhim veXemPhim) {
		this.veXemPhim = veXemPhim;
	}

	public Phim getBookingPhim() {
		return bookingPhim;
	}

	public void setBookingPhim(Phim bookingPhim) {
		this.bookingPhim = bookingPhim;
	}

	public LichChieu getBookingLichChieu() {
		return bookingLichChieu;
	}

	public void setBookingLichChieu(LichChieu bookingLichChieu) {
		this.bookingLichChieu = bookingLichChieu;
	}

	public void setSuatChieu(SuatChieu suatChieu) {
		this.veXemPhim.setSuatChieu(suatChieu);
	}
	
	public void setSoLuongVe(LoaiKhachHang khachHang, int soLuongVe) {
		veXemPhim.setSoLuongVe(khachHang, soLuongVe);
	}

	public List<Ghe> getListGheDangChon() {
		return listGheDangChon;
	}

	public void setListGheDangChon(List<Ghe> listGheDangChon) {
		this.listGheDangChon = listGheDangChon;
	}
	
	

}
