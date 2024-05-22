package models.tableViewItem;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import models.Rap;

public class RapItem {
	
	private Rap rap;
	private SimpleStringProperty tenRap;
	private SimpleStringProperty diaChi;
	private SimpleIntegerProperty soPhong;

	public RapItem(Rap rap) {
		this.rap = rap;
		this.tenRap = new SimpleStringProperty(rap.getTenRap());
		this.diaChi = new SimpleStringProperty(rap.getDiaChi());
		this.soPhong = new SimpleIntegerProperty(rap.getSoPhong());
	}

	public String getTenRap() {
		return tenRap.get();
	}

	public String getDiaChi() {
		return diaChi.get();
	}

	public Integer getSoPhong() {
		return soPhong.get();
	}
	
	public Rap getRap() {
		return rap;
	}
}
