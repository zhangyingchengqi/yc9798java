package com.ycinfo;


import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        //输出
        System.out.println("a");     ///   换行  ln ->  newline
        System.out.print( "b");
        System.out.print("\tc\n\n\n");

        //输入
        //1. 命令行参数输入
        System.out.println(args[0]+"\t"+args[1]);
        //                   5
        if(  args!=null && args.length>0){
            for( int i=0;i<args.length;i++){
                System.out.println("参数"+   (i+1) +"的值为:"+   args[i]   );
            }
        }
        //流
        System.out.println("请输入您的姓名:");
        //扫描器    #include <stdio.h> scanf()
        // java.util下的  Scanner类   ( jdk定义）
        Scanner input=new Scanner(  System.in  );    //  系统标准输入流(输出流,错误流)    System.in/out/err

        String name= input.nextLine();    //输入一行字符串，以回车结束
        System.out.println("请输入您的年龄:");
        int age=input.nextInt();

        System.out.println("请输入体重(kg):");
        float weight=input.nextFloat();

       System.out.println("请输入身高(m):");
       float height=input.nextFloat();

       float bmi=weight/(height*height);

        System.out.println("我的姓名为:"+name+",年龄为:"+age+",体重为:"+weight+",身高为:"+height);
        System.out.println("bmi值为"+ bmi);

        if(   bmi<18.5){
            System.err.println("过轻 某些疾病和某些癌症患病率增高");
        }else if(bmi<23.5){
            System.out.println("正常");
        }else if( bmi<27.9){
            System.out.println("超重");
        }else{
            System.err.println("肥胖");
        }

        //扩展:  输入身高， 计算 bmi值 （     ）

    }
}
