package test;

import models.Ghe;
import models.enums.LoaiGhe;

public class GheTest {

	public static void main(String[] args) {
		Ghe ghe = new Ghe('A', 1, LoaiGhe.THUONG);
		System.out.println(ghe);
	}
	
}
