package com.example.sqlitedemo2;

public class Employee {
    private int id;
    private String name;
    private String address;
    private int deptId;
    public Employee(){

    }
    public Employee(int id, String name, String address, int deptId) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.deptId = deptId;
    }

    public Employee(String name, String address, int deptId) {
        this.name = name;
        this.address = address;
        this.deptId = deptId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }
}
