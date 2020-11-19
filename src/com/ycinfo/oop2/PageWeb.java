package com.ycinfo.oop2;

public class PageWeb {

    private static int num;   //静态成员变量

    public void showIndex(){
        System.out.println("欢迎....");
        PageWeb.num++;
    }

    public static void main(String[] args) {
//        //1。 类名.静态成员名
//        System.out.println(   PageWeb.num );
//
//        PageWeb pw=new PageWeb();
//        pw.showIndex();   //非静态的成员用对象名.成员名
//
//        System.out.println("访问次数:"+   PageWeb.num );

        Dog d=new Dog();
        Dog d2=new Dog();
        System.out.println(  Dog.num     );   //2
        System.out.println( d.num2      );   //1
        System.out.println(   d2.num2 );    //1
       // System.out.println(    "静态的成员也可以通过实例名调用:"+   d2.num );

    }

}


class Dog{
    static int num;  //类
    int num2;   //对象

    Dog(){
        Dog.num++;
        this.num2++;
    }

    public void show(){
        System.out.println(    num+"\t"+ num2  );
    }

    public static void show2(){  //静态方法
        //System.out.println(    num+"\t"+ num2  );
    }
}
