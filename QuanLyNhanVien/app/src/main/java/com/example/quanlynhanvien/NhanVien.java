package com.example.quanlynhanvien;

import java.util.Arrays;

public class NhanVien {
    private String maNhanVien;
    private String tenNhanVien;
    private String gioitinh;
    private String donvi;
    private byte[] anh;

    public NhanVien(String maNhanVien, String tenNhanVien, String gioitinh, String donvi, byte[] anh) {
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.gioitinh = gioitinh;
        this.donvi = donvi;
        this.anh = anh;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getDonvi() {
        return donvi;
    }

    public void setDonvi(String donvi) {
        this.donvi = donvi;
    }

    public byte[] getAnh() {
        return anh;
    }

    public void setAnh(byte[] anh) {
        this.anh = anh;
    }

    @Override
    public String toString() {
        return "NhanVien{" +
                "maNhanVien='" + maNhanVien + '\'' +
                ", tenNhanVien='" + tenNhanVien + '\'' +
                ", gioitinh='" + gioitinh + '\'' +
                ", donvi='" + donvi + '\'' +
                ", anh=" + Arrays.toString(anh) +
                '}';
    }
}
