package storage;

import java.util.ArrayList;
import java.util.List;

import models.Phim;

public class StoragePhim {
	public static List<Phim> data = new ArrayList<>();
	
	static {
		Phim phim = Phim.builder()
				.tenPhim("MAI")
				.daoDien("Tran Thanh")
				.dienVien("Phuong Anh Dao, Tuan Tran")
				.theLoai("Tam Ly, Tinh Cam")
				.thoiLuong(131)
				.quocGia("Viet Nam")
				.ngayKhoiChieu("01/01/2024")
				.doTuoi(18)
				.moTa("Mai xoay quanh cuộc đời của một người phụ nữ đẹp tên Mai (do Phương Anh Đào thủ vai) có số phận rất đặc biệt. Bởi làm nghề mát xa, Mai thường phải đối mặt với ánh nhìn soi mói, phán xét từ những người xung quanh. Và rồi Mai gặp Dương (Tuấn Trần) - chàng trai đào hoa lãng tử. Những tưởng bản thân không còn thiết tha yêu đương và mưu cầu hạnh phúc cho riêng mình thì khao khát được sống một cuộc đời mới trong Mai trỗi dậy khi Dương tấn công cô không khoan nhượng.")
				.hinhAnh("resource/images/mai.jpg").build();
		data.add(phim);
		
		phim = Phim.builder()
				.tenPhim("VÂY HÃM: KẺ TRỪNG PHẠT")
				.daoDien("Heo Myeong Haeng")
				.dienVien("Ma Dong Seok, Kim Min Jae")
				.theLoai("Hanh Dong")
				.thoiLuong(109)
				.quocGia("Han Quoc")
				.ngayKhoiChieu("26/04/2024")
				.doTuoi(18)
				.moTa("Thám tử Ma Seok-do gia nhập Đội điều tra mạng để truy bắt Baek Chang-ki, một cựu lính đánh thuê và là người đứng đầu một tổ chức cờ bạc trực tuyến.")
				.hinhAnh("resource/images/vayham.jpg").build();
		data.add(phim);
		
		phim = Phim.builder()
				.tenPhim("LẬT MẶT 7: MỘT ĐIỀU ƯỚC")
				.daoDien("Lý Hải")
				.dienVien("Thái Vũ, Trương Minh Cường, Tín Nguyễn")
				.theLoai("Tam Ly")
				.thoiLuong(138)
				.quocGia("Viet Nam")
				.ngayKhoiChieu("26/04/2024")
				.doTuoi(13)
				.moTa("Bộ phim chữa lành lấy cảm hứng từ những câu chuyện thường nhật trong đời sống gia đình. Câu chuyện xoay quanh một người mẹ và những đứa con với tựa Một Điều Ước")
				.hinhAnh("resource/images/latmat7.jpg").build();
		data.add(phim);
		
		phim = Phim.builder()
				.tenPhim("HÀNH TINH KHỈ: VƯƠNG QUỐC MỚI")
				.daoDien("Wes Ball")
				.dienVien("Kevin Durand, Freya Allan")
				.theLoai("Hanh Dong, Vien Tuong")
				.thoiLuong(144 )
				.quocGia("Hoa Ky")
				.ngayKhoiChieu("10/05/2024")
				.doTuoi(13)
				.moTa("Nhiều năm sau triều đại của Caesar, một chú vượn trẻ bắt đầu cuộc hành trình khiến cậu đặt câu hỏi về tất cả những gì cậu đã được dạy về quá khứ và đưa ra những lựa chọn sẽ xác định tương lai cho loài vượn cũng như con người.")
				.hinhAnh("resource/images/hanhtinhkhi.jpg").build();
		data.add(phim);
	}

}
