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
		
		Rap rap = new Rap("CGV Thu Duc", "Tầng 5, Vincom Thủ Đức, 216 Võ Văn Ngân, Phường Bình Thọ, Quận Thủ Đức");
		rap.themPhongChieu(new PhongChieu("Phong 01", LoaiPhong.PHONG_2D, 12, 8));
		rap.themPhongChieu(new PhongChieu("Phong 02", LoaiPhong.PHONG_2D, 12, 8));
		
	}
	
}
