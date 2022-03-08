package com.example.testdemo;

import java.io.Serializable;

public class NhanVien implements Serializable {
    private int avatar;
    private String maso;
    private String hoten;
    private String gioitinh;
    private String donvi;

    public NhanVien(int avatar, String maso, String hoten, String gioitinh, String donvi) {
        this.avatar = avatar;
        this.maso = maso;
        this.hoten = hoten;
        this.gioitinh = gioitinh;
        this.donvi = donvi;
    }

    public NhanVien(String maso, String hoten, String gioitinh, String donvi) {
        this.maso = maso;
        this.hoten = hoten;
        this.gioitinh = gioitinh;
        this.donvi = donvi;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String getMaso() {
        return maso;
    }

    public void setMaso(String maso) {
        this.maso = maso;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
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

    @Override
    public String toString() {
        return maso+","+hoten+","+gioitinh+","+donvi;
    }
}
