package com.ycinfo.datatype;

/*
写一个类用来模拟栈这种数据结构，要求底层使用数组存储数据，并给出相应的 进栈和出栈的方法。
  后进先出
      void push(   int x );
      int pop();
      int peek();
      int size();
      void clear();
      boolean isEmpty()
 */
public class YcStack2 {
    private Object [] data;
    private int length;

    public YcStack2(){
        data=new Object[10];
        length=0;
    }

    public YcStack2(int initSize  ){
        data=new Object[initSize];
        length=0;
    }

    public boolean isEmpty(){
        return length<=0?true:false;
    }

    public void clear(){
        length=0;
    }

    public int size(){
        return length;
    }

    public Object  peek(){
        if( length<=0 ){
            throw new RuntimeException("此是空栈");
        }
        Object result=data[length-1];
        return result;
    }

    // length=0    length-1
    // length=5   length-1
    public Object pop(){
        if( length<=0 ){
            throw new RuntimeException("此是空栈");
        }
       Object result=data[length-1];
       length--;
       return result;
    }

    public void push(   Object x ){
        if(  length==data.length){
            expand();
        }
        // 存到data下标为length的位置
        data[length]=x;
        //length++
        length++;
    }

    private void expand(   ){
        //1. 新建一个数组，长度是原数组的  1.5倍
        Object [] newdata=new Object[  (int)(data.length*1.5)  ];    // (int)(data.length*1.5)   因为数组长度是 int  ,  data.length*1.5是double
        //2. 将原数组的数据复制到新数组中
        //         1) System.arrayCopy()
        System.arraycopy(  data,0,newdata,0, data.length );
        //         2) 自己写循环实现
        //3. 将  newdata赋值 给data
        data=newdata;
        //4. 垃圾回收  System.gc()
        System.gc();
    }

    public static void main(String[] args) {
        YcStack2 s=new YcStack2();
        for( int i=0;i<15;i++) {
            s.push(i+1);
        }

        System.out.println(   s.peek() );   //  15
        for( int i=0;i<20;i++){
            System.out.println("出栈"+s.pop() );
        }



    }

}
