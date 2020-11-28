package com.ycinfo.oop3_extends;

public class Test3 {
}

class A
{
     int day;
    private int month;
    public String getDate()
    {
        return day+"/"+month;
    }

}


class B
{
    public static void main(String[] args)
    {
        A test=new A();
        test.day=25;
        System.out.println(test.getDate());

    }
}

