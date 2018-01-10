package com.sk4atg89.alexander.jetruby.data.common;


import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class DribbbleImage extends RealmObject{

    @PrimaryKey
    private String imageUrl;
    private String title;
    private String describtion;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescribtion() {
        return describtion;
    }

    public void setDescribtion(String describtion) {
        this.describtion = describtion;
    }

}
