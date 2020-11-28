package com.ycinfo.oop3_extends;

import java.util.UUID;

public class Student extends Person{
   //1。 通过继承 ， 实现代码的重用
    // 2. 子类只需要集中开发自己特有的功能

    private String no;     //   UUID类   :   32位16进数

    public Student(){
        this.no= UUID.randomUUID().toString();
    }

    public String getNo() {
        return no;
    }
}
