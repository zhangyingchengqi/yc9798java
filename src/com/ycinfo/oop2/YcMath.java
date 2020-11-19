package com.ycinfo.oop2;

import java.util.Scanner;

public class YcMath {

    public int max(  int x, int y ){
        return x>y?x:y;
    }

    public double max( double x,  double y){  //参数的类型
        return x>y?x:y;
    }

    public int max(   int x,int y, int z ){   //个数不同
        return x>y?  (x>z?x:z):    (y>z?y:z);
    }

    public double max(  int x, double y){
        return x>y?x:y;
    }

    public double max(  double x, int y){   //不同参数的顺序
        return x>y?x:y;
    }

    public static void main(String[] args) {
        YcMath m=new YcMath();

       System.out.println(    m.max(1.0, 2.1)  );   //静态多态

        System.out.println(   m.max( 1,  5.5) );   // 隐式类型转换

        System.out.println(   m.max(  1,2,3 )  );



    }
}
