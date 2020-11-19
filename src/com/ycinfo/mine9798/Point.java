package com.ycinfo.mine9798;

/*
  棋盘中的一个点
 */
public class Point {
    private int x;
    private int y;
   // private int mineCount;  //  0-8       0000  -  1000
   // private int status;     //  3种状态     2个bit    0未打开, 01插旗,  10打开
  //  private boolean isMine;   // 2种状态    1 个bit    1是雷  0不是雷

                         //     雷数(0-8)      状态   是否为雷
    private int state;   //   0b0000    00    0
                        //   0b0000000

    //toString
    @Override    //这是一个注解，表示这个方法是重写了父类的方法
    public String toString() {
        return "当前这个点的信息:"+x+","+y+","+state+ "\t"+  Integer.toBinaryString( state )  +"\n";
    }

    public Point() {

    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(int x, int y, int state) {
        this.x = x;
        this.y = y;
        this.state = state;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getState() {
        return state;
    }
}
