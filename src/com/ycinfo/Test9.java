package com.ycinfo;

//增强型的for循环
public class Test9 {
    public static void main(String[] args) {
        //jdk8后新的   彩蛋
        //   for( 类型  变量名: 数组名  )

        //如何调用Test8中的生成函数
        // 语法:  类名.方法名(   实参 );
        int[] x=new int[10];
        Test8.init(x,  100  );
        System.out.println("原数组为:");

        Test8.show(   x  );

        System.out.println();

        for(  int t:   x     ){
            System.out.print(  t+"\t");
        }

    }
}
