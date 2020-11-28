package com.ycinfo.sortStudent;

import com.ycinfo.datatype.YcList2;

import java.util.Random;

public class Test2_YcList2 {
    public static void main(String[] args) {
        YcList2 list=new YcList2();
        Random r=new Random();
        Student s=null;

        for( int i=0;i<100;i++){
            //生成学生名:  张1....张n
            //随机生成学生成绩:   0-100.
            //    张01   张11   张21
             s=new Student(   "张"+(i+1),   r.nextInt(  51  )+50 ,  r.nextInt(  51)+50      );
            list.add(   s );
        }

        for( int i=0;i<list.size();i++){
            Student stu=(Student)list.get(i);
            System.out.println(  stu );   //  toString
        }

    }
}
