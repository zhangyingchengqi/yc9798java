package com.ycinfo;

//不安全的银行查找

public class Test13 {
    public static void main(String[] args) {
        //1. 银行数:
        int n=5;
        //2. 安全线
        double limit=201;
        //3. 每家银行的现金
        double[] balances=new double[]{ 25,125,175,75,181};
        //4. 存每家银行借出的钕
        double[][] load=new double[][]{
                {0, 100.5, 0, 0, 320.5},
                {0,  0,    40,85, 0},
                {125,0,    0, 75, 0},
                {125,0,    0,  0, 0},
                {0,  0,    125, 0, 0},
                                };
        //存每家银行计算的净资产
        double[] assets=new double[n];
        //存每家银行是否安全的结果
        boolean [] isSafe=new boolean[n];
        //默认都为安全,毕竟不安全的银行少
        for( int i=0;i<isSafe.length;i++){
            isSafe[i]=true;
        }
        System.out.println("不安全的银行有:");

        boolean hasUnSafeBank=true;
        while( hasUnSafeBank ) {
            hasUnSafeBank=false;
            //循环所有的银行
            for (int i = 0; i < n; i++) {
                assets[i] = balances[i];
                //再加对应load中借出的钱
                for (int j = 0; j < n; j++) {
                    assets[i] += load[i][j];
                }
                //System.out.println("第" + i + "家银行的总资产为:" + assets[i]);
                //判断 第i家银行是否低于limit
                if (  isSafe[i] &&    assets[i] < limit) {   //  加一个判断 ，以 对新的不安全的银行.
                    // 原来第i家银行是安全的，但经过计算后它的  assetes已经不安全了 ,这种银行才要进行操作.
                    hasUnSafeBank=true;
                    isSafe[i] = false;
                    System.out.println("第" + i + "家银行不安全...");
                    //所以要将这个银行借入的钱归为0
                    for (int k = 0; k < n; k++) {
                        load[k][i] = 0;
                    }

                }
            }
        }


        System.out.println(  "hello");


    }
}
