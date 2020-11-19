package com.ycinfo.oop1;

public class Vip {
    private String name;
    private String pwd;
    private int k;

    Vip(){
        System.out.println("无参构造方法");
        name="";
        pwd="";
        k=3;
    }

    Vip(   String n, String p ){
        name=n;
        pwd=p;
        k=3;
    }

    Vip(String n,String p, int key){
        name=n;
        pwd=p;
        k=key;
    }


    //getter setter
    // getter命名规范
    public String getName(){
        //加入业务逻辑
        //    安全逻辑: 用户以   姓+
        String firstname=name.substring(0,1);
        String secondname="";
        for(int i=0;i<name.length()-1;i++){
            secondname+="*";
        }
        return firstname+secondname;
    }

    public String getPwd(){  //   熵  H=nlogX
        String p="";
        for(int i=0;i<pwd.length();i++){
            //取出pwd中的每个字符
            char ch=pwd.charAt(i);
            //判断每个字符是否在   'a'->'z'及  'A'  'Z'范围
            if(   ch>='a' && ch<='z'){
                ch+=k%26;
                if(    ch<'a' ){
                    ch+=26;
                }else if(  ch>'z'){
                    ch-=26;
                }
            }else if(   ch>='A' && ch <='Z' ){
                ch+=k%26;
                if(   ch<'A'){
                    ch+=26;
                }else if(  ch>'Z'){
                    ch-=26;
                }
            }
            p+=ch;
               //如在，则加密    判断范围  算法
               //   拼接到 p
        }
        return p;
    }

    //    3
    //   h-> k
    //   e-> h
    //   l -> o
    //   l -> o
    //   o-> r
    //  khoor





}
