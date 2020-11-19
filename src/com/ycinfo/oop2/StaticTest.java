package com.ycinfo.oop2;

public class StaticTest {
    {
        //实例块
        System.out.println(  "StaticTest实例块");
    }

    static{
        System.out.println("StaticTest静态块");
    }

    public StaticTest(){
        System.out.println("StaticTest构造方法");
    }

    public void show1(){   //普通方法   or   实例方法
        System.out.println("StaticTest实例方法，对象方法,成员方法");
    }

    public static void show2(){   //普通方法   or   实例方法
        System.out.println("StaticTest静态方法");
    }

    public static void main(String[] args) {  //入口类会被 jvm加载.
        new TestA();


    }
}

//   1. 输出 顺序     2. 什么调用  3.输出 几次
class TestA{

    {
        //实例块
        System.out.println(  "实例块");
    }

    static{
        System.out.println("静态块");
    }

    public TestA(){
        System.out.println("构造方法");
    }

    public void show1(){   //普通方法   or   实例方法
        System.out.println("实例方法，对象方法,成员方法");
    }

    public static void show2(){   //普通方法   or   实例方法
        System.out.println("静态方法");
    }

}
