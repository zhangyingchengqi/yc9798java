package com.ycinfo;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner input=new Scanner(   System.in  );
        System.out.println("请输入年份:");
        int year=input.nextInt();
        System.out.println("请输入月份:");
        int month=input.nextInt();
        System.out.println("请输入日期:");
        int date=input.nextInt();
        int total=0;
        for(int i=1;i<month;i++){
            if( i==1 || i==3   ||  i==5  ||  i==7  || i==8  || i==10  || i==12 ) {
                total +=31;
            }else if( i==2 ){
                if(  year%4==0&&year%100!=0    ||   year%400==0    ){
                    total+=29;
                }else{
                    total+=28;
                }
            }else{
                total+=30;
            }
        }
        //total+=1;
        //total++;
        total=total+date;
        System.out.println( year+"年"+month+"月"+date+"号是我今年虚度的第"+   total+"天");

        int yeardays=365;
        if(  year%4==0&&year%100!=0    ||   year%400==0    ){
            yeardays=366;
        }
        System.out.println("令人欣喜的是还是"+  (yeardays-total)+"就元旦了...."  );   // 69

    }
}
