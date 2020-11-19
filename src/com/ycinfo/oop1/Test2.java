package com.ycinfo.oop1;

import javax.swing.*;
import java.math.BigDecimal;

public class Test2 {
    public static void main(String[] args) {

        Product p=new Product();
        //p.name="肾12";
        //p.price=1024.0001;
        //p.num=1.5;     //    1536.00015

        JOptionPane.showMessageDialog( null,  p.smallCount() );
        System.out.println(p.name+"小计:"+ p.smallCount() );


        //p.price2=new BigDecimal(   "1024.0001"  );
        //p.num2=new BigDecimal( "1.5" );
        System.out.println(  p.name+"小计:"+ p.smallCount2()   );


        ////////////////////////////////////////////////
        Product p2=new Product(   "苹果",10,4  );
        System.out.println(   p2.name+"\t"+ p2.smallCount() );
       System.out.println(  p2.name+"\t"+p2.smallCount2() );

        Product p3=new Product("mac book pro", new BigDecimal("20000"),new BigDecimal("2"));
        System.out.println(   p3.name+"\t"+p3.smallCount() );
        System.out.println(  p3.name+"\t"+p3.smallCount2());
    }
}
