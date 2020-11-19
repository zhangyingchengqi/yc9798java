package com.ycinfo.oop1;

import java.math.BigDecimal;

//主类:  表示程序 的入口
public class Test1 {
    public static void main(String[] args) {
        //类的实例化, new , 创建对象
        // 类型  变量名=值 ;
        int x=0;
        //语法:   类型      变量名/对象名/实例名=new 类型();
        Student    student=new Student();
        //   成员访问运算符      对象名.成员名
        student.name="张影";
        student.sex='男';
        student.age=30;
        System.out.println(    student );   //  hash值    com.ycinfo.oop1.Student@1b6d3586
                                            //   1b6d3586  内存中的地址
        System.out.println( "姓名:"+  student.name+"\t性别:"+student.sex+"\t年龄:"+student.age );
        student.info();

        Student s2=new Student();
        s2.name="范冰冰";
        s2.sex='女';
        s2.age=30;
        System.out.println(    s2 );
        System.out.println(   s2.name+"\t"+s2.sex+"\t"+s2.age );
        s2.info();


        Teacher t=new Teacher();
        System.out.println(   t );   //  com.ycinfo.oop1.Teacher@4554617c


        Teacher t2=new Teacher();
        System.out.println(   t2 );   //  com.ycinfo.oop1.Teacher@74a14482

        Product p=new Product();
        System.out.println(   p );






    }
}
