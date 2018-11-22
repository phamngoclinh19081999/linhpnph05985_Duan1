package com.phamngoclinh.loginfbfirebase.model;

public class Menu {
    private String id;
    private String tenmon;
    private String theloai;
    private String giatien;
    private int anh;

    public Menu() {
    }

    public Menu(String id, String tenmon, String theloai, String giatien, int anh) {
        this.id = id;
        this.tenmon = tenmon;
        this.theloai = theloai;
        this.giatien = giatien;
        this.anh = anh;
    }

    public String getTenmon() {
        return tenmon;
    }

    public void setTenmon(String tenmon) {
        this.tenmon = tenmon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTheloai() {
        return theloai;
    }

    public void setTheloai(String theloai) {
        this.theloai = theloai;
    }

    public String getGiatien() {
        return giatien;
    }

    public void setGiatien(String giatien) {
        this.giatien = giatien;
    }

    public int getAnh() {
        return anh;
    }

    public void setAnh(int anh) {
        this.anh = anh;
    }
}
