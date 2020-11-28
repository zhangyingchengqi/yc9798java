package com.ycinfo.sortStudent;

public class Student {
    private String sname;
    private int c;
    private int java;

    /**
     * 排序的业务
     * @return
     */
    public   int   compareTo(  Student other  ){
        int thisTotal=this.c+this.java;
        int otherTotal= other.c+other.java;
//        return thisTotal-otherTotal;
       // return this.c-other.c;
        if(     thisTotal==otherTotal  ){
            if(  this.c==other.c ){
                return this.java-other.java;
            }else{
                return this.c-other.c;
            }
        }else{
            return thisTotal-otherTotal;
        }
    }

    @Override  //重写:  这是一个父类的方法，在这里被修改了..
    public String toString() {
        return "姓名:"+this.sname+"\tc:"+this.c+"\tjava:"+java+"\t总分:"+(c+java );   //输出有意义的信息
    }

    public Student(){

    }

    public Student(String sname, int c, int java) {
        this.sname = sname;
        this.c = c;
        this.java = java;
    }

    public String getSname() {
        return sname;
    }

    public int getC() {
        return c;
    }

    public int getJava() {
        return java;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public void setC(int c) {
        this.c = c;
    }

    public void setJava(int java) {
        this.java = java;
    }
}
