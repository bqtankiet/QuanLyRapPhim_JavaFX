package database;

import java.util.LinkedList;

import javafx.collections.ObservableList;
import models.PhongChieu;
import models.Rap;
import models.enums.LoaiPhong;
import models.tableViewItem.RapItem;

public class RapList {
	public static LinkedList<Rap> listRap = new LinkedList<>();
	
	static {
		Rap rap;
		rap = new Rap("CGV Thu Duc", "Tầng 5, Vincom Thủ Đức, 216 Võ Văn Ngân, Phường Bình Thọ, Quận Thủ Đức");
		rap.themPhongChieu(new PhongChieu("Phong 01", LoaiPhong.PHONG_2D, 12, 8));
		rap.themPhongChieu(new PhongChieu("Phong 02", LoaiPhong.PHONG_2D, 12, 8));
		listRap.add(rap);
		
		rap = new Rap("CGV Bien Hoa", "Tầng 3, Khu Siêu thị Co-op Mart 121 Phạm Văn Thuận, P.Tân Tiến Tp. Biên Hoà Tỉnh Đồng Nai.");
		rap.themPhongChieu(new PhongChieu("Phong 01", LoaiPhong.PHONG_2D, 15, 10));
		rap.themPhongChieu(new PhongChieu("Phong 02", LoaiPhong.PHONG_3D, 12, 8));
		listRap.add(rap);
	}
	
	public static LinkedList<Rap> getAll() {
		return listRap;
	}
	
	public static void add(Rap rap) {
		listRap.add(rap);
	}
	
	public static void remove(Rap rap) {
		listRap.remove(rap);
	}
	
	public static void setAllFromObserableList(ObservableList<RapItem> list) {
		listRap.clear();
		for (RapItem rapitem : list) {
			listRap.add(rapitem.getRap());
		}
	}
}
