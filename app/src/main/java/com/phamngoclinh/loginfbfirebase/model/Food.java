package com.phamngoclinh.loginfbfirebase.model;

public class Food {
    private String food;
    private String gia;
    private String so;

    public Food(String food, String gia, String so) {
        this.food = food;
        this.gia = gia;
        this.so = so;
    }

    public Food() {
    }

    public String getSo() {
        return so;
    }

    public void setSo(String so) {
        this.so = so;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }
}
