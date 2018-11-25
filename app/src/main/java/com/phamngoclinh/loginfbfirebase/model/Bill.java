package com.phamngoclinh.loginfbfirebase.model;

public class Bill {
    private String table;
    private String floor;
    private String namefood;
    private String tongtien;

    public Bill(String table, String floor, String namefood, String tongtien) {
        this.table = table;
        this.floor = floor;
        this.namefood = namefood;
        this.tongtien = tongtien;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getNamefood() {
        return namefood;
    }

    public void setNamefood(String namefood) {
        this.namefood = namefood;
    }

    public String getTongtien() {
        return tongtien;
    }

    public void setTongtien(String tongtien) {
        this.tongtien = tongtien;
    }
}
