package models;

import static models.enums.LoaiPhuThu.PHUTHU_GHECOUPLE;
import static models.enums.LoaiPhuThu.PHUTHU_GHEVIP;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import models.enums.LoaiKhachHang;
import models.factoryPattern.VeXemPhimFactory;
import models.factoryPattern.VeXemPhimFactoryImpl;
import storage.StorageSuatChieu;
import utils.Helper;

public class DatVe {

//	private VeXemPhim veXemPhim;
	private LichChieu bookingLichChieu;
	private Phim bookingPhim;
	private SuatChieu bookingSuatChieu;
	private List<Ghe> bookingGhe;
	private LoaiKhachHang loaiKhachHang;
	private int slVe;
	private final VeXemPhimFactory veXemPhimFactory = new VeXemPhimFactoryImpl();

	public DatVe(LichChieu lichChieu, Phim bookingPhim) {
		this.bookingPhim = bookingPhim;
		this.bookingLichChieu = lichChieu;
		bookingGhe = new ArrayList<Ghe>();
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

	public VeXemPhim createVeXemPhim() {
		return veXemPhimFactory.createVeXemPhim(this);
	}
	
	public void chonGhe(Ghe ghe) {
		if (bookingGhe == null) {
			bookingGhe = new ArrayList<Ghe>();
		}
		bookingGhe.add(ghe);
	}

	public void boChonGhe(Ghe ghe) {
		bookingGhe.remove(ghe);
	}

	public SuatChieu getBookingSuatChieu() {
		return bookingSuatChieu;
	}

	public void setBookingSuatChieu(SuatChieu bookingSuatChieu) {
		this.bookingSuatChieu = bookingSuatChieu;
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

	public int getSlVe() {
		return slVe;
	}

	public void setSlVe(int slVe) {
		this.slVe = slVe;
	}

	public int getCurrentTotalPrice() {
		int total = 0;
		for (Ghe ghe : bookingGhe) {
			String ngayChieu = getBookingLichChieu().getNgaychieu();
			boolean isWeekend = Helper.isWeekend(ngayChieu);
			int price = switch (ghe.getLoaiGhe()) {
			case THUONG -> Helper.getGiaVe(loaiKhachHang, isWeekend);
			case VIP -> Helper.getGiaVe(loaiKhachHang, PHUTHU_GHEVIP, isWeekend);
			case COUPLE -> Helper.getGiaVe(loaiKhachHang, PHUTHU_GHECOUPLE, isWeekend);
			default -> 0;
			};
			total += price;
		}
		return total;
	}
	
	@Override
	public String toString() {
	    return "Booking Information:\n" +
	            "Booking LichChieu: " + bookingLichChieu + "\n" +
	            "Booking Phim: " + bookingPhim + "\n" +
	            "Booking SuatChieu: " + bookingSuatChieu + "\n" +
	            "Booking Ghe: " + bookingGhe + "\n" +
	            "Loai KhachHang: " + loaiKhachHang + "\n" +
	            "So luong Ve: " + slVe;
	}

}
