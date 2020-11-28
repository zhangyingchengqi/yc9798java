package com.ycinfo.sortStudent;

import java.util.Arrays;
import java.util.Random;

public class Test1_base {
    public static void main(String[] args) {
        //数组  100
        Student [] ss=new Student[100];
        Random r=new Random();
        for( int i=0;i<100;i++){
            //生成学生名:  张1....张n
            //随机生成学生成绩:   0-100.
            //    张01   张11   张21
            ss[i]=new Student(   "张"+(i+1),   r.nextInt(  51  )+50 ,  r.nextInt(  51)+50      );
        }
        //打印排序前的学生
        show(   ss );
        // mao泡排序算法
        System.out.println("======================排序后的==========================");
        Student[] x=bubbleSort( ss  );
        show(  x );

        //打印排序后的学生
        // 改进算法     O(N)   排序.
    }

    public Student[]   countSort(  Student[] ss ){
        return null;   //  pass
    }

    public static  Student[] bubbleSort(  Student[] oldArray){
        Student [] arr= Arrays.copyOf( oldArray, oldArray.length  );  //数组复制
        //外循环控制   arr.length-1
        for(  int i=1;i<arr.length;i++){
            boolean flag=true;   //标量, 标志内循环是否完成过交换,
            for( int j=0;j<arr.length-i;j++){
//                int totalJ=  arr[j].getC()+  arr[j].getJava();
//                int totalJP=  arr[j+1].getC()+arr[j+1].getJava();
//                if( totalJ>totalJP ){    //  比较的业务规则 :  比较的是c和java的总成绩
                //if(   (arr[j].getC()+  arr[j].getJava()) >    ( arr[j+1].getC()+arr[j+1].getJava())    ){

                  if(    arr[j].compareTo(  arr[j+1] ) >0  ) {
                    Student temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;

                    flag=false;
                }
            }
            if(  flag ){
                break;    // return;   return arr;
            }
        }
        return arr;
    }


    public static   void show(  Student[] ss){
        //    i....ss.length
        //    增强型的for   :  输出 ，无须下标
        for(   Student s: ss  ){
            System.out.println(  s  );    //   s 对象名.toString....
           // System.out.println(   s.toString()  );   //与上面的调用效果一样
        }


    }


}
