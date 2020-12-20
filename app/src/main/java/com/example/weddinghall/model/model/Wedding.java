package com.example.weddinghall.model.model;

public class Wedding {
    String sale;
    String name;
    String desc;
    int image;

    public Wedding() {

    }

    public Wedding(String sale, String name, String desc, int image) {
        this.sale = sale;
        this.name = name;
        this.desc = desc;
        this.image = image;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getSale() {
        return sale;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public int getImage() {
        return image;
    }
}
