package models;

public class SuatChieu {

    private String thoigian;
    private Phim phim;
    private String phude;
    private String trangthai;
    private PhongChieu phong;

    public SuatChieu(String thoigian, Phim phim, String phude, String trangthai, PhongChieu phong) {
        this.thoigian = thoigian;
        this.phim = phim;
        this.phude = phude;
        this.trangthai = trangthai;
        this.phong = phong;
    }

    public SuatChieu(String thoigian, Phim phim, String phude, String trangthai) {
        this.thoigian = thoigian;
        this.phim = phim;
        this.phude = phude;
        this.trangthai = trangthai;
    }
    // Getters
    
    public String getThoigian() {
        return thoigian;
    }

    public PhongChieu getPhong() {
		return phong;
	}

	public Phim getPhim() {
        return phim;
    }

    public String getPhude() {
        return phude;
    }

    public String getTrangthai() {
        return trangthai;
    }

    // setter

	public void setPhim(Phim phim) {
		this.phim = phim;
	}

	public void setPhude(String phude) {
		this.phude = phude;
	}

	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}

	public void setPhong(PhongChieu phong) {
		this.phong = phong;
	}

    
    public String toString(int indentLevel) {
        String indent = " ".repeat(indentLevel);
        return new StringBuilder()
            .append(indent).append("SuatChieu {\n")
            .append(indent).append("  ThoiGian: '").append(thoigian).append("',\n")
            .append(indent).append("  Phim: \n").append(phim.toString(indentLevel + 3)).append(",\n")
            .append(indent).append("  PhuDe: '").append(phude).append("',\n")
            .append(indent).append("  TrangThai: '").append(trangthai).append("'\n")
            .append(indent).append("  PhongChieu: ").append(phong.toString(indentLevel + 3)).append(",\n")
            .append(indent).append("}")
            .toString();
    }

    public void setThoigian(String thoigian) {
		this.thoigian = thoigian;
	}
	@Override
    public String toString() {
        return toString(0);
    }

}

