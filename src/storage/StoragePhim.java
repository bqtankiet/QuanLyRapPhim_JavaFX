package storage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import models.Phim;

public class StoragePhim {

	static {
		byte[] bytes = null;
		try {
			Path path = Paths.get("resource/images/mai.jpg");
			bytes = Files.readAllBytes(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Phim phim = Phim.builder()
				.tenPhim("Mai")
				.daoDien("Tran Thanh")
				.dienVien("Phuong Anh Dao, Tuan Tran")
				.theLoai("Tam Ly, Tinh Cam")
				.thoiLuong(131)
				.quocGia("Viet Nam")
				.ngayKhoiChieu("01/01/2024")
				.doTuoi(18)
				.moTa("Mai xoay quanh cuộc đời của một người phụ nữ đẹp tên Mai (do Phương Anh Đào thủ vai) có số phận rất đặc biệt. Bởi làm nghề mát xa, Mai thường phải đối mặt với ánh nhìn soi mói, phán xét từ những người xung quanh. Và rồi Mai gặp Dương (Tuấn Trần) - chàng trai đào hoa lãng tử. Những tưởng bản thân không còn thiết tha yêu đương và mưu cầu hạnh phúc cho riêng mình thì khao khát được sống một cuộc đời mới trong Mai trỗi dậy khi Dương tấn công cô không khoan nhượng.")
				.hinhAnh(bytes).build();
	}

}
