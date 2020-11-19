package com.ycinfo;

import java.util.Random;

//二维数组
public class Test10 {
    public static void main(String[] args) {
        //声明
        int[][] x;
        //初始化
        x=new int[5][3];
        //二维数组元素的访问要通过两个下标
        x[0][0]=100;

        Random r=new Random();

        System.out.println(   x[0][0] +"\t"+x[0][1]);
        System.out.println(  x.length );
        System.out.println(  x[0].length );
        for( int i=0;i<x.length;i++){
            for( int j=0;j<x[i].length;j++){
                x[i][j]= r.nextInt(   5 );
            }
        }
        //输出方案一:
        for(  int i=0;i<x.length;i++    ){
            for( int j=0;j<x[i].length;j++){
                System.out.print(   x[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println("======nb的分隔线=======");
        //输出方案二:  增强型for
        //   for( 类型  变量名: 数组名)
        //         int[]            int[][]
        for(  int[] t: x  ){
           for(  int tt: t ){
               System.out.print(   tt+"\t");
           }
            System.out.println();
        }

        //求出整 个二维数组的总和，平均值， 个数
        int sum=0;
        int count=0;
        for(  int[] t: x  ){
            for(  int tt: t ){
                sum=sum+tt;
                count++;
            }
        }
        int avg=  sum/ count;
        System.out.println("总和为:"+ sum+",均值 :"+avg+",个数:"+count);
        //按行求总和，均值 .
        int[] rowSum=new int[   x.length  ];
        int[] rowLength=new int[x.length];  //每一行有多少个元素
        for(  int i=0;i<x.length;i++){
            for( int j=0;j<x[i].length;j++){
                rowSum[i]+=   x[i][j];
                rowLength[i]++;
            }
        }
        for( int i=0;i<rowSum.length;i++){
            System.out.println("第"+(i+1)+"行的总和为:"+   rowSum[i]
                    +",它总共有:"+rowLength[i]+"个元素,均值为:"+ rowSum[i]/rowLength[i]);
        }

         x=new int[][]{         {1,2,3},
                                {2,3,4,5,6},
                                {1,2,3,4,5,6,7}
                                };

        // 按列求总和，均值 .
        int cols=findMaxCol(   x   );
        int[] colSum=new int[   cols    ];     //  [0,0,0,0,0,0,0]
        int[] rowInCol=new int[cols];
        for(  int i=0;i<cols;i++){
            for(  int j=0;j<x.length;j++){
                if(   x[j].length<=i   ){
                    colSum[i]+=0;

                }else {
                    colSum[i] += x[j][i];
                    rowInCol[i]++;
                }
            }
        }
        for(  int j=0;j<colSum.length;j++){
            System.out.println("第"+(j+1)+"列的总和为:"+ colSum[j]+",它总共有:"+rowInCol[j]
                               +"行,均值 :"+ colSum[j]/rowInCol[j]);
        }


//        int[][] t=new int[][]{  {1,2,3},
//                                {2,3,4,5,6},
//                                {1,2,3,4,5,6,7}
//                                };
//        System.out.println(  findMaxCol(   t ) );

    }

    static int findMaxCol(  int[][] x){
        int max=x[0].length;
        for(  int i=1;i<x.length;i++){
            if(   x[i].length>max){
                max=x[i].length;
            }
        }
        return max;
    }



}
