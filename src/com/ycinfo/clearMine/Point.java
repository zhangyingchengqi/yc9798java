package com.ycinfo.clearMine;

/*
 1、分析得：
    a、在每一个坐标上，有3种状态， 没开， 打开， 插旗   00表示没开, 01表示打开, 10表示 插旗
    b、坐标上有雷还是没雷 ,有2种状态   0表示没有  1表示有
    c、没有,有9个状态, 0000表示附近雷没有, 0001表示附近1个雷 ...  1000表示 附近8个雷
 */
public class Point {
    private int x; // 表示行
    private int y; // 表示列
    private int state; // 状态 0b1111(表示附近雷的个数)11(坐标的开启状态)1(表示是否有雷)

    public Point() {
    }

    public Point(int x, int y, int state) {
        super();
        this.x = x;
        this.y = y;
        this.state = state;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Point other = (Point) obj;
        if (x != other.x) {
            return false;
        }
        if (y != other.y) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                ", state=" + state +
                '}';
    }
}

