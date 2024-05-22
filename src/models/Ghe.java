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
	
}
