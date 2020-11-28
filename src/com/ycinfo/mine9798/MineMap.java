package com.ycinfo.mine9798;

import java.util.Random;

/**
 * 棋盘： 初始化棋盘, 埋雷
 */
public class MineMap {
    private int rows;   //行
    private int cols;   //列
    private int mineCount;  //雷数

    public Point[][] initBoard(){
        Point[][] board=new Point[rows][cols];  // null    int:0  double:0.0
        //初始化
        for( int i=0;i<rows;i++){
            for(int j=0;j<board[i].length;j++){
                //    status:  0b0000000   -> 0b0
                board[i][j]=new Point(  i,j, 0b0      );
            }
        }
        Point[][] result=burnMine(   board );  // 调用埋雷的方法完成向board中埋入 mineCount个雷的任务
        return result;
    }

    private Point[][] burnMine(Point[][] board) {
        // 循环埋mineCount个雷
        //随机生成下标.
        Random r=new Random();
        int i=0;
        while(  i<mineCount   ) {
            int x=r.nextInt(  rows );
            int y=r.nextInt(  cols );
            //判断 这个下标对应的   board 的位置是否已经是一个雷,不是才可以埋
            // 当前的state值   0bxxxxxx0   0bxxxxxx1
            //             &  0b0000001 => 0b1
            //             => 0b0         0b1
            if(     (board[x][y].getState()&0b1)==0b0   ){
                i++;    //可以埋雷
                // 埋雷即将这个  Point 的state值 的最后一位设为 1
                //  state:  0bxxxxxx0
                //        | 0b0000001 ->  0b1
                //          0bxxxxxx1
               int temp=  board[x][y].getState() | 0b1;
               board[x][y].setState(     temp         );
               //运算周围的八个点对应的雷数
                // 上三个point 的前四位+1
                if(  x-1>=0){
                    //先看上面的中间点    x-1  y
                    //   0b0000xxx      0b1000xxx
                    // + 0b0001000 ->  0b1000
                    int r1=board[x-1][y].getState()+0b1000;
                    board[x-1][y].setState(     r1   );
                    //左上角
                    if(    y-1>=0 ){
                        board[x-1][y-1].setState(   board[x-1][y-1].getState()+0b1000  );
                    }
                    //右上角
                    if(  y+1<cols ){
                        board[x-1][y+1].setState(   board[x-1][y+1].getState()+0b1000);
                    }
                }
                // 下三个point 的前四位+1
                if(  x+1<rows){
                    board[x+1][y].setState(   board[x+1][y].getState()+0b1000 );
                    if(    y-1>=0 ){
                        board[x+1][y-1].setState(   board[x+1][y-1].getState()+0b1000  );
                    }
                    if(  y+1<cols ){
                        board[x+1][y+1].setState(   board[x+1][y+1].getState()+0b1000);
                    }
                }
                //  左一个poin t 的前四位+1
                if(   y-1>=0 ){
                    board[x][y-1].setState(   board[x][y-1].getState()+0b1000);
                }
                //右一个poin t 的前四位+1
                if(   y+1<cols ){
                    board[x][y+1].setState(   board[x][y+1].getState()+0b1000);
                }
            }
        }
        return board;
    }


    public MineMap() {
    }

    public MineMap(int rows, int cols, int mineCount) {
        this.rows = rows;
        this.cols = cols;
        this.mineCount = mineCount;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public int getMineCount() {
        return mineCount;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public void setMineCount(int mineCount) {
        this.mineCount = mineCount;
    }
}
