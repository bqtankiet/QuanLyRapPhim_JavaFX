package models;

import java.util.HashSet;
import java.util.Objects;

public class SuatChieu {

    private String thoigian;
    private Phim phim;
    private String phude;
    private String trangthai;
    private PhongChieu phong;
    private LichChieu lichChieu;
    private HashSet<Ghe> dsGheDaDat;

    public SuatChieu(String thoigian, Phim phim, String phude, String trangthai) {
        this.thoigian = thoigian;
        this.phim = phim;
        this.phude = phude;
        this.trangthai = trangthai;
        dsGheDaDat = new HashSet<Ghe>();
    }
    // Getters

    public Phim getPhim() {
		return phim;
	}


	public void setPhim(Phim phim) {
		this.phim = phim;
	}


	public String getPhude() {
		return phude;
	}


	public void setPhude(String phude) {
		this.phude = phude;
	}


	public String getTrangthai() {
		return trangthai;
	}


	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}


	public PhongChieu getPhong() {
		return phong;
	}


	public void setPhong(PhongChieu phong) {
		this.phong = phong;
	}


	public LichChieu getLichChieu() {
		return lichChieu;
	}


	public void setLichChieu(LichChieu lichChieu) {
		this.lichChieu = lichChieu;
	}


	public HashSet<Ghe> getDsGheDaDat() {
		return dsGheDaDat;
	}


	public void setDsGheDaDat(HashSet<Ghe> dsGheDaDat) {
		this.dsGheDaDat = dsGheDaDat;
	}


	public String getThoigian() {
		return thoigian;
	}


	public void setThoigian(String thoigian) {
		this.thoigian = thoigian;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SuatChieu suatChieu = (SuatChieu) o;
        return Objects.equals(thoigian, suatChieu.thoigian) &&
                Objects.equals(phim, suatChieu.phim) &&
                Objects.equals(phude, suatChieu.phude) &&
                Objects.equals(trangthai, suatChieu.trangthai) &&
                Objects.equals(phong, suatChieu.phong) &&
                Objects.equals(lichChieu, suatChieu.lichChieu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(thoigian, phim, phude, trangthai, phong, lichChieu);
    }
    
    public String toString(int indentLevel) {
        String indent = " ".repeat(indentLevel);
//        StringBuilder dsGheDaDatStr = new StringBuilder();
//        for (Ghe ghe : dsGheDaDat) {
//            dsGheDaDatStr.append(ghe.toString()).append(",\n");
//        }

        return indent + "SuatChieu {\n" +
               indent + "  ThoiGian: '" + thoigian + "',\n" +
               indent + "  Phim: \n" + (phim != null ? phim.toString(indentLevel + 2) : indent + "  null") + ",\n" +
               indent + "  PhuDe: '" + phude + "',\n" +
               indent + "  TrangThai: '" + trangthai + "',\n" +
               indent + "  Phong: \n" + (phong != null ? phong.toString(indentLevel + 2) : indent + "  null") + ",\n" +
               indent + "  LichChieu: \n" + (lichChieu != null ? lichChieu.toString(indentLevel + 2) : indent + "  null") + ",\n" +
               indent + "  dsGheDaDat: [" + dsGheDaDat.toString() + indent + "  ]\n" +
               indent + "}";
    }

    @Override
    public String toString() {
        return toString(0);
    }

    public boolean themGheDaDat(Ghe ghe) {
    	if(dsGheDaDat.add(ghe)) {
    		return true;
    	}
    	return false;
    }
    
    public int getSoGheConTrong() {
    	return this.phong.getSoLuongGhe() - this.dsGheDaDat.size();
    }
}

