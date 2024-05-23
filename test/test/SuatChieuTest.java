package test;

import models.Phim;
import models.SuatChieu;
import storage.StoragePhim;

public class SuatChieuTest {

	public static void main(String[] args) {

		Phim phim = StoragePhim.data.get(0);
		SuatChieu suatChieu = new SuatChieu("17/02/2024", phim, "Tieng Viet", "Available");

		System.out.println(suatChieu);
	}

}
