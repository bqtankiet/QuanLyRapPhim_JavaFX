package models.factoryPattern;

import java.util.UUID;

import models.DatVe;
import models.VeXemPhim;

public class VeXemPhimFactoryImpl implements VeXemPhimFactory {

	@Override
	public VeXemPhim createVeXemPhim(DatVe datVe) {
		VeXemPhim veXemPhim = new VeXemPhim();
		veXemPhim.setMaVe(generateMaVe());
		veXemPhim.setSuatChieu(datVe.getBookingSuatChieu());
		veXemPhim.setLoaiKhachHang(datVe.getLoaiKhachHang());
		veXemPhim.setTongTien(datVe.getCurrentTotalPrice());
		veXemPhim.setBookingGhe(datVe.getBookingGhe());
		return veXemPhim;
	}
	
	private String generateMaVe() {
		return UUID.randomUUID().toString();
	}

}
