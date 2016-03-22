package com.noveo.traineeship.network.models;

import android.graphics.Bitmap;

import java.util.Date;

public class News {
    private String id;
    private Bitmap image;
    private Date date;
    private String title;
    private String[] topics;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getTopics() {
        return topics;
    }

    public void setTopics(String[] topics) {
        this.topics = topics;
    }
}
