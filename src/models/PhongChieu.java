package models;

import java.util.Objects;
import models.enums.LoaiGhe;
import models.enums.LoaiPhong;

public class PhongChieu {

    private String tenPhong;
    private LoaiPhong loaiPhong;
    private int soHang, soDay;
    private Ghe[][] soDoGhe;

    // Constructor
    public PhongChieu(String tenPhong, LoaiPhong loaiPhong, int soHang, int soDay) {
        this.tenPhong = tenPhong;
        this.loaiPhong = loaiPhong;
        this.soHang = soHang;
        this.soDay = soDay;
        initializeSeatMap();
    }

    // Initialize the seat map with appropriate seat types
    private void initializeSeatMap() {
        soDoGhe = new Ghe[soHang][soDay];
        for (char hang = 0; hang < soHang; hang++) {
            for (int day = 0; day < soDay; day++) {
                LoaiGhe loaiGhe = determineSeatType((char)('A'+hang), day+1);
                soDoGhe[hang][day] = new Ghe((char)(hang+'A'), day+1, loaiGhe);
            }
        }
    }

    // Determine seat type based on row and column
    private LoaiGhe determineSeatType(char hang, int day) {
        return (hang >= 'E' && hang <= 'I') ? LoaiGhe.VIP : LoaiGhe.THUONG;
    }

    // Get a specific seat
    public Ghe getGhe(char hang, int day) {
        return soDoGhe[hang - 'A'][day - 1];
    }

    // Getters and Setters
    public String getTenPhong() { return tenPhong; }
    public void setTenPhong(String tenPhong) { this.tenPhong = tenPhong; }
    public LoaiPhong getLoaiPhong() { return loaiPhong; }
    public void setLoaiPhong(LoaiPhong loaiPhong) { this.loaiPhong = loaiPhong; }
    public int getSoHang() { return soHang; }
    public void setSoHang(int soHang) { this.soHang = soHang; }
    public int getSoDay() { return soDay; }
    public void setSoDay(int soDay) { this.soDay = soDay; }
    public Ghe[][] getSoDoGhe() { return soDoGhe; }
    public void setMangGhe(Ghe[][] mangGhe) { this.soDoGhe = mangGhe; }

    // Return formatted string representation of the object
    public String toString(int indentLevel) {
        String indent = " ".repeat(indentLevel);
        return String.format("%s%s, %s, %d day, %d hang", indent, tenPhong, loaiPhong, soDay, soHang);
    }

    @Override
    public String toString() {
        return toString(0);
    }

    // Calculate the total number of seats
    public int getSoLuongGhe() {
        return this.soDay * this.soHang;
    }

    // Equals and hashCode methods for comparison and hashing
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhongChieu that = (PhongChieu) o;
        return soHang == that.soHang && soDay == that.soDay &&
               Objects.equals(tenPhong, that.tenPhong) &&
               loaiPhong == that.loaiPhong &&
               Objects.equals(soDoGhe, that.soDoGhe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tenPhong, soHang, soDay, loaiPhong, soDoGhe);
    }
}
