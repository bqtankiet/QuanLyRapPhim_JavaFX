package test;

import static models.enums.LoaiKhachHang.ADULT;
import static models.enums.LoaiKhachHang.CHILDREN;
import static models.enums.LoaiKhachHang.MEMBER;
import static models.enums.LoaiKhachHang.STUDENT;

import models.GiaVe;
import models.enums.LoaiKhachHang;
import storage.StorageGiaVe;

public class GiaVeTest {

	public static void main(String[] args) {
		
		GiaVe studentPrice = new GiaVe(STUDENT, 70000, 80000);
		GiaVe adultPrice = new GiaVe(ADULT, 80000, 90000);
		GiaVe childrenPrice = new GiaVe(CHILDREN, 60000, 70000);
		GiaVe memberPrice = new GiaVe(MEMBER, 70000, 80000);
		
//		System.out.println(studentPrice);
//		System.out.println(adultPrice);
//		System.out.println(childrenPrice);
//		System.out.println(memberPrice);
		
		for (LoaiKhachHang lkh : StorageGiaVe.data.keySet()) {
			System.out.println(StorageGiaVe.data.get(lkh));
		}
	}
	
}
