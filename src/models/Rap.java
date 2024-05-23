package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import models.tableViewItem.RapItem;

public class Rap {
	private String tenRap;
	private String diaChi;
	private List<PhongChieu> dsPhongChieu;

	public Rap(String tenRap, String diaChi) {
		super();
		this.tenRap = tenRap;
		this.diaChi = diaChi;
		this.dsPhongChieu = new ArrayList<>();
	}

	// ###### GETTER, SETTER ##########

	public List<PhongChieu> getDsPhongChieu() {
		return dsPhongChieu;
	}

	public void setDsPhongChieu(List<PhongChieu> dsPhongChieu) {
		this.dsPhongChieu = dsPhongChieu;
	}

	public String getTenRap() {
		return tenRap;
	}

	public void setTenRap(String tenRap) {
		this.tenRap = tenRap;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	// ###### END GETTER, SETTER ##########

	public RapItem createRapItem() {
		return new RapItem(this);
	}

	public void themPhongChieu(PhongChieu phongChieu) {
		dsPhongChieu.add(phongChieu);
	}

	public int getSoPhong() {
		return this.dsPhongChieu.size();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Rap rap = (Rap) o;
		return Objects.equals(tenRap, rap.tenRap) && Objects.equals(diaChi, rap.diaChi)
				&& Objects.equals(dsPhongChieu, rap.dsPhongChieu);
	}

	public String toString(int indentLevel) {
        String indent = " ".repeat(indentLevel);
        StringBuilder dsPhongChieuStr = new StringBuilder();
        for (PhongChieu phong : dsPhongChieu) {
            dsPhongChieuStr.append(phong.toString(indentLevel + 2)).append(",\n");
        }

        return new StringBuilder()
            .append(indent).append("Rap {\n")
            .append(indent).append("  tenRap: '").append(tenRap).append("',\n")
            .append(indent).append("  diaChi: '").append(diaChi).append("',\n")
            .append(indent).append("  dsPhongChieu: [\n").append(dsPhongChieuStr).append(indent).append("  ]\n")
            .append(indent).append("}")
            .toString();
    }

    @Override
    public String toString() {
        return toString(0);
    }

}
