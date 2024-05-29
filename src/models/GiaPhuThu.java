package models;

import models.enums.LoaiPhuThu;

public class GiaPhuThu {
	private LoaiPhuThu loaiPhuThu;
	private int giaPhuThu;

	public GiaPhuThu(LoaiPhuThu loaiPhuThu, int giaPhuThu) {
		super();
		this.loaiPhuThu = loaiPhuThu;
		this.giaPhuThu = giaPhuThu;
	}

	public LoaiPhuThu getLoaiPhuThu() {
		return loaiPhuThu;
	}

	public void setLoaiPhuThu(LoaiPhuThu loaiPhuThu) {
		this.loaiPhuThu = loaiPhuThu;
	}

	public int getGiaPhuThu() {
		return giaPhuThu;
	}

	public void setGiaPhuThu(int giaPhuThu) {
		this.giaPhuThu = giaPhuThu;
	}

	public String toString(int indentLevel) {
        String indent = " ".repeat(indentLevel);
        return indent + "GiaPhuThu {\n" +
               indent + "  loaiPhuThu: " + loaiPhuThu + "\n" +
               indent + "  giaPhuThu: " + giaPhuThu + "\n" +
               indent + "}";
    }

    @Override
    public String toString() {
        return toString(0);
    }
	
}
