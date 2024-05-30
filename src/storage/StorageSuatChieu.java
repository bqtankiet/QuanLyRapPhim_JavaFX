package storage;

import java.util.HashMap;
import java.util.HashSet;

import models.LichChieu;
import models.Phim;
import models.PhongChieu;
import models.Rap;
import models.SuatChieu;

public class StorageSuatChieu {

	public static HashMap<LichChieu, HashSet<SuatChieu>> data = new HashMap<>();

	static {
		Phim phim1 = StoragePhim.data.get(0);
		Phim phim2 = StoragePhim.data.get(1);
		Phim phim3 = StoragePhim.data.get(2);
		Phim phim4 = StoragePhim.data.get(3);

		Rap rap1 = StorageRap.data.get(0);
		Rap rap2 = StorageRap.data.get(1);

		SuatChieu suatChieu1 = new SuatChieu("16:00", phim1, "Tieng Viet", "Available");
		SuatChieu suatChieu2 = new SuatChieu("18:00", phim1, "Tieng Viet", "Available");
		SuatChieu suatChieu3 = new SuatChieu("20:00", phim3, "Tieng Viet", "Available");
		SuatChieu suatChieu4 = new SuatChieu("22:00", phim4, "Tieng Viet", "Available");
		SuatChieu suatChieu5 = new SuatChieu("21:00", phim1, "Tieng Viet", "Available");
		SuatChieu suatChieu6 = new SuatChieu("14:00", phim2, "Tieng Viet", "Available");

		LichChieu lichChieu1 = new LichChieu(rap1, "05/06/2024");
		LichChieu lichChieu2 = new LichChieu(rap1, "06/06/2024");

		data.put(lichChieu1, new HashSet<>());
		data.put(lichChieu2, new HashSet<>());
		
		themSuatChieu(lichChieu1, suatChieu1, rap1.getDsPhongChieu().get(0));
		themSuatChieu(lichChieu1, suatChieu2, rap1.getDsPhongChieu().get(0));
		themSuatChieu(lichChieu1, suatChieu3, rap1.getDsPhongChieu().get(0));
		themSuatChieu(lichChieu1, suatChieu4, rap1.getDsPhongChieu().get(1));
		themSuatChieu(lichChieu1, suatChieu5, rap1.getDsPhongChieu().get(1));
		themSuatChieu(lichChieu1, suatChieu6, rap1.getDsPhongChieu().get(1));
	}

	public static boolean themSuatChieu(LichChieu lichChieu, SuatChieu suatChieu, PhongChieu phong) {
		HashSet<SuatChieu> setSC = data.get(lichChieu);
		if(setSC == null) {
			setSC = new HashSet<SuatChieu>();
			data.put(lichChieu, setSC);
		}
		suatChieu.setLichChieu(lichChieu);
		suatChieu.setPhong(phong);
		return setSC.add(suatChieu);
	}

	public static void main(String[] args) {
		System.out.println(data);
	}
}
