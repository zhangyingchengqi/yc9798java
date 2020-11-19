package com.ycinfo;

import java.util.Random;
import java.util.Scanner;

public class Test11 {
    //全局变量: 存所有的牌
    static int[] cards;   //数组的声明      =null ;
    static int length;    //这个表示当前数组的有效长度

    public static void main(String[] args) {
//        System.out.println(     genCardId(52)  );
//        System.out.println(     genFollower(52)  );
//        System.out.println(     getInfo(14)  );
        Scanner sc=new Scanner(System.in);
        int n=1;
        do {
            System.out.println("游戏开始,请输入有几副牌(>=1):");
             n = sc.nextInt();
        }while(   n<1 );
        init(   n );   //初始化牌

        System.out.println("请输入要抽取几张牌:");
        int num=sc.nextInt();
        for(   int i=0;i<num;i++){
            String info=randomCard(   );
            System.out.println("您抽取了:"+   info+",还有"+  length+"张" );
        }
    }

    static String randomCard(){
        // 1. 当前牌的有效长度
        //2. 用这个长度作范围，随机取一个值 ,即下标     r.nextInt(     length   )
        Random r=new Random();
        int index=r.nextInt(   length   );
        // 3. 取出这个值
        int card=   cards[index];
        System.out.println("抽取了数字:"+ card);
        // 4. 交换， 将这个下标与   length-1所在的值 交换
        int temp=cards[length-1];
        cards[length-1]= cards[index];
        cards[index]=temp;
        // 5.   length--
        length--;
        // 4. 将这个值 转成牌号   return
        return getInfo(  card );
    }

    static void init(  int n ){
        cards=new int[   52*n    ];        // cards 每个元素是  0
        //初始化自己的值
        for(  int i=0;i< cards.length; i++   ){
            cards[i]=i;
        }
        length=    cards.length;
    }


    /** 根据一个数字，得到牌的信息,组合调用 genFollower, genCardId */
    static String getInfo(  int x   ){
        String flower=genFollower( x );
        String cardId=genCardId(x);
        return flower+cardId;
    }


    /**
     * 根据一个数字，得到它对应的花色，注意考虑多副牌.
     */
    static String genFollower(   int x ){
        //字符串数组     类型[]  数组名=new 类型[]{xxx}
        String[] flowers=new String[]{"方块", "梅花","红桃", "黑桃"};
        //  x/13->   花色    52/13%4-> 0   下标
        int index=x/13%4;
        return flowers[index];
    }


    /**
     * 根据一个数字,求牌号  (  A,2,3,4,5.... 10, J,Q,K )  ->  String
     */
    static String genCardId(  int x){
        // 算法:  x%13->   牌号   (1,2,3....10,J,Q,K)
        int r=x%13;
        switch( r  ){
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return r+1+"";
            case 0:
                return "A";
            case 10:
                return "J";
            case 11:
                return "Q";
            case 12:
                return "K";
            default:
                return "";
        }
    }

}
