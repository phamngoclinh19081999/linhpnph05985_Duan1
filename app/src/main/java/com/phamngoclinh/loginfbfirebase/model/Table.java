package com.phamngoclinh.loginfbfirebase.model;

public class Table {
    private String id;
    private String soban;
    private String sotang;
    private String status;

    public Table(){

    }

    public Table(String id, String soban, String sotang,String status) {
        this.id = id;
        this.soban = soban;
        this.sotang = sotang;
        this.status =status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSoban() {
        return soban;
    }

    public void setSoban(String soban) {
        this.soban = soban;
    }

    public String getSotang() {
        return sotang;
    }

    public void setSotang(String sotang) {
        this.sotang = sotang;
    }
}
