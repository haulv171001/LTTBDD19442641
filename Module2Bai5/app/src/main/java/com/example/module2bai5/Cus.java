package com.example.module2bai5;

public class Cus {
    String name;
    int soluong;
    boolean Vip;
    double tongtien;

    public Cus(String name, int soluong, boolean vip, double tongtien) {
        this.name = name;
        this.soluong = soluong;
        Vip = vip;
        this.tongtien = tongtien;
    }

    public Cus() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public boolean isVip() {
        return Vip;
    }

    public void setVip(boolean vip) {
        Vip = vip;
    }

    public double getTongtien() {
        return tongtien;
    }

    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }

    @Override
    public String toString() {
        return "Cus{" +
                "name='" + name + '\'' +
                ", soluong=" + soluong +
                ", Vip=" + Vip +
                ", tongtien=" + tongtien +
                '}';
    }
}
