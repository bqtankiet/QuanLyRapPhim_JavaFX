package storage;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.ObservableList;
import models.PhongChieu;
import models.Rap;
import models.enums.LoaiPhong;
import models.tableViewItem.RapItem;

public class StorageRap {
	public static List<Rap> data = new ArrayList<>();
	
	static {
		Rap rap;
		rap = new Rap("CGV Thu Duc", "Tầng 5, Vincom Thủ Đức, 216 Võ Văn Ngân, Phường Bình Thọ, Quận Thủ Đức");
		rap.themPhongChieu(new PhongChieu("Phong 01", LoaiPhong.PHONG_2D, 8, 12));
		rap.themPhongChieu(new PhongChieu("Phong 02", LoaiPhong.PHONG_2D, 8, 12));
		data.add(rap);
		
		rap = new Rap("CGV Bien Hoa", "Tầng 3, Khu Siêu thị Co-op Mart 121 Phạm Văn Thuận, P.Tân Tiến Tp. Biên Hoà Tỉnh Đồng Nai.");
		rap.themPhongChieu(new PhongChieu("Phong 01", LoaiPhong.PHONG_2D, 10, 15));
		rap.themPhongChieu(new PhongChieu("Phong 02", LoaiPhong.PHONG_3D, 8, 12));
		data.add(rap);
	}
	
	public static List<Rap> getAll() {
		return data;
	}
	
	public static void add(Rap rap) {
		data.add(rap);
	}
	
	public static void remove(Rap rap) {
		data.remove(rap);
	}
	
	public static void setAllFromObserableList(ObservableList<RapItem> list) {
		data.clear();
		for (RapItem rapitem : list) {
			data.add(rapitem.getRap());
		}
	}
}
