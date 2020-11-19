package com.ycinfo.oop2;

public class Student {
    private String name;   //  null

    public Student(){
        System.out.println(  "构造方法:"+ this  );  //this对象中的隐藏的属性
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Student s=new Student();
        System.out.println(   s  );   // com.ycinfo.oop2.Student@1b6d3586
                                     //   类的全路径@十六进制表示的hashcode

        System.out.println(   s.getName() );

        s.setName( "张三丰");
        System.out.println(   s.getName() );

        Student s2=new Student();
        s2.setName("李四");
    }
}
