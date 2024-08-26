package storage;

import static models.enums.LoaiKhachHang.ADULT;
import static models.enums.LoaiKhachHang.CHILDREN;
import static models.enums.LoaiKhachHang.MEMBER;
import static models.enums.LoaiKhachHang.STUDENT;

import java.util.HashMap;

import models.GiaVe;
import models.enums.LoaiKhachHang;

public class StorageGiaVe {

	public static HashMap<LoaiKhachHang, GiaVe> data = new HashMap<>();

	static {
		GiaVe studentPrice = new GiaVe(STUDENT, 70000, 80000);
		GiaVe adultPrice = new GiaVe(ADULT, 80000, 90000);
		GiaVe childrenPrice = new GiaVe(CHILDREN, 60000, 70000);
		GiaVe memberPrice = new GiaVe(MEMBER, 70000, 80000);
		data.put(STUDENT, studentPrice);
		data.put(ADULT, adultPrice);
		data.put(CHILDREN, childrenPrice);
		data.put(MEMBER, memberPrice);
	}

}
