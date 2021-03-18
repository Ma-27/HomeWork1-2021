package com.mamh.homework12021.bean;

public class ArticleBean {
    private final String title;
    private final String link;

    public ArticleBean(String title, String link) {
        this.title = title;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }
}
