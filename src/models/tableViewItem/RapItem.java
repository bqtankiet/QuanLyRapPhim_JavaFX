package models.tableViewItem;

import java.util.Objects;

import javafx.beans.property.SimpleStringProperty;
import models.PhongChieu;
import models.Rap;

public class RapItem {
	
	private Rap rap;
	public SimpleStringProperty tenRap;
	public SimpleStringProperty diaChi;
	public SimpleStringProperty soPhong;

	public RapItem(Rap rap) {
		this.rap = rap;
		this.tenRap = new SimpleStringProperty(rap.getTenRap());
		this.diaChi = new SimpleStringProperty(rap.getDiaChi());
		this.soPhong = new SimpleStringProperty(rap.getSLPhong()+"");
	}

	public void themPhongChieu(PhongChieu phongChieu) {
		this.rap.themPhongChieu(phongChieu);
		this.soPhong.setValue(rap.getSLPhong()+"");
	}
	
	public Rap getRap() {
		return rap;
	}

	public SimpleStringProperty getTenRap() {
		return tenRap;
	}

	public SimpleStringProperty getDiaChi() {
		return diaChi;
	}

	public SimpleStringProperty getSoPhong() {
		return soPhong;
	}

	public void setRap(Rap rap) {
		this.rap = rap;
	}

	public void setTenRap(SimpleStringProperty tenRap) {
		this.tenRap = tenRap;
		rap.setTenRap(tenRap.get());
	}

	public void setDiaChi(SimpleStringProperty diaChi) {
		this.diaChi = diaChi;
		rap.setDiaChi(diaChi.get());
	}

	public void setSoPhong(SimpleStringProperty soPhong) {
		this.soPhong = soPhong;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RapItem rapItem = (RapItem) o;
        return Objects.equals(rap, rapItem.rap) &&
                Objects.equals(tenRap.get(), rapItem.tenRap.get()) &&
                Objects.equals(diaChi.get(), rapItem.diaChi.get()) &&
                Objects.equals(soPhong.get(), rapItem.soPhong.get());
    }

	@Override
	public String toString() {
		return "RapItem [rap=" + rap + ", tenRap=" + tenRap + ", diaChi=" + diaChi + ", soPhong=" + soPhong + "]";
	}
	
}
