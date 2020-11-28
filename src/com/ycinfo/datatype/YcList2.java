package com.ycinfo.datatype;

/*
数组: 存相同类型的数据. -> 2
         长度不可以改变.  ->  1


 写一个类用来模拟List这种数据结构，要求底层使用数组存储数据，并给出相应的存和取的方法。
    List的特点: 可以存任意长度的数据.
       void add(  int x );
       int  get(  int index );
       int size();
       void clear();
       boolean   isEmpty();
       remove(  int index );
 */
public class YcList2 {

    private Object [] data;  //数组
    private int length;   //真实存的数据量

    public YcList2(){
        data=new Object[10];
        length=0;
    }

    public YcList2(int initSize  ){
        data=new Object[initSize];
        length=0;
    }

    public Object remove(  int index ){
        if(  index<0 || index>=length ){
            throw new RuntimeException(index+"索引不合法,删除失败");
        }
        //1. 取出index位置的值
        Object result=data[index];
        //1. 从  index到length的元素向前复制
        System.arraycopy(   data, index+1, data,index, length-1-index);
        // 2. 将length--
        length--;
        //返回这个值
        return result;
    }

    public boolean   isEmpty(){
        return length<=0?true:false;
    }

    public void clear(){
        //TODO:   将 data重新设为初始长度
        length=0;
    }

    public int size(){
        return length;
    }

    public  Object  get(  int index ){
        if(  index<0 || index>=length ){
            throw new RuntimeException(index+"索引不合法");
        }
        return data[index];
    }

    public void add( int index, Object x){
        //TODO:   不要到最后才扩容， 应该留有缓冲量
        if(  length==data.length){
            expand();
        }
        System.arraycopy(   data,index, data,index+1, length-index+1);
        data[index]=x;
        length++;
    }

    public void add(  Object x ){
        // 判断 是否已经存满了，是，则扩容.
        if(  length==data.length){
            expand();
        }
                  // 1. *  阈值 .         1.5倍
        // 存到data下标为length的位置
        data[length]=x;
        //length++
        length++;
    }

    //扩容 ：  升级: 扩容比率
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
        YcList2 list=new YcList2();
        System.out.println(   list );
        for( int i=0;i<15;i++) {
            list.add(i+1);
        }
        System.out.println();

        System.out.println("list长为:"+  list.size() );

        for( int i=0;i<5;i++) {
            System.out.println(list.get(i));
        }

        list.add(  2,100 );
        System.out.println("=====");
        System.out.println("list长为:"+  list.size() );
        for( int i=0;i<5;i++) {
            System.out.println(list.get(i));
        }

//       int r= list.remove(2);
//        System.out.println("删除了:"+r);
//
//        System.out.println("删除后list长为:"+  list.size() );
//
//        for(   int i=0;i<list.size();i++){
//            System.out.println(   list.get(i) );
//        }


    }


}
