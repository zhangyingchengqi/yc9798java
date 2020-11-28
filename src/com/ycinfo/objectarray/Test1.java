package com.ycinfo.objectarray;


public class Test1 {
    public static void main(String[] args) {
        //类型[] 数组名=new 类型[长度];

        //  java数据类型:
        //      1. 基本类型:   boolean  byte  short int char long float double
                         //栈
        //      2. 引用类型:   String , Scanner, Random  Object   数组
                         //    栈  ->   堆

        Address a1=new Address("湖南省","衡阳市");
        Address a2=new Address("湖南省","长沙市");

        Product [] ps=new Product[100];
        for( int i=0;i<ps.length;i++){
            if(   i%2==0) {
                ps[i] = new Product(i + 1, "产品" + i, 100 + i,  a2 );
            }else{
                ps[i]=new Product( i+1, "产品"+i, 100+i, a1);
            }
        }

        for(   int i=0;i<ps.length;i++  ){
             Product p= ps[i];
             System.out.println(   p );    //    p.toString9);
        }
    }
}

class Address{
    private String province;
    private String city;

    @Override
    public String toString() {
        return "Address{" +
                "province='" + province + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public Address() {
    }

    public Address(String province, String city) {
        this.province = province;
        this.city = city;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }
}

class Product{
    private int id;
    private String name;
    private double price;

    private Address address;   // 对象类型

    public void show(){
        System.out.printf(  "产品名:%s\t价格:%10.2f\t省:%s\t市:%s\n"   ,    name,price,address.getProvince(), address.getCity()   );
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", address=" + address +
                '}';
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }


    public Product() {

    }

    public Product(int id, String name, double price, Address address) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.address=address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
