package com.ycinfo;

public class Step {
    private Point p1;
    private Point p2;
    private int value;

    public Step(Point p1, Point p2, int value) {
        this.p1 = p1;
        this.p2 = p2;
        this.value = value;
    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    public int getValue() {
        return value;
    }
}
