package models;

import models.enums.LoaiGhe;

public class Ghe {
	
	private char hang;
	private int day;
	LoaiGhe loaiGhe;
	
	public Ghe(char hang, int day, LoaiGhe loaiGhe) {
		super();
		this.hang = hang;
		this.day = day;
		this.loaiGhe = loaiGhe;
	}

	public char getHang() {
		return hang;
	}

	public void setHang(char hang) {
		this.hang = hang;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public LoaiGhe getLoaiGhe() {
		return loaiGhe;
	}

	public void setLoaiGhe(LoaiGhe loaiGhe) {
		this.loaiGhe = loaiGhe;
	}

	@Override
	public String toString() {
		return ""+hang+day;
	}
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Ghe ghe = (Ghe) obj;
        return hang == ghe.hang && day == ghe.day;
    }
	
	@Override
    public int hashCode() {
        int result = Character.hashCode(hang);
        result = 31 * result + Integer.hashCode(day);
        return result;
    }
}
