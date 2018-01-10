package com.sk4atg89.alexander.jetruby.domain.common;


import android.text.TextUtils;

public class DribbbleEntity {

    private String imageUrl;
    private String title;
    private String describtion;

    public DribbbleEntity(String imageUrl, String title, String describtion) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.describtion = describtion;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getDescribtion() {
        return describtion;
    }

    public boolean imageNotNull() {
        return !TextUtils.isEmpty(getImageUrl());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DribbbleEntity that = (DribbbleEntity) o;

        if (imageUrl != null ? !imageUrl.equals(that.imageUrl) : that.imageUrl != null)
            return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        return describtion != null ? describtion.equals(that.describtion) : that.describtion == null;
    }

    @Override
    public int hashCode() {
        int result = imageUrl != null ? imageUrl.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (describtion != null ? describtion.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DribbbleEntity:" +
                " imageUrl = '" + imageUrl
                + "' , title = '" + title
                + "' , description = '" + describtion + "'";
    }
}
