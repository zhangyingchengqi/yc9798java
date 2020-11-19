package com.ycinfo.mine9798;

public class Main {
    public static void main(String[] args) {
        //    这个点周围有8个雷，没有打开，自己不是一个雷
        //Point p=new Point(2,1, 0b1000000);
       // Point p=new Point( 2,1, 0b0000011);
       // System.out.println(     p );   //自动调用  toString

        MineMap mm=new MineMap( 9,9,10    );
        System.out.println(   mm );
        Point[][] board= mm.initBoard();

        for( int i=0;i<board.length;i++){
            for( int j=0;j<board[i].length;j++){
                Point p= board[i][j];
                System.out.println(   p   );   //  p.toString();
            }
        }


    }
}
