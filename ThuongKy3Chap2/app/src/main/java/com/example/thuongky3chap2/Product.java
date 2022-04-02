package com.example.thuongky3chap2;

public class Product {
    private String name;
    private double gia;
    int anh;

    public Product(String name, double gia, int anh) {
        this.name = name;
        this.gia = gia;
        this.anh = anh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public int getAnh() {
        return anh;
    }

    public void setAnh(int anh) {
        this.anh = anh;
    }
}
