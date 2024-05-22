package test;

import models.PhongChieu;
import models.Rap;
import models.enums.LoaiPhong;

public class RapTest {
	public static Rap getSampleRap() {
		Rap rap = new Rap("CGV Thu Duc", "Tầng 5, Vincom Thủ Đức, 216 Võ Văn Ngân, Phường Bình Thọ, Quận Thủ Đức");
		rap.themPhongChieu(new PhongChieu("Phong 01", LoaiPhong.PHONG_2D, 12, 8));
		rap.themPhongChieu(new PhongChieu("Phong 02", LoaiPhong.PHONG_2D, 12, 8));
		return rap;
	}
	
	public static void main(String[] args) {
		
		Rap rap1 = new Rap("CGV Thu Duc", "Tầng 5, Vincom Thủ Đức, 216 Võ Văn Ngân, Phường Bình Thọ, Quận Thủ Đức");
		rap1.themPhongChieu(new PhongChieu("Phong 01", LoaiPhong.PHONG_2D, 12, 8));
		rap1.themPhongChieu(new PhongChieu("Phong 02", LoaiPhong.PHONG_2D, 12, 8));
		
		Rap rap2 = new Rap("CGV Thu Duc", "Tầng 5, Vincom Thủ Đức, 216 Võ Văn Ngân, Phường Bình Thọ, Quận Thủ Đức");
		rap2.themPhongChieu(new PhongChieu("Phong 01", LoaiPhong.PHONG_2D, 12, 8));
		rap2.themPhongChieu(new PhongChieu("Phong 02", LoaiPhong.PHONG_2D, 12, 8));

//		System.out.println(rap1.equals(rap2));
		System.out.println(rap1.createRapItem().equals(rap2.createRapItem()));
		

	}
	
}
