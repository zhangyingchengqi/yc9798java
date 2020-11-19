package com.ycinfo;

import java.util.Random;

public class Test7 {

    public static void main(String[] args) {
        int x=0;       //需求: 存入大量的值

        //    开盘价,  最高价，最低价   收盘价
        //引入数组:   对象, 一个连续的空间( 分为很多个元素   ，这些元素的空间是一样大 )
        //数组的定义语法:
        //   类型名[] 数组名;
        double [] prices;    //只是一个引用变量
        //初始化数组
        prices=new double[2];   //  数组名=new 类型[长度];
        System.out.println(  prices[0] );
        prices=new double[]{1.0,2.0};    //
        System.out.println(   prices[0]);

        System.out.println(   prices );   //    [D@xxx


        int[] y=new int[4];
         y[0]=1;
         y[1]=2;
         y[2]=3;
         System.out.println(  y );    //   [I@1b6d3586     [-》数组  I:int  @     1b6d3586  地址的十六进制编码

         System.out.println(   y[0]+" "+y[1]+" "+y[2] );

         //数组的length属性求数组的长度
        System.out.println(  "数组长度:"+ y.length  );
         //循环输出
        for( int i=0;i<  y.length ;i++){
            System.out.println(   y[i] );
        }

        //倒序输出
        System.out.println("======倒序输出====");
        for(   int i=y.length-1;   i>=0;i--   ){
            System.out.println(    y[i]  );
        }

        //    随机数生成器    长度为  5,
        //Random  r=new Random();
        //r.nextInt(10);
        System.out.println("===================");
        Random r=new Random();   // Random 是java.util包下的一个类,所以要import
        //定义数组，长度 5
        int []  arrs=new int[5];
        for( int i=0;i< arrs.length;i++ ){
            arrs[i]=  r.nextInt(  10 );     //   这里表示生成的数在  10以内( 0-9 )
        }

        for( int i=0;i<arrs.length;i++){
            System.out.println(   arrs[i] );
        }






    }



}
