package utils;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import models.GiaPhuThu;
import models.GiaVe;
import models.enums.LoaiKhachHang;
import models.enums.LoaiPhuThu;
import storage.StorageGiaPhuThu;
import storage.StorageGiaVe;

public class Helper {
	
	public static boolean isWeekend(String dateString) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = dateFormat.parse(dateString);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);

            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

            return (dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY);
        } catch (ParseException e) {
            System.out.println("Định dạng ngày không hợp lệ.");
            return false;
        }
    }
	
	public static int getGiaVe(LoaiKhachHang khachHang, LoaiPhuThu phuThu, boolean isWeekend) {
		GiaVe giaVe = StorageGiaVe.data.get(khachHang);
		GiaPhuThu giaPhuThu = StorageGiaPhuThu.data.get(phuThu);
		if(isWeekend) {
			return giaVe.getGiaVeCuoiTuan() + giaPhuThu.getGiaPhuThu();
		} else {
			return giaVe.getGiaVeNgayThuong() + giaPhuThu.getGiaPhuThu();
		}
	}
	
	public static int getGiaVe(LoaiKhachHang khachHang, boolean isWeekend) {
		GiaVe giaVe = StorageGiaVe.data.get(khachHang);
		if(isWeekend) {
			return giaVe.getGiaVeCuoiTuan();
		} else {
			return giaVe.getGiaVeNgayThuong();
		}
	}
	
	public static String formatNumber(int number) {
		DecimalFormat decimalFormat = new DecimalFormat("#,###");
		return decimalFormat.format(number);
	}
}
