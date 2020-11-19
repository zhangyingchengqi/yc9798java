package com.ycinfo.oop1;

/*
实现一个SodaCan类，它有getSurfaceArea()和getVolume()方法.在构造函数中，提供圆柱的高和半径
 */
public class SodaCan{
    private double height;   //属性  高
    private double radius;   //半径

    SodaCan( double newheight, double newradius){
        this.height=newheight;
        this.radius=newradius;
    }

    public double getSurfaceArea(){
        return 3.14*radius*2*height+2*(3.14*radius*radius);
    }

    public double getVolume(){
        return 3.14*radius*radius*height;
    }

    //main测试，做为程序 的入口
    public static void main(String[] args){
        SodaCan sc=new SodaCan(4, 2);
        System.out.println(    sc.getSurfaceArea()  +"\t"+sc.getVolume());
    }
}

