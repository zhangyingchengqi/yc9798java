package com.ycinfo.oop1;


import javax.swing.*;
import java.math.BigDecimal;

public class Product {
    String name;    // null
    double price;   //  0.0         int : 0   boolean :false
    double num;

    //构造方法: 1。 与类名相同   2. 无返回   3. new调用
    Product(){   //系统自动提供了一个无参的空的构造方法, 如自己写一个，则会覆盖系统的默认构造方法
        System.out.println("第一个构造方法");
        //初始化对象中的成员
        name="暂无产品名";
        price=0.0;
        num=0.0;

        price2=new BigDecimal("0");
        num2=new BigDecimal("0");
    }

    Product(     String n, double p, double m    ){    //形参:   类型名 变量名
        System.out.println("第二个构造方法");
        name=n;
        price=p;
        num=m;
    }

    Product(  String n, BigDecimal p, BigDecimal m){
        System.out.println("第三个构造方法");
        name=n;
        price2=p;
        num2=m;
    }

    double smallCount(){
        double total=price*num;
        //System.out.println("原价:"+total);
        //JOptionPane.showMessageDialog(null, "小计"+total);
        return total;
    }

    BigDecimal price2;
    BigDecimal num2;

    BigDecimal smallCount2(){
        if(   price2==null){
            //throw new RuntimeException();
            return new BigDecimal("0");
        }
        //任何一个对象如果是null, 则不能调用成员， 一旦调用则  NullPointException
       return  price2.multiply(num2);      //  price2 =null  num2=null
    }




}
