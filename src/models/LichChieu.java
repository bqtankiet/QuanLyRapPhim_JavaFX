package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LichChieu {
    private Rap rap;
    private PhongChieu phong;
    private String ngaychieu;
	private List<SuatChieu> dsSuatChieu;
	
	public LichChieu(Rap rap, PhongChieu phong, String ngaychieu, List<SuatChieu> dsSuatChieu) {
		super();
		this.rap = rap;
		this.phong = phong;
		this.ngaychieu = ngaychieu;
		this.dsSuatChieu = dsSuatChieu;
	}
	
	public LichChieu(Rap rap, PhongChieu phong, String ngaychieu) {
		super();
		this.rap = rap;
		this.phong = phong;
		this.ngaychieu = ngaychieu;
		this.dsSuatChieu = new ArrayList<SuatChieu>();
	}
	
	// ### GETTER SETTER ###
	public Rap getRap() {
		return rap;
	}

	public void setRap(Rap rap) {
		this.rap = rap;
	}

	public PhongChieu getPhong() {
		return phong;
	}

	public void setPhong(PhongChieu phong) {
		this.phong = phong;
	}

	public String getNgaychieu() {
		return ngaychieu;
	}

	public void setNgaychieu(String ngaychieu) {
		this.ngaychieu = ngaychieu;
	}

	public List<SuatChieu> getDsSuatChieu() {
		return dsSuatChieu;
	}

	public void setDsSuatChieu(List<SuatChieu> dsSuatChieu) {
		this.dsSuatChieu = dsSuatChieu;
	}
	// ### END GET SET ###
	
	public String toString(int indentLevel) {
        String indent = " ".repeat(indentLevel);
        StringBuilder dsSuatChieuStr = new StringBuilder();
        for (SuatChieu suatChieu : dsSuatChieu) {
            dsSuatChieuStr.append(suatChieu.toString(indentLevel + 2)).append(",\n");
        }

        return new StringBuilder()
            .append(indent).append("LichChieu {\n")
            .append(indent).append("  Rap: ").append(rap.toString(indentLevel + 2)).append(",\n")
            .append(indent).append("  PhongChieu: ").append(phong.toString(indentLevel + 2)).append(",\n")
            .append(indent).append("  NgayChieu: '").append(ngaychieu).append("',\n")
            .append(indent).append("  dsSuatChieu: [\n").append(dsSuatChieuStr).append(indent).append("  ]\n")
            .append(indent).append("}")
            .toString();
    }

    @Override
    public String toString() {
        return toString(0);
    }
	
	public void themSuatChieu(SuatChieu suatChieu) {
		if(dsSuatChieu == null) {
			dsSuatChieu = new ArrayList<>();
		}
		dsSuatChieu.add(suatChieu);
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof LichChieu)) return false;
        LichChieu lichChieu = (LichChieu) o;
        return Objects.equals(rap, lichChieu.rap) &&
                Objects.equals(phong, lichChieu.phong) &&
                Objects.equals(ngaychieu, lichChieu.ngaychieu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rap, phong, ngaychieu);
    }

}

