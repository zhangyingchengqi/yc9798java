package com.ycinfo;   //包名    目录名

public class Main {
    //  psvm    快速输出   main方法
    public static void main(String[] args) {
	    System.out.println("hello world");       //   ctrl+x   删除一行

        int ia = 0x55; //    0x     十六进制   ->  int
        int ib = 011;   //   0      八进制

       // byte bb = 0x771;    //  byte: -128  127

        byte ba = (byte)0x771;
        long la = 12345673444443333L; //十进制

        //默认情况下，   数字当int看

        float fa = 123.4f;
        //float fb = 12.5E300F;  //越界
        float fc = (float)12.5E300;
        double dd=123;       // 表示隐式类型转换   int  ->   double
        double da = 123D;
        double db = 123.456D;
        double dc = 123.45e301;




    }
}
