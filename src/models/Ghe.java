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

	// ###### GETTER, SETTER ##########
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
	// ###### END GETTER, SETTER ##########

	@Override
	public String toString() {
		return ""+hang+day;
	}
	
	 @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        Ghe ghe = (Ghe) o;
	        return hang == ghe.hang &&
	                day == ghe.day &&
	                loaiGhe == ghe.loaiGhe;
	    }
	
}
