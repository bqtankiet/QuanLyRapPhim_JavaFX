package test;

import models.Ghe;
import models.LichChieu;
import models.Phim;
import models.Rap;
import models.SuatChieu;
import models.enums.LoaiGhe;
import storage.StoragePhim;
import storage.StorageRap;

public class SuatChieuTest {

	public static void main(String[] args) {
		Phim phim = StoragePhim.data.get(0);
		Rap rap = StorageRap.data.get(0);
		LichChieu lichChieu = new LichChieu(rap, "05/06/2024");
		
		SuatChieu sc = new SuatChieu("17:00", phim, "Tieng Viet", "Available");
		sc.setLichChieu(lichChieu);
		sc.setPhong(rap.getDsPhongChieu().get(0));
		sc.themGheDaDat(new Ghe('A', 1, LoaiGhe.THUONG));
		sc.themGheDaDat(new Ghe('A', 1, LoaiGhe.VIP));// trong ds ghe da dat van chi co 1 ghe a1
		
		System.out.println(sc);
	}

}
