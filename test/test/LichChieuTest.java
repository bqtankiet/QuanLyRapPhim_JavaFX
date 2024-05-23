package test;

import models.LichChieu;
import models.Phim;
import models.PhongChieu;
import models.Rap;
import models.SuatChieu;
import storage.StorageLichChieu;
import storage.StoragePhim;
import storage.StorageRap;

public class LichChieuTest {

	public static void main(String[] args) {
//		Phim phim1 = StoragePhim.data.get(0);
//		Rap rap = StorageRap.data.get(0);
//		PhongChieu phong = rap.getDsPhongChieu().get(0);
//		
//		SuatChieu suatChieu1 = new SuatChieu("17:00", phim1, "Tieng Viet", "Available");
//		SuatChieu suatChieu2 = new SuatChieu("18:00", phim1, "Tieng Viet", "Available");
//		
//		LichChieu lichChieu = new LichChieu(rap, phong, "01/01/2024");
//		lichChieu.themSuatChieu(suatChieu1);
//		lichChieu.themSuatChieu(suatChieu2);
//		
//		LichChieu lichChieu2 = new LichChieu(rap, phong, "01/01/2024");
//		System.out.println(lichChieu.equals(lichChieu2));
//		
//		System.out.println(StorageLichChieu.data);
		
		Rap rap1 = StorageRap.data.get(0);
		PhongChieu phong1_rap1 = rap1.getDsPhongChieu().get(0);

		LichChieu lichChieu1 = new LichChieu(rap1, phong1_rap1, "01/06/2024");

		System.out.println(StorageLichChieu.getLichChieu(lichChieu1));

	}
	
}
