package models;

import javafx.beans.property.SimpleStringProperty;

public class RapItem {

	private SimpleStringProperty tenRap;
	private SimpleStringProperty diaChi;

	public RapItem(Rap rap) {
		this.tenRap = new SimpleStringProperty(rap.getTenRap());
		this.diaChi = new SimpleStringProperty(rap.getDiaChi());
	}

	public String getTenRap() {
		return tenRap.get();
	}

	public String getDiaChi() {
		return diaChi.get();
	}

}
