package com.ycinfo.oop3_extends;

import java.util.Date;

public class Reply extends Topic{
    private int topicid;

    public Reply(int id, String title, String content, Date publicTime, String user, int topicid) {
       super(id, title, content, publicTime, user);  //super调用父类的构造方法
        //super();
        this.topicid = topicid;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "topicid=" + topicid + super.toString()+
                '}';
    }

    public Reply() {
        super();
    }

    public int getTopicid() {
        return topicid;
    }

    public void setTopicid(int topicid) {
        this.topicid = topicid;
    }
}
