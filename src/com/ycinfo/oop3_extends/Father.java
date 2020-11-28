package com.ycinfo.oop3_extends;

public class Father {

    public Father(){}

    public Father(String s){
    }

    public static void main(String[] args) {
        new Son();
    }
}

class Son extends Father{
    public Son(){

        System.out.println("子类无参构造方法");
    }
}
