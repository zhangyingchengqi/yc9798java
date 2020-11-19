package com.ycinfo.oop1;

/*
实现一个具有以下特性的Car类。一辆汽车有一定的燃油效率(测量单位可以是升/千米)并且油箱中有一定的油量。
效率在构造函数中确定，初始油量为0.提供一个drive()方法模拟汽车行驶一定的距离并减少油箱油量。
再提供一个返回当前油量的getGas方法和一个用于加油的addGas方法。用法示例如下:
           Car myHybrid=new Car(0.6);
		   myHybrid.addGas(20);
		   myHybrid.drive(100);
		  System.out.println(myHybrid.getGas());
 */
public class Car{
    private double rate;       // 0.007   燃油效率
    private final double volume=50.0;      //油箱的总容量
    private double gas;      //  剩余的油量

    Car( double newrate){
        this.rate=newrate;
    }

    public void addGas( int newgas){
        if(  newgas+gas<=volume   ){
            gas=gas+newgas;
        }else{
            gas=volume;
        }
    }

    public double getGas(){
        return gas;
    }

    public void drive(    int kilos   ){
        for(  int i=0;i<kilos;i++ ){
            gas=gas-rate;
            if(  gas<=0 ){
                System.out.println("game over");
                break;
            }
            if(   gas<=2){
                // printf   print format 格式化输出        %1$5.2f
                System.err.printf( "油量不足.....当前剩余油量为:%1$-10.2f升\n" ,gas );

            }

        }
    }

    public static void main(String[] args){
        Car c=new Car( 0.07);
        c.addGas( 80);
        System.out.println("加完油后的油量:"+   c.getGas() );
        c.drive( 30000 );


    }

}
