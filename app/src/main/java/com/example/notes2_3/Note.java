package com.example.notes2_3;

import java.io.Serializable;

public class Note implements Serializable {

    private  String image;
    private  String title;
    private String desc;
    private  String date;

    public Note(String image, String title, String desc, String date) {
        this.image = image;
        this.title = title;
        this.desc = desc;
        this.date = date;
    }


    public void setImage(String image) {
        this.image = image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getDate() {
        return date;
    }
}
