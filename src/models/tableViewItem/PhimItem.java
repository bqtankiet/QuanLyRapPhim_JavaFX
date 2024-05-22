package models.tableViewItem;

import java.io.ByteArrayInputStream;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import models.Phim;

public class PhimItem {

		private ImageView hinhAnh;
		private SimpleStringProperty tenPhim;
		private SimpleStringProperty theLoai;
		private SimpleIntegerProperty thoiLuong;
		private SimpleStringProperty quocGia;
		private SimpleStringProperty ngayKhoiChieu;
		

		public PhimItem(Phim phim) {
			super();
			Image image = new Image(new ByteArrayInputStream(phim.getHinhAnh()));
			this.hinhAnh = new ImageView(image);
			hinhAnh.setFitWidth(100);
			hinhAnh.setFitHeight(150);
			hinhAnh.setPreserveRatio(true);
			this.tenPhim = new SimpleStringProperty(phim.getTenPhim());
			this.theLoai = new SimpleStringProperty(phim.getTheLoai());
			this.thoiLuong = new SimpleIntegerProperty(phim.getThoiLuong());
			this.quocGia = new SimpleStringProperty(phim.getQuocGia());
			this.ngayKhoiChieu = new SimpleStringProperty(phim.getNgayKhoiChieu());
		}


		public ImageView getHinhAnh() {
			return hinhAnh;
		}


		public String getTenPhim() {
			return tenPhim.get();
		}


		public String getTheLoai() {
			return theLoai.get();
		}


		public Integer getThoiLuong() {
			return thoiLuong.get();
		}


		public String getQuocGia() {
			return quocGia.get();
		}


		public String getNgayKhoiChieu() {
			return ngayKhoiChieu.get();
		}

		
	}