package com.ycinfo.oop1;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入vip名:");
        String name=sc.nextLine();
        System.out.println("请输入密码:");
        String pwd=sc.nextLine();

        Vip vip=new Vip(   name, pwd,-3 );
        //vip.name=name;
        //vip.pwd=pwd;
        //String n=vip.getName().substring(0,1)+"*****";
        System.out.println(    vip.getName()+"\t"+vip.getPwd() );
    }
}

//  abc
//  xyz


// key: