package models;

import java.util.List;
import java.util.Objects;

import models.enums.LoaiPhong;

public class PhongChieu {

	private String tenPhong;
	private LoaiPhong loaiPhong;
	private int soHang, soDay;
	private List<Ghe> dsGhe;

	public PhongChieu(String tenPhong, LoaiPhong loaiPhong, int soHang, int soDay) {
		super();
		this.tenPhong = tenPhong;
		this.loaiPhong = loaiPhong;
		this.soHang = soHang;
		this.soDay = soDay;
	}

	// ###### GETTER, SETTER ##########
	public String getTenPhong() {
		return tenPhong;
	}

	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}

	public LoaiPhong getLoaiPhong() {
		return loaiPhong;
	}

	public void setLoaiPhong(LoaiPhong loaiPhong) {
		this.loaiPhong = loaiPhong;
	}

	public int getSoHang() {
		return soHang;
	}

	public void setSoHang(int soHang) {
		this.soHang = soHang;
	}

	public int getSoDay() {
		return soDay;
	}

	public void setSoDay(int soDay) {
		this.soDay = soDay;
	}

	public List<Ghe> getDsGhe() {
		return dsGhe;
	}

	public void setDsGhe(List<Ghe> dsGhe) {
		this.dsGhe = dsGhe;
	}

	// ###### END GETTER, SETTER ##########

	public String toString(int indentLevel) {
        String indent = " ".repeat(indentLevel);
//        return indent + "PhongChieu {\n" +
//               indent + "  tenPhong: '" + tenPhong + "',\n" +
//               indent + "  loaiPhong: '" + loaiPhong + "',\n" +
//               indent + "  soDay: " + soDay + ",\n" +
//               indent + "  soHang: " + soHang + "\n" +
//               indent + "}";
        return indent + tenPhong +", " + loaiPhong + ", " + soDay + " day, " + soHang + " hang";
    }

    @Override
    public String toString() {
        return toString(0);
    }
	
	public int getSoLuongGhe() {
		return this.soDay * this.soHang;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhongChieu that = (PhongChieu) o;
        return soHang == that.soHang &&
                soDay == that.soDay &&
                Objects.equals(tenPhong, that.tenPhong) &&
                loaiPhong == that.loaiPhong &&
                Objects.equals(dsGhe, that.dsGhe);
    }
	
	@Override
    public int hashCode() {
        return Objects.hash(tenPhong, soHang, soDay, loaiPhong, dsGhe);
    }
}
