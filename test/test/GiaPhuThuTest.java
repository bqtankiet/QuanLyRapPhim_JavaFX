package test;

import models.GiaPhuThu;
import static models.enums.LoaiPhuThu.*;

public class GiaPhuThuTest {
	public static void main(String[] args) {
		
		GiaPhuThu phuThu3D = new GiaPhuThu(PHUTHU_3D, 20000);
		GiaPhuThu phuThu4D = new GiaPhuThu(PHUTHU_4D, 40000);
		GiaPhuThu phuThuIMAX = new GiaPhuThu(PHUTHU_IMAX, 60000);
		GiaPhuThu phuThuGheVip = new GiaPhuThu(PHUTHU_GHEVIP, 20000);
		GiaPhuThu phuThuGheCouple = new GiaPhuThu(PHUTHU_GHECOUPLE, 30000);
		
		System.out.println(phuThu3D);
		System.out.println(phuThu4D);
		System.out.println(phuThuIMAX);
		System.out.println(phuThuGheVip);
		System.out.println(phuThuGheCouple);
		
		
		
	}
}
