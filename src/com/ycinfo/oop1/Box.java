package com.ycinfo.oop1;

/*
编写一个名为Box的类，含整型的height,width,length，volume四个属性，要求在构造方法中将其初始化，
并定义一个计算体积的calcVolume方法和一个输出体积的print方法，在main方法中进行调用
 */
public class Box {
    // 属性: attribute  field     私有
    private double height,width,length;
    private double volume;

    public Box(double height, double width, double length) {
        this.height = height;
        this.width = width;
        this.length = length;
    }

    public void calcVolumne(){
        this.volume= this.height*this.width*this.length;

    }

    public void print(){
        System.out.println(  "长为:"+this.length+"\t宽:"+this.width+"\t高:"+this.height+"\t体积为:"+this.volume );
    }

    public static void main(String[] args) {
        Box b=new Box( 1, 2, 3   );
        b.calcVolumne();
        b.print();

    }
}
