package com.ycinfo.oop3_extends;

import java.util.Date;

public class Test2 {
    public static void main(String[] args) {
        Topic t=new Topic(1, "老马因病去世,上帝之手回归上帝...","xxxxx",new Date(), "老张");

        Reply r=new Reply(9999,"跟一个","一路走好...",new Date(), "老李", t.getId() );

        System.out.println(   t) ;

        System.out.println(  r );


    }
}
