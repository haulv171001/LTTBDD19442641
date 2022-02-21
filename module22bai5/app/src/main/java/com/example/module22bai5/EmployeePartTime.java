package com.example.module22bai5;

public class EmployeePartTime extends  Employee{

    @Override
    public double TinhLuong() {
        return 150;
    }

    @Override
    public String toString() {
        return super.toString() + "--> Part time = " + TinhLuong();
    }
}
