package com.ycinfo.oop1;

//代表一个学生   :    相当于  C中的   结构体+函数
// 类由属性+方法
public class Student {

    String name;   //属性,成员变量，字段   field
    char sex;
    int age;

    //方法,成员方法  method
    //不需要静态
    void info(){
        System.out.println(   "*****姓名:"+ name+"\t性别:"+sex+"\t年龄:"+age     );
    }

}
