package models;

import java.util.Objects;

public class LichChieu {
    private Rap rap;
    private String ngaychieu;
	
	public LichChieu(Rap rap, String ngaychieu) {
		super();
		this.rap = rap;
		this.ngaychieu = ngaychieu;
	}
	
	// ### GETTER SETTER ###
	public Rap getRap() {
		return rap;
	}

	public void setRap(Rap rap) {
		this.rap = rap;
	}

	public String getNgaychieu() {
		return ngaychieu;
	}

	public void setNgaychieu(String ngaychieu) {
		this.ngaychieu = ngaychieu;
	}
	// ### END GET SET ###
	
	public String toString(int indentLevel) {
        String indent = " ".repeat(indentLevel);

        return new StringBuilder()
            .append(indent).append("LichChieu {\n")
            .append(indent).append("  Rap: ").append(rap.toString(indentLevel + 2)).append(",\n")
            .append(indent).append("  NgayChieu: '").append(ngaychieu).append("',\n")
            .append(indent).append("}")
            .toString();
    }

    @Override
    public String toString() {
        return toString(0);
    }
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof LichChieu)) return false;
        LichChieu lichChieu = (LichChieu) o;
        return Objects.equals(rap, lichChieu.rap) &&
                Objects.equals(ngaychieu, lichChieu.ngaychieu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rap, ngaychieu);
    }

}

