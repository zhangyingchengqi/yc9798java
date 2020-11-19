package com.ycinfo;

import java.util.Random;      // java.util
import java.util.Scanner;

public class Test5 {
    //随机数
    public static void main(String[] args) {
        // Random 表示随机数生成器，它放在java.util包下,所以要引入
        Random r=new Random();

        int x=r.nextInt();
        System.out.println("生成随机值为:"+   x );

       int y= r.nextInt(  200   );   //   (0,1]
       System.out.println( "生成随机值为:"+ y );

       //(18-40)
        Scanner input=new Scanner(System.in);
        System.out.println("请输入最小年龄:");
        int min=input.nextInt();
        System.out.println("请输入最大年龄:");
        int max=input.nextInt();
        for( int i=0;i<100 ;i++) {
            int z = r.nextInt(max - min + 1) + min;
            System.out.println("生成的年龄:" + z);
        }
    }
}
