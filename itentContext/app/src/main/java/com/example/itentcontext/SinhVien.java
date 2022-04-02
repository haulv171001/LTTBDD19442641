package com.example.itentcontext;

public class SinhVien {
    private String maSinhvien;
    private String tenSinhvien;
    private String namsinh;
    private String gioitinh;
    public SinhVien(){

    }

    public SinhVien(String maSinhvien, String tenSinhvien, String namsinh, String gioitinh) {
        this.maSinhvien = maSinhvien;
        this.tenSinhvien = tenSinhvien;
        this.namsinh = namsinh;
        this.gioitinh = gioitinh;
    }

    public String getMaSinhvien() {
        return maSinhvien;
    }

    public void setMaSinhvien(String maSinhvien) {
        this.maSinhvien = maSinhvien;
    }

    public String getTenSinhvien() {
        return tenSinhvien;
    }

    public void setTenSinhvien(String tenSinhvien) {
        this.tenSinhvien = tenSinhvien;
    }

    public String getNamsinh() {
        return namsinh;
    }

    public void setNamsinh(String namsinh) {
        this.namsinh = namsinh;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "maSinhvien='" + maSinhvien + '\'' +
                ", tenSinhvien='" + tenSinhvien + '\'' +
                ", namsinh='" + namsinh + '\'' +
                ", gioitinh='" + gioitinh + '\'' +
                '}';
    }
}
