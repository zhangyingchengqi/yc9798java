package com.ycinfo.oop1;

/*
编写一个包含名为Calculator类的程序。定义两个整型属性以及对该两个变量的setter和getter，
编写用于对两个属性执行加、减、乘、除运算方法。
在main方法里创建该类的对象并访问这些方法
 */
public class Calculator {
    private int x;
    private int y;

    public static void main(String[] args) {
        Calculator c=new Calculator();
        c.setX(10);
        c.setY(20);
        System.out.println(  c.add() );
    }

    public int add(){
        return x+y;
    }

    public int substract(){
        return x-y;
    }


    public int multiply(){
        return x*y;
    }

    public int divide(){
        if( y==0 ){
            throw new RuntimeException("不能除0");
        }
        return x/y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


}
