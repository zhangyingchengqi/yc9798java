package com.ycinfo;

import java.util.Scanner;

//万年历
public class Test4 {
    // psvm   refactor
    public static void main(String[] args) {
        Scanner input=new Scanner(   System.in  );
        System.out.println("请输入年份:");
        int year=input.nextInt();
        System.out.println("请输入月份:");
        int month=input.nextInt();
        System.out.println("请输入日期:");
        int day=input.nextInt();

        int days= getDays(   year, month  );  //   实参
        //  + 联接
        System.out.println(  year+"年"+month+"月有:"+  days +"天" );

        //1。 计算year年的month月的1号是星期几.
        int totals=0;
        //     计算从  1900 到  year的总天数
        for(  int i=1900;i<year;i++  ){
            if(   isRun(i)   ){
                totals+=366;
            }else{
                totals+=365;
            }
        }
        //作用域
        //     累加  year的   1月到   month的总天数
        for( int i=1;i<month;i++){
            totals+=  getDays(  year, i      );      //
        }
        //     再多加一天，得到  year年的month月的一号有多少天.
        totals+=1;
        //     将这个结果%7   得到的结果就是   一号   星期几
        int weekday=totals%7;
        if(   weekday%7==0 ){     //   解决一号正好是星期一:   weekday=0
            weekday=7;
        }
        System.out.println(year+"年"+month+"月有:"+ totals+", 这个月的一号是星期:"+ weekday);
        // 2020年10月有:44104, 这个月的一号是星期:4

        System.out.println("================忧郁的分隔线=================");
        System.out.println(year+"年"+month+"月");
        System.out.println("一\t二\t三\t四\t五\t六\t日");
        for( int i=1;i<weekday;i++){
            System.out.print("\t");
        }
        for(  int i=1;i<=days;i++){
            if(  i==day ) {
                System.out.print(   "*"+i + "*\t");
            }else{
                System.out.print(  i+"\t");
            }
            //     (1+ 0-1)  %7==6
            //    (1+6-1)%7 ==6
            if(  (i+weekday-1)%7==0   ){   //    6 \n     13\n     20\n
                System.out.println();
            }
            //    当前这个月的一号如果 是星期一:  weekday=0;
        }



    }

    static  boolean isRun(  int year ){
        if( year%4==0&&year%100!=0   ||  year%400==0){
            return true;
        }else{
           return false;
        }
    }

    /**
     * 确定 year年month月有多少天
     * @param year
     * @param month
     * @return  此月的天数
     */
    static  int getDays(   int year, int month){    //   形参
        int days=0;
        switch( month ){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:   days=31; break;
            case 4:
            case 6:
            case 9:
            case 11:  days=30; break;
            default:
                boolean b=isRun(   year );
                if(   b      ){
                    days=29;
                }else{
                    days=28;
                }
        }
        return days;
    }
}
