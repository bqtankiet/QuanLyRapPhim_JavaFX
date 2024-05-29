package storage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import models.LichChieu;
import models.Phim;
import models.PhongChieu;
import models.Rap;
import models.SuatChieu;

public class StorageLichChieu {

	public static List<LichChieu> data = new ArrayList<>();
	
	static {
		Phim phim1 = StoragePhim.data.get(0);
		Phim phim2 = StoragePhim.data.get(1);
		Phim phim3 = StoragePhim.data.get(2);
		Phim phim4 = StoragePhim.data.get(3);
		
		Rap rap1 = StorageRap.data.get(0);
		Rap rap2 = StorageRap.data.get(1);
		
		PhongChieu phong1_rap1 = rap1.getDsPhongChieu().get(0);
		PhongChieu phong2_rap1 = rap1.getDsPhongChieu().get(1);
		
		PhongChieu phong1_rap2 = rap2.getDsPhongChieu().get(0);
		PhongChieu phong2_rap2 = rap2.getDsPhongChieu().get(1);
		
		SuatChieu suatChieu1 = new SuatChieu("16:00", phim1, "Tieng Viet", "Available");
		SuatChieu suatChieu2 = new SuatChieu("18:00", phim2, "Tieng Viet", "Available");
		SuatChieu suatChieu3 = new SuatChieu("20:00", phim3, "Tieng Viet", "Available");
		SuatChieu suatChieu4 = new SuatChieu("22:00", phim4, "Tieng Viet", "Available");
		SuatChieu suatChieu5 = new SuatChieu("21:00", phim1, "Tieng Viet", "Available");

		
		LichChieu lichChieu1 = new LichChieu(rap1, phong1_rap1, "05/06/2024");
		LichChieu lichChieu2 = new LichChieu(rap1, phong2_rap1, "05/06/2024");
		lichChieu1.themSuatChieu(suatChieu1);
		lichChieu1.themSuatChieu(suatChieu3);
		lichChieu1.themSuatChieu(suatChieu4);
		lichChieu2.themSuatChieu(suatChieu2);
		lichChieu2.themSuatChieu(suatChieu5);
		lichChieu2.themSuatChieu(suatChieu1);
		
		data.add(lichChieu1);
		data.add(lichChieu2);
	}
	
	public static LichChieu getLichChieu(LichChieu lichChieu) {
		for (LichChieu lc : data) {
			if(lc.equals(lichChieu)) {
				return lc;
			}
		}
		return null;
	}
	
	public static void themLichChieu(LichChieu lichChieu) {
		for (LichChieu lc : data) {
			if(lc.equals(lichChieu)) {
				for (SuatChieu sc : lichChieu.getDsSuatChieu()) {
					lc.themSuatChieu(sc);
				}
			}
		}
		data.add(lichChieu);
	}
}
