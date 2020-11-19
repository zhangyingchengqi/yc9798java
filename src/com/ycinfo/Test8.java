package com.ycinfo;


import java.util.Arrays;
import java.util.Random;

public class Test8 {
    public static void main(String[] args) {
        //数组声明
        int [] arr=new int[10];   //    10 个元素  int    -> 0
        init(  arr,10 );
        //int[] arr=new int[]{2,4,6,8};
        show(   arr );

        int[] result=getInfo(  arr );
        System.out.println(  "\n最大值:"+result[0]+"\t最小值 :"+result[1]+"\t均值:"+result[2]
                   +"\t中位数:"+result[3]+"\t长度:"+result[4] );

    }

    static int[] getInfo( int[] x ){
        // return [最大值,最小值,均值 ，中位数，个数]
        int max=findMax(x);
        int min=findMin(x);
        int avg=findAvg(x);
        int mean=findMean(x);
        int length=findLength(x);

        int[] result=new int[]{  max,min,avg,mean,length };
        return result;
    }

    //中位数
    static int findMean( int[] x ){   //
        //1。 排序，返回新的排好序的数组
        int [] arr=insertSort(  x );
        //2. 对这个新数组找中位数
        if(   arr.length%2==0){
            //4。 如是偶数个. 则为   (arr.length/2)-1的位置+    arr.length/2 的位置 的和  /2
            int index1=   arr.length/2-1;
            int index2=  arr.length/2;
            return (arr[index1]+arr[index2])/2;
        }else{
            //3. 如是奇数个，则是中间那一个数字
            int index= arr.length/2;
            return arr[index];
        }
    }



    static int[] insertSort(  int[] oldArray){
        int[] arr= Arrays.copyOf( oldArray,oldArray.length);
        for( int i=1;i<arr.length;i++){
            //记录要插入的当前值
            int tmp=arr[i];
            //记录当前的下标
            int j=i;
            //循环子序列
            while(  j>0 &&  tmp<arr[j-1]  ) {       // 1.
                arr[j]=arr[j-1];   //右移值
                j--;
            }
            //插入
            if(  j!=i){
                arr[j]=tmp;
            }
        }
        return arr;
    }



    static int[] selectSort2(int[] oldArray){
        int[] arr= Arrays.copyOf( oldArray,oldArray.length);
        for( int i=0;i<arr.length-1;i++){
           int minIndex=getIndexOfMin(  arr, i,arr.length-1  ) ;
           swap(  arr, i,  minIndex );
        }
        return arr;
    }

    static void swap(  int [] arr, int i, int minIndex){
        int temp=arr[i];
        arr[i]=arr[minIndex];
        arr[minIndex]=temp;
    }

    /**
     * 从arr中的  first到last中找最小值 的位置
     * @param arr
     * @param first
     * @param last
     * @return
     */
    static int getIndexOfMin(  int[] arr, int first, int last   ){
        int min=arr[first];   //first中当成是最小值
        int indexOfMin=   first;   //上面的最小值 的索引
        for(   int index=first+1;index<=last;index++){
            if(  arr[index]<min ){
                min=arr[index];     //修改最小的值
                indexOfMin=  index;   //这个最小值 的索引 号要修改
            }
        }
        return indexOfMin;
    }


    static int[] selectSort( int [] oldArray){
        int[] arr= Arrays.copyOf( oldArray,oldArray.length);

        for( int i=0;i<arr.length-1;i++){
            int min=i;
            //内循环找没有排序的元素中比min小的
            for(int j=i+1;j<arr.length;j++){
                if(   arr[j]<arr[min] ){
                    min=j;
                }
            }
            if(  min!=i){
                int temp=arr[i];
                arr[i]=arr[min];
                arr[min]=temp;
            }
        }
        return arr;
    }

    /**
     *
     * @param arr  待排序的数组
     * @return   一个排好序的新数组
     */
    static int[]  bubbleSort(  int[] oldArray ){
        int [] arr= Arrays.copyOf( oldArray, oldArray.length  );
        //外循环控制   arr.length-1
        for(  int i=1;i<arr.length;i++){
            boolean flag=true;   //标量, 标志内循环是否完成过交换,
            for( int j=0;j<arr.length-i;j++){
                if(  arr[j]>arr[j+1] ){
                    int temp=arr[j];
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




    static int findLength( int[] x){
        if(  x==null || x.length<=0) {
            return 0;
        }else{
            return x.length;
        }
    }


    static int findAvg( int[] x ){
        if(  x==null || x.length<=0) {
            System.out.println("数组为空....");
            throw new RuntimeException("数组为空....");   //抛出异常，并打断程序
        }
        int sum=0;
        for( int i=0;i<x.length;i++) {
            sum+=x[i];  //   x[数组长度]
        }
        int avg=sum/x.length;   //   两个整数相除的结果仍为整数
        return avg;
    }

    static int findMin( int[] x){
        if(  x==null || x.length<=0) {
            System.out.println("数组为空....");
            throw new RuntimeException("数组为空....");   //抛出异常，并打断程序
        }
        int min=x[0];
        for( int i=1;i<x.length;i++){
            if(  min>x[i]  ){
                min=x[i];
            }
        }
        return min;
    }

    /**
     * 从x数组中查找最大值
     * @param x
     * @return 最大值
     */
    static int findMax(  int [] x  ){
        if(  x==null || x.length<=0) {
            System.out.println("数组为空....");
            throw new RuntimeException("数组为空....");   //抛出异常，并打断程序
        }
        int max=x[0];
        for( int i=1;i<x.length;i++){
            if(  max<x[i]  ){
                max=x[i];
            }
        }
        return max;
    }

    /**
     * 对x生成范围在bound中的值
     * @Author: zy
     * @param x  : 空数组
     * @param bound:  范围
     */
    static void init(   int[] x   ,   int bound ){
        if(  x==null || x.length<=0) {
            System.out.println("数组为空....");
            return;   //打断
        }
        Random r=new Random();
        for( int i=0;i<x.length;i++){
            x[i]=  r.nextInt(   bound );
        }
    }

    /*函数一: 给一个数组，可以输出这个数组所有的值
     已知: 数组     形参
    返回值 :  void*/
    static void show(   int[] x    ){
        if(  x==null ||  x.length<=0 ){
            System.out.println("数组为空....");
            return;   //打断   break;  ->   循环，switch
        }
        for( int i=0;i<x.length;i++){
            System.out.print(  x[i] +"\t" );
        }
    }
}
