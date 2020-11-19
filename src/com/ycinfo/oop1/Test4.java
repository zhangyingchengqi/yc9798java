package com.ycinfo.oop1;

public class Test4 {
    public static void main(String[] args) {
        Student98 s=new Student98("张三丰");
        s.addQuiz(150);
        s.addQuiz(120);
        s.addQuiz(100);

        //System.out.println(  s.getName()+"\t"+s.getTotalScore()+"\t"+s.getNum()+"\t"+s.getAverageScore() );

        System.out.println(  s.info()  );


    }
}
