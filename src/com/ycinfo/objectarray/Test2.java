package com.ycinfo.objectarray;

import java.util.Random;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Address a1=new Address("湖南省","衡阳市");
        Address a2=new Address("江西省","长沙市");
       Cangku ck=new Cangku();
       Random r=new Random();
       for( int i=0;i<100;i++){
           Product p=null;
           if(   i%2==0) {
               p= new Product(i + 1, "产品" + i, 100 + i,  a2 );
           }else{
              p=new Product( i+1, "产品"+i, 100+i, a1);
           }
           ck.ruKu(  p );
       }
       System.out.println("请输入要查找的产品名:");
       Scanner sc=new Scanner( System.in  );
       String name=sc.nextLine();
       int [] indexes= ck.findByName(   name);
       for( int i=0;i<indexes.length;i++){
           if(   indexes[i]==-1){
               break;
           }
           Product p=ck.findByIndex(    indexes[i]  );
           p.show();
       }

        System.out.println("请输入要查找的产品名的产地(省):");
        String province=sc.nextLine();
         indexes= ck.find(   province);
        for( int i=0;i<indexes.length;i++){
            if(   indexes[i]==-1){
                break;
            }
            Product p=ck.findByIndex(    indexes[i]  );
            p.show();
        }
    }
}

class Cangku {
    private Product[] data = new Product[1000];  //数组
    private int length;   //真实存的数据量


    public void ruKu(Product x) {
        if(   length>=data.length ){
            throw new RuntimeException("仓库已满....");
        }
        data[length] = x;
        //length++
        length++;
    }

    //    [0,1,2,3,4,-1]
    public int[] find(String province) {
        int[] result = new int[length];    //代表下标  [0,1,2,3,4,-1]
        //循环初始化 result, 值 为  -1
        for(  int i=0;i<result.length;i++  ){
            result[i]=-1;
        }
        //循环 data, 查找省名,存索引到  result
        int j=0;
        for(   int i=0;i<length;i++){
            Product p=data[i];
            if(    province.equals( p.getAddress().getProvince() ) ){
                result[j]=i;
                j++;
            }
        }
        return result;
    }

    //    [0,1,2,3,4,-1]
    public int[] findByName(String pname) {
        int[] result = new int[length];    //代表下标  [0,1,2,3,4,-1]
        //循环初始化 result, 值 为  -1
        for(  int i=0;i<result.length;i++  ){
            result[i]=-1;
        }
        //循环 data, 查找省名,存索引到  result
        int j=0;
        for(   int i=0;i<length;i++){
            Product p=data[i];
            if(    pname.equals( p.getName() ) ){
                result[j]=i;
                j++;
            }
        }
        return result;
    }

    public Product findByIndex(int index) {
        if(   index<0 || index>=length){
            throw new RuntimeException("没有这个索引");
        }
        return data[index];
    }
}
