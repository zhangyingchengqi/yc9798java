package com.ycinfo.oop1;

/*
写一个类Person,包含以下属性：
      String name;
      int age;
      boolean  gender;
      Person partner。
   为Person类写一个marry(Person  p)方法，代表当前对象和p结婚，如若可以结婚，则输出恭贺信息，
否则输出不能结婚原因。要求在另外一个类中写一个主方法，来测试以上程序。
（下列情况不能结婚：1，同性； 2，未达到结婚年龄，男<24，女<22；3，某一方已婚）

提示: 注意 this 的用法
 */
public class Person {
   private  String name;
    private int age;
    private boolean  gender;

    private Person partner;   // null

    public Person(String name, int age, boolean gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public void divorce(  Person p   ){
        //1. 不与null离婚
        if(  p==null ){
            System.out.println("必须指定离婚对象");
            //  return      throw new RuntimeException();
            return ;
        }
        //2. 不能与自己离婚
        if(  this==p ){
            System.out.println("不能与自己离婚");
            return ;
        }
        //3. 互相之间是partner
        if(this.partner!=p  ||   p.partner!=this ){
            System.out.println("两人不是夫妻关系，不能离婚");
            return;
        }
        //4. 离婚 ,将 partner
        this.partner=null;
        p.partner=null;
        //5. 打印成功
        System.out.println( this.name+"与"+p.name+"结束婚姻关系，且行且珍惜...");
    }

    public void marry(  Person p ){
        if(  p==null ){
           System.out.println("不能骗婚,");
           //  return      throw new RuntimeException();
            return ;
        }
        //自已与自己结婚
        if(  this==p ){
            System.out.println(this.name+"，你不能太自恋,....考虑一下别人的感受...");
            return;
        }
        if(    this.gender== p.gender  ){
            System.out.println(   this.name+"和"+p.name+"不能结婚,同性不能成婚，你可以考虑荷兰..." );
            return ;
        }
        if(this.partner!=null){
            System.out.println( this.name+",你个大骗子,你已婚");
            return;
        }
        if( p.partner!=null){
            System.out.println( p.name+",你个大骗子,你已婚");
            return;
        }
        if(   isAgeAndSexOk(  this.gender, this.age )==false ){
            System.out.println(this.name+"不能结婚, 你的性别为:"+ (this.gender?"男":"女"    )+   ",年龄为"+ this.age ) ;
            return;
        }
        if(   isAgeAndSexOk(  p.gender, p.age )==false ){
            System.out.println(p.name+"不能结婚, 你的性别为:"+ (p.gender?"男":"女"    )+   ",年龄为"+ p.age ) ;
            return;
        }
        this.partner=p;
        p.partner=this;
        System.out.println(this.name+"与"+p.name+"喜结良元");
    }
   //算法
    private boolean isAgeAndSexOk(   boolean sex, int age ){
        if(  sex==true&& age<24){
            return false;
        }else if(   sex==false&& age<22){
            return false;
        }else{
            return true;
        }
    }

    public static void main(String[] args) {
        Person me=new Person("王思聪",28, true);
        Person fengjie=new Person(   "凤姐",29,false);
        Person furongsister=new Person("芙蓉姐姐",34, false);

        Person p=new Person(   "林更新", 28, true);
        //me.marry(p);

        me.marry(fengjie);
        furongsister.marry(  me );

        me.divorce( fengjie);

        furongsister.marry(me );



    }
}
