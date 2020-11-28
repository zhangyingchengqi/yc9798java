package com.ycinfo.oop3_extends;

import java.util.Date;

public class Topic {
    private int id;
    private String title;
    private String content;
    private Date publicTime;
    private String user;

    @Override
    public String toString() {
        return "贴子信息:{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", publicTime=" + publicTime +
                ", user='" + user + '\'' +
                '}';
    }

    public Topic() {
    }

    public Topic(int id, String title, String content, Date publicTime, String user) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.publicTime = publicTime;
        this.user = user;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPublicTime(Date publicTime) {
        this.publicTime = publicTime;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Date getPublicTime() {
        return publicTime;
    }

    public String getUser() {
        return user;
    }
}
