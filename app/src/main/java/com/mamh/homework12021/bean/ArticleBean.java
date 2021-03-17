package com.mamh.homework12021.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class ArticleBean implements Parcelable {
    public static final Creator<ArticleBean> CREATOR = new Creator<ArticleBean>() {
        @Override
        public ArticleBean createFromParcel(Parcel in) {
            return new ArticleBean(in);
        }

        @Override
        public ArticleBean[] newArray(int size) {
            return new ArticleBean[size];
        }
    };
    private final String title;
    private final String link;

    public ArticleBean(String title, String link) {
        this.title = title;
        this.link = link;
    }

    protected ArticleBean(Parcel in) {
        title = in.readString();
        link = in.readString();
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(link);
    }
}
