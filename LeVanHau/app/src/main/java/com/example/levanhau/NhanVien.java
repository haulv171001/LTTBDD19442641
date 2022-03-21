package com.example.levanhau;

public class NhanVien {
    private String maNV;
    private String tenNV;
    private String ngaysinhNV;
    private String diachiNV;

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getNgaysinhNV() {
        return ngaysinhNV;
    }

    public void setNgaysinhNV(String ngaysinhNV) {
        this.ngaysinhNV = ngaysinhNV;
    }

    public String getDiachiNV() {
        return diachiNV;
    }

    public void setDiachiNV(String diachiNV) {
        this.diachiNV = diachiNV;
    }

    public NhanVien(String maNV, String tenNV, String ngaysinhNV, String diachiNV) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.ngaysinhNV = ngaysinhNV;
        this.diachiNV = diachiNV;
    }

    public NhanVien() {

    }

    @Override
    public String toString() {
        return maNV+","+tenNV+","+ngaysinhNV+","+diachiNV;
    }
}
