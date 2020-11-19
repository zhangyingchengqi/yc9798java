package com.ycinfo.oop1;

/*
实现一个Student类。学生应有姓名和总分。
提供一个适当的构造方法以及getName(), addQuiz(int score), getTotalScore()和getAverageScore()方法。
为了计算后者，需要存储学生所参加的测验数.

 */
public class Student98 {
    private String name;   //全局
    private int totalScore;
    private int num;  //几门课程

    Student98( String name ){   //局部变量
        //this是一个地址，这个地址是指向对象自身的引用
        //System.out.println(  this );
        this.name=name;   //在作用域中，当局部变量与全局变量同名时，优先局部变量
    }

    public String info(){
        return "姓名:"+name+"\t总成绩:"+ totalScore+"\t科目数:"+num+"\t平均分:"+getAverageScore();
    }

    public int getNum(){
        return num;
    }

    public String getName(){
        return this.name;
    }

    //添加成绩:有可能调用多次
    public void addQuiz(int score){
        num++;
        totalScore+=score;
    }

    public int getTotalScore(){
        return this.totalScore;
    }

    public int getAverageScore(){
        if(  num<=0){
             throw new RuntimeException("暂无成绩记录");
        }
        return this.totalScore/num;
    }






}
