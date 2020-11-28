package com.ycinfo.mine9798;

import com.ycinfo.datatype.YcStack2;

import java.util.Scanner;

public class MineController {
    private MineMap map;   //棋盘类
    private int pointCount;   //棋盘中的没有打开的点的数量, 在程序 运行中去 --, 当pointCount为0时，游戏结束
    /// .....记录游戏速度，时间，bgsound,......
    private Point[][] minePoint;
    private Scanner sc=new Scanner(System.in);

    // 暂时不是必须
    private YcStack2 stack=new YcStack2();

    //游戏的开始
    public void startGame(          ){
        //游戏难度选择....
        System.out.println("\t\t\t扫雷世界\n");
        int choice=1;
        do {
            System.out.println("请选择游戏的级别(1. easy 2. normal  3.hard):");
            choice = sc.nextInt();   //    1 回车
            sc.nextLine();
            switch(choice){
                case 1:  map=new MineMap(  6,6,10 ); break;
                case 2: map=new MineMap(  9,9,25 ); break;
                case 3: map=new MineMap(  12,12,50 ); break;
                default: System.out.println("没有此游戏级别....");
            }
        }while(  choice<=0||choice>3);
        //初始化棋盘
        minePoint=map.initBoard();   //到这里，棋盘已经创建好，且埋好了雷
        //作bi效果.
        System.out.println("是否开启无敌模式?(y或n):");
        String ch=sc.nextLine();
        if(  ch.equals("y")){
            // 将棋盘中状态码的值修改为打开   状态码改为  0bxxxx10x
           for( int i=0;i<minePoint.length;i++){
               for(int j=0;j<minePoint[i].length;j++){
                   //  0bxxxx00y   |   0b100
                   minePoint[i][j].setState(    minePoint[i][j].getState()   |   0b100          );
               }
           }
        }
        //显示一下棋盘
        showBoard( minePoint  );
        //自动取消无敌: 将 0bxxxxYYz    中间YY 变为  00
        for( int i=0;i<minePoint.length;i++){
            for(int j=0;j<minePoint[i].length;j++){
                //  0bxxxx00y   |   0b100
                //  0bxxxxYYz   &  0b1111001     ->   0bxxxx00z
                minePoint[i][j].setState(    minePoint[i][j].getState()  & 0b1111001       );
            }
        }
        boolean flag=true;
        boolean isGameOver=false;   //判断 游戏是否完成
        do {
            showBoard(minePoint);
            System.out.println("请输入坐标:");
            int x=sc.nextInt();
            int y=sc.nextInt();
            //通过坐标x,y查找到minePoint中的点
            Point p=minePoint[x][y];
            //你要对这个点选择操作
            System.out.println("请选择操作(1、打开, 2、插旗, 3、拔旗)：");
            int op=sc.nextInt();
            switch(op){
                case 1:
                    //打开
                    isGameOver=open(  p  );
                    break;
                case 2:
                    //插旗
                    insertFlag(   p );
                    break;
                case 3:
                    //拔旗
                    removeFlag(  p );
                    break;

            }
            if(   isGameOver){
                flag=false;
            }
        }while(   flag  );
        System.out.println("游戏结束");
    }

   //棋盘的显示
    public void showBoard(   Point[][] board){
        int rows=board.length;
        int cols=board[0].length;
        System.out.println();
        //先输出第一行的列号
        for(int i=0;i<cols;i++){
            if(   i==0 ){
                System.out.print("  ");
            }
            System.out.print(   i +" "  );
        }
        System.out.println();
        //输出这个棋盘
        for(int i=0;i<rows;i++){
            //输出行号
            System.out.print(   i+"*"  );
            for( int j=0;j<cols;j++){
                //   N:        state:  0bxxxx00x    &    0b0000110    =>    == 0b0
                if(  ( board[i][j].getState()  & 0b110) ==0b0     ){   //  取出状态位且为  0, 表示没有打开
                    System.out.print(   "N " );
                }else if(    ( board[i][j].getState()  & 0b110) ==0b10     ) {  // 这个点插了旗    0bxxxx01x
                    //  F :        state:  0bxxxx01x
                    System.out.print(  "F ");
                }else{
                   //这个点是一个雷，且打开(    游戏玩定远后显示 整 个棋盘，或是作弊  ）
                    //   0bxxxxxx0  或是  0bxxxxxx1
                   if(   (board[i][j].getState()  & 0b1 ) ==0b1    ){
                       System.out.print("M ");
                   }else{
                       // 这个点是打开的，但不是雷，也不插旗， 只能显示 当前的雷数
                       //  0bxxxxyyy  ->  右移 3位    0bxxxx
                       System.out.print(      ( board[i][j].getState()>>3)  +" "  );
                   }
                }
                //System.out.print(    board[i][j].getState()  +" " );
            }
            //输出行号
            System.out.print("*"+i+"\n");
        }
        //最输出最后一行的列号
        for(int i=0;i<cols;i++){
            if(   i==0 ){
                System.out.print("  ");
            }
            System.out.print(   i +" "  );
        }
        System.out.println();


    }

    //逻辑控制方法.....
    //1. 插棋    point  state  0bxxxx01x
    public void insertFlag(  Point point){
        int state=point.getState();   //取出这个点的state
        // 如已经打开，则不能插旗
        //将state的其它位设为0, 留中间的两位，   ==0b100
        if(   ( state&0b0000110 )==  0b100  ){
            System.out.println("当前点已经打开，不能插旗...");
            return;
        }
        //如当前的点已经插旗，则不能重复插旗
        // 插旗h:  0bxxxx01z
        if(    (state&0b110) ==0b10  ){
            System.out.println("当前的点已经插旗,不能重复插旗....");
            return;
        }
        //设置为  0bxxxx01z
        minePoint[point.getX()][point.getY()].setState(    point.getState() +0b10     );
    }

    //2. 拔棋     point  state    即将 0bxxxx01y改为  0bxxxx00y
    public void removeFlag(  Point point){
        int state=point.getState();
        //已经插了旗
        if(  (state&0b110)==0b010 ){   //
            minePoint[point.getX()][point.getY()].setState(    point.getState() & 0b1111001    );
        }else {
            System.out.println("此点上没有插旗，不能拔棋");
            // 将当前的点上的旗, 将状态值从  0b01x 设为   0b00x
        }
    }

    //3. 打开     point  state 0bxxxx10x
    public boolean open(  Point point){
        //取出state
        int state=point.getState();
        //   判断 是否有雷
        if(   (state&0b1)==0b1){
            //         有，则game over,   return true
            System.out.println("炸雷.....\7\7\7");
            for( int i=0;i<minePoint.length;i++){
                for(int j=0;j<minePoint[i].length;j++){
                    //  0bxxxx00y   |   0b100
                    minePoint[i][j].setState(    minePoint[i][j].getState()   |   0b100          );
                }
            }
            showBoard(minePoint);
            return true;
        }
        openOthers(  point );
        if(   pointCount==map.getMineCount() ){   //pointCount余下的点  的数量== 雷的数量，则游戏正常结束.
            System.out.println("游戏正常结束，祝贺你....");
            return true;
        }

        return false;
    }

    //       1。 是数字
    //       2. 是0, 还要递归打开周围所有为0,和不是雷的点
    private void openOthers(Point point) {
        int state =point.getState();
        //容错处理:   当前点是雷， 状态为0b10x(已经打开) , 0b01x(插旗) , 则这个点无效
        if(    (state&0b1)==0b1     ||    (state&0b110) ==0b100  || (state&0b110)==0b10 ){
            return;
        }
        //打开这个点: 即将这个点原状态:   0bxxxx00y     设为新状态   0bxxxx10y
        minePoint[point.getX()][point.getY()].setState(       point.getState()+0b100  );
        //待打开的点减少.
        pointCount--;
        // 是0, 还要递归打开周围所有为0,和不是雷的点
        if(   (state>>3)==0   ){
            int x=point.getX();
            int y=point.getY();
            //找上一行
            if(   x-1>=0){
                //正上方的点
                openOthers(    minePoint[ x-1][y]   );
                if(  y-1>=0 ){
                    openOthers(  minePoint[x-1][y-1]);
                }
                if(  y+1<minePoint[x-1].length ){
                    openOthers(   minePoint[x-1][y+1] );
                }
            }
            //下一行
            if(  x+1<minePoint.length ){
                openOthers(  minePoint[x+1][y] );
                if(  y-1>=0){
                    openOthers(  minePoint[x+1][y-1] );
                }
                if(  y+1<minePoint[x+1].length){
                    openOthers( minePoint[x+1][y+1]);
                }
            }
            //左一个点
            if(   y-1>=0){
                openOthers(   minePoint[x][y-1]);
            }
            //右一个右
            if(  y+1<minePoint[x].length){
                openOthers(  minePoint[x][y+1] );
            }
        }

    }


}
