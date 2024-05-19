package models;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;

public class RapItem {

	private SimpleStringProperty tenRap;
	private SimpleStringProperty diaChi;
	private Button deleteBtn;
	private Button editBtn;
	
	public RapItem(Rap rap) {
		this.tenRap = new SimpleStringProperty(rap.getTenRap());
		this.diaChi = new SimpleStringProperty(rap.getDiaChi());
		this.deleteBtn = new Button("Delete");
		this.editBtn = new Button("Edit");
	}

	public String getTenRap() {
		return tenRap.get();
	}

	public String getDiaChi() {
		return diaChi.get();
	}

	public Button getDeleteBtn() {
		return deleteBtn;
	}

	public Button getEditBtn() {
		return editBtn;
	}
	
	
}
