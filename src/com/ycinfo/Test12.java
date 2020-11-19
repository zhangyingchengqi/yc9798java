package com.ycinfo;

import com.ycinfo.datatype.YcStack2;

import java.util.Random;
import java.util.Scanner;

//连连看
public class Test12 {
    static int[][] board;   //声明    //全局
    static int rows;  //行
    static int cols;  //列


    public static void main(String[] args) {
        YcStack2 stack=new YcStack2();

        Scanner sc=new Scanner(System.in);
        System.out.println("=======欢迎进入腾迅游戏世界==========");
        System.out.println("请输入行数:");
        rows= sc.nextInt();
        do{
            System.out.println("请输入列数( 必须是大于2的偶数):");
            cols=sc.nextInt();
        }while(  cols<=2 ||   cols%2!=0 );

        board=new int[rows][cols];   //数组的初始化    全是0

        System.out.println("请输入难度级别:");
        int diff=sc.nextInt();

        init(   diff );
        shuffle();   //打乱棋盘.

        showBoard();

        // for   while   do...while
        boolean flag=true;
        do{
            System.out.println("\n请输入要消除的两个点的下标(0 0 0 0):");

            Point p1=new Point();
            p1.x=sc.nextInt();
            p1.y=sc.nextInt();

            Point p2=new Point();
            p2.x=sc.nextInt();
            p2.y=sc.nextInt();
            //判断是否要消除
            if(   isEraseOk(  p1, p2 )   ){
                Point pa=new Point();
                pa.x=p1.x;
                pa.y=p1.y;

                Point pb=new Point();
                pb.x=p2.x;
                pb.y=p2.y;

                Step s=new Step(   pa,pb,   board[p1.x][p1.y]     );   //创建消除的这一步
                //将这个存到   YcStack.
                stack.push(   s );

                //消除就是将p1,p2在board中的位置的值改为0
                board[p1.x][p1.y]=board[p2.x][p2.y]=0;




                showBoard();
                if(   isGameOver() ){
                    flag=false;
                }


                System.out.println("\n请问您要悔棋吗?");
                sc.nextLine();
                String choice=sc.nextLine();
                if(  choice.equals("y") ){
                    //   step= (step)     object
                    while(  stack.size()>0) {
                        Step step = (Step) stack.pop();   // int a=(int)3.14;
                        board[step.getP1().x][step.getP1().y] = board[step.getP2().x][step.getP2().y] = step.getValue();

                        System.out.println(" 悔棋成功");
                        showBoard();
                    }
                }


            }

        }while(   flag   );
        System.out.println("游戏结束....");
    }

    /**
     * 消除算法
     * @param p1
     * @param p2
     * @return
     */
    static  boolean  isEraseOk(  Point p1     ,  Point p2       ){
        if(   board[p1.x][p1.y]!= board[p2.x][p2.y] ){
            return false;
        }

        if (p1.x == p2.x && p1.y == p2.y) {
            System.out.println("自已不能对自己进行消除");
            return false;
        }

        if(   isLine(  p1, p2)  || isTwoLine(   p1,p2) || isThreeLine(p1,p2)  ){           //  || isTowLine( p1, p2)  || isThreeLine(  p1,p2)
            return true;
        }
        return false;
    }

    private static boolean isThreeLine(Point p1, Point p2) {
        //固定住p1.x,循环p1.y,   从0到  length-1,但p1.y跳过
        for(  int i=0;i<board[0].length;i++  ){
            //创建  t  点
            // if(    isLine(t,p1)&&isTwoLine(t,p2) && board[t.x][t.y]==0 )
            Point t=new Point();
            t.x=p1.x;
            t.y=i;
            if(   isLine(p1,t) && isTwoLine(t,p2) &&  board[t.x][t.y]==0  ){
                return true;
            }
        }

        //固定住p1.y,循环p1.x,  从0到  length-1, 但p1.x跳过
        for(  int j=0;j<board.length;j++) {
            //创建  t  点
            Point t=new Point();
            t.x=j;
            t.y=p1.y;
            // if(    isLine(t,p1)&&isTwoLine(t,p2) && board[t.x][t.y]==0 )
            if(    isLine(p1,t) && isTwoLine(t,p2) && board[t.x][t.y]==0 ){
                return true;
            }
        }
        return false;
    }

    private static boolean isTwoLine(Point p1, Point p2) {
        //构造一个点   temp(p1.x,p2.y)
        Point temp=new Point();
        temp.x=p1.x;
        temp.y=p2.y;
            //判断    if(   isLine(p1,temp) && isLine(temp,p2)  &&   board[temp.x][temp.y]==0 )
        if(    isLine(p1, temp)   &&  isLine(temp,p2)  &&  board[temp.x][temp.y]==0  ){
            return true;
        }
        //再构造另一个点  temp(p2.x,p1.y)
        //  判断    if(   isLine(p1,temp) && isLine(temp,p2)  &&   board[temp.x][temp.y]==0 )
        temp.x=p2.x;
        temp.y=p1.y;
        if(    isLine(p1, temp)   &&  isLine(temp,p2)  &&  board[temp.x][temp.y]==0  ){
            return true;
        }
        return false;
    }

    static   boolean  isLine(  Point p1  , Point p2  ){
        if(   p1.x==p2.x){  //同一行，循环列
            int min=    p1.y>p2.y?p2.y: p1.y;
            int max=   p1.y>p2.y?p1.y:p2.y;
            for(  int i=min+1;  i< max;i++){
                if(   board[p1.x][i]!=0    ){
                    return false;
                }
            }
            return true;
        }else if(  p1.y==p2.y  ){  //同一列，循环行
            int min=   p1.x>p2.x?p2.x:p1.x;
            int max=   p1.x>p2.x?p1.x:p2.x;
            for( int i=min+1; i<max; i++){
                if(  board[i][p1.y]!=0){
                    return false;
                }
            }
            return true;
        }
        //表示一线不能消除
        return false;
    }

    /**
     * 循环判断 board中的每个元素，看是否都为0,如果，则返回true, 否则返回false
     * @return
     */
    static  boolean   isGameOver(){
        //循环board,判断 是否有一个元素的值不为0,返回false
        for(  int i=1;i<board.length-1;i++){
            for(int j=1;j<board[i].length-1;j++){
                if(   board[i][j]!=0 ){
                    return false;
                }
            }
        }
        return true;
    }




    //对  board 这个二维数组中的   元素初始化值
     static void init(int diff) {
        Random r=new Random();
        //循环二维数组，   第0, length-1行不参与，  第0列与, board[i].length-1列不参与
        for( int i=1;i<board.length-1;i++){
            for( int j=1;j<board[i].length-1;j+=2){    //   因为一次对相邻的两个元素赋值 ，所以要+2
               int pic= r.nextInt(   diff    )+1;
               board[i][j]=board[i][j+1]=pic;
            }
        }
        //   随机生成图片    r.nextInt(   diff )+1
        //    将生成的图片号存到相邻的两个元素.
    }

    //打乱棋盘
    static void shuffle(){
        //打乱时注意,  0与length-1不能生成
        Random r=new Random();
        for(  int i=0;i<rows*cols*10;i++  ) {    //  rows: 6
            //            (0-3)+1  =>   (1-4 )
            int x1 = r.nextInt(rows - 2) + 1;
            int y1 = r.nextInt(cols - 2) + 1;
            int x2 = r.nextInt(rows - 2) + 1;
            int y2 = r.nextInt(cols - 2) + 1;

            int temp = board[x1][y1];
            board[x1][y1] = board[x2][y2];
            board[x2][y2] = temp;

        }        //生成两个点， 交换值
        //打乱的次数：   rows*cols*常数
    }

    //显示棋盘
    static void showBoard(){
        //第一行的列号
        for(   int i=0;i<board[0].length-1;i++){
            if(   i==0){
                System.out.print("\t");
                continue;  //跳过此轮循环，执行  i++
            }
            System.out.print(  i +"\t" );

        }
        System.out.println();
        //棋盘的输出
        for(int i=0;i<board.length;i++){
            for( int j=0;j<board[i].length;j++){
                if(   j==0 ){   //边界第一列
                    if(  i==0 || i==board.length-1  ){
                        System.out.print(" *\t");     //第一行和最后一行不要行号
                    }else {
                        System.out.print(i + "*\t");    //中间的行要行号
                    }
                }else if(   j==board[i].length-1 ){   //边界的最后一列
                    if( i==0 || i==board.length-1){
                        System.out.print("*");
                    }else {
                        System.out.print("*" + i);
                    }
                }else if(  i==0|| i==board.length-1  ){   //边界行( 第一行和最后一行 )
                    System.out.print("***\t");
                }else if(   board[i][j]==0 ){    // 棋盘中间的有效数据部分如果是0,表示已经消掉的图片，
                    System.out.print("\t");
                } else {
                    System.out.print(board[i][j] + "\t");    //是正常的图片，显示 即可.
                }
            }
            System.out.println();
        }
        //最后一行的列号
        for(   int i=0;i<board[0].length-1;i++){
            if(   i==0){
                System.out.print("\t");
                continue;  //跳过此轮循环，执行  i++
            }
            System.out.print(  i +"\t" );

        }

    }

}

//定义类来代表一个点的x,y
//相当于c中的结构体
class Point{
    int x;
    int y;
}
