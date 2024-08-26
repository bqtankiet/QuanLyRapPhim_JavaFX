package storage;

import static models.enums.LoaiPhuThu.PHUTHU_3D;
import static models.enums.LoaiPhuThu.PHUTHU_4D;
import static models.enums.LoaiPhuThu.PHUTHU_GHECOUPLE;
import static models.enums.LoaiPhuThu.PHUTHU_GHEVIP;
import static models.enums.LoaiPhuThu.PHUTHU_IMAX;

import java.util.HashMap;

import models.GiaPhuThu;
import models.enums.LoaiPhuThu;

public class StorageGiaPhuThu {
	public static HashMap<LoaiPhuThu, GiaPhuThu> data = new HashMap<>();
	
	static {
		GiaPhuThu phuThu3D = new GiaPhuThu(PHUTHU_3D, 20000);
		GiaPhuThu phuThu4D = new GiaPhuThu(PHUTHU_4D, 40000);
		GiaPhuThu phuThuIMAX = new GiaPhuThu(PHUTHU_IMAX, 60000);
		GiaPhuThu phuThuGheVip = new GiaPhuThu(PHUTHU_GHEVIP, 20000);
		GiaPhuThu phuThuGheCouple = new GiaPhuThu(PHUTHU_GHECOUPLE, 30000);
		
		data.put(PHUTHU_3D, phuThu3D);
		data.put(PHUTHU_4D, phuThu4D);
		data.put(PHUTHU_IMAX, phuThuIMAX);
		data.put(PHUTHU_GHEVIP, phuThuGheVip);
		data.put(PHUTHU_GHECOUPLE, phuThuGheCouple);
		
	}
}
