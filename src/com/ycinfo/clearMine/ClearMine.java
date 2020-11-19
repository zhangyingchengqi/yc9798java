package com.ycinfo.clearMine;


import java.util.Scanner;

/**
 * 扫雷游戏类
 */
public class ClearMine {
    private MineMap map;   //地雷地图
    private int pointCount;  //棋盘中的棋子总数,要所有的棋子都安全打开，游戏结束
    private int useTime; //游戏时间
    private Point[][] minePoints; //地雷的布局
    private Scanner input = new Scanner(System.in); // 控制台输入对象

    // 开始游戏方法
    public void start() {
        System.out.println("\t\t欢迎进入扫雷游戏大赛\n");
        System.out.print("请选择游戏难易度(1、容易, 2、中等, 3、困难):");
        int choose = 0;
        do{
            choose = input.nextInt(); // 从控制台接收一个整数
            switch (choose) {
                case 1:
                    //showFiledime(9, 9);
                    map = new MineMap(9, 9, 9);
                    pointCount = 9 * 9;
                    break;
                case 2:
                    //showFiledime(16, 16);
                    map = new MineMap(16, 16, 40);
                    pointCount = 16 * 16;
                    break;
                case 3:
                    //showFiledime(16, 30);
                    map = new MineMap(30, 16, 99);
                    pointCount = 16 * 30;
                    break;
                default:
                    System.out.print("没有此选项，请重新选择：");
            }
        }while(choose > 3 || choose < 1);
        minePoints = map.getMineMap(); //获得地雷布局, 此时棋盘中的雷已经布好了
        //以下这一步不是必须的，主要是为了将原始棋盘显示 一次,让大家看一下原始的值
        //将棋盘中所有的棋子的状态 都初始化为    1  : 即  0bxxxx01x  ,
        for (int i = 0; i < minePoints.length; i++) {
            for (int j = 0; j < minePoints[0].length; j++) {
                //不管任何值 & 0b1111001   得到的结果主要是为了将 状态位设置为 0
                //然后再  | 0b10 ,  这样就可以将状态位设置为   1   了. 此时其它的位不变
                minePoints[i][j].setState((minePoints[i][j].getState() & 0b1111001) | 0b10 );
            }
        }
        showFiledime(minePoints);   //显示原始棋盘(实际上是作弊)
        // 将状态设置为 00 , 去掉作弊效果.
        for (int i = 0; i < minePoints.length; i++) {
            for (int j = 0; j < minePoints[0].length; j++) {
                //0bxxxxxxx  ==> 0bxxxx01x
                // 0bxxxxxxx & 1111001 = > 0bxxxx00x
                // 0bxxxx00x | 0b10
                minePoints[i][j].setState((minePoints[i][j].getState() & 0b1111001));  //重新将状态设为0
            }
        }
        System.out.println("============================================");
        playGame();
    }

    private void playGame() {
        boolean isOver = false; //判断是否结束
        showFiledime(minePoints);
        //开始玩游戏:
        System.out.print("请输入坐标(x y)：");
        int x = input.nextInt();
        int y = input.nextInt();
        Point point = minePoints[x - 1][y - 1];
        System.out.print("请选择操作(1、打开, 2、插旗, 3、拔旗)：");
        int choose = 0;
        do {
            choose = input.nextInt(); // 从控制台接收一个整数
            switch (choose) {
                case 1:
                    isOver = openPoint(point); //1、打开
                    break;
                case 2:
                    //2、插旗
                    insertFlag(point);
                    break;
                case 3:
                    //3、拔旗
                    delFlag(point);
                    break;
                default:
                    System.out.print("没有此操作，请重新选择：");
            }
        }while(choose > 3 || choose < 1);
        //输入完成判断结束
        if (isOver) {
            System.out.println("游戏结束...");
        } else {
            playGame(); //重新再来输入一次
        }
    }
    //拔旗
    /*
    1、分析得：
        a、在每一个坐标上，有3种状态， 没开， 打开， 插旗   00表示没开, 01表示打开, 10表示 插旗
        b、坐标上有雷还是没雷 ,有2种状态   0表示没有  1表示有
        c、没有,有9个状态, 0000表示附近雷没有, 0001表示附近1个雷 ...  1000表示 附近8个雷
     */
    public void delFlag(Point point) {
        int state = point.getState();
        //1、判断是否已经插旗
        if ((state & 0b110) == 0b100) {
            //拔掉旗子, 即状态为 00
            minePoints[point.getX()][point.getY()].setState(point.getState() & 0b1111001);
            return;
        }
        System.out.println("此坐标没有插旗，不能拔旗...");
    }
    //插旗
    public void insertFlag(Point point) {
        int state = point.getState();
        //1、是否打开
        if ((state & 0b110) == 0b10) {
            System.out.println("已经打开，不能插旗...");
            return;
        }
        //2、是否已经插旗
        if ((state & 0b110) == 0b100) {
            System.out.println("已经插旗，不能插旗...");
            return;
        }
        //插旗操作
        minePoints[point.getX()][point.getY()].setState(point.getState() + 0b100);
    }
    //打开
    public boolean openPoint(Point point) {
        //1、打开后判断有雷还是没有雷
        int state = point.getState();
        //0bxxxxxxx == > 0b000000x
        if ((state & 0b1) == 0b1){  //判断有雷
            //game over 结束, 全部打开
            for (int i = 0; i < minePoints.length; i++) {
                for (int j = 0; j < minePoints[0].length; j++) {
                    //状态全部设为  1
                    minePoints[i][j].setState((minePoints[i][j].getState() & 0b1111001) | 0b10 );
                }
            }
            return true;
        } else {
            //2、当前点不是雷
            //2.1、是数字
            //2.2、是0, 还要打开point附近为空和不是雷的坐标
            openWhiteOption(point);
            if (pointCount == map.getMineCount())  //剩余的坐标数是否与雷相等, 如果相等表示赢了
            {
                System.out.println("恭喜你， 赢了");
                return true;
            }

            return false;
        }
    }

    public void openWhiteOption(Point point) {
        int state = point.getState();
        //容错处理:    当前点是雷， 状态为1,  10, 则当前点无效
        if ((state & 0b1) == 0b1 || (state & 0b110) == 0b10 || (state & 0b110) == 0b100){
            return;
        }
        //当前点设置为打开
        minePoints[point.getX()][point.getY()].setState(point.getState() + 0b10);
        pointCount--;    //表示已经处理了一个点， 所以棋子总数-1
        //当前点的周围没有雷，表明这里有连续的空白. 继续判断附近坐标
        if ((state >> 3) == 0){
            int x = point.getX();
            int y = point.getY();
            //当前点的上一行
            if (x - 1 >= 0) {
                //正上方的点
                openWhiteOption(minePoints[x-1][y]);
                // 左上方的点
                if (y - 1 >= 0) {
                    openWhiteOption(minePoints[x-1][y-1]);
                }
                //右上方的点
                if (y + 1 < minePoints[0].length) {
                    openWhiteOption(minePoints[x-1][y+1]);
                }
            }
            //当前点的下一行
            if (x + 1 < minePoints.length) {
                //正下方
                openWhiteOption(minePoints[x+1][y]);
                if (y - 1 >= 0) {    //左下方
                    openWhiteOption(minePoints[x+1][y - 1]);
                }
                if (y + 1 < minePoints[0].length) {   //右下方
                    openWhiteOption(minePoints[x+1][y + 1]);
                }
            }
            //左边
            if (y - 1 >= 0) {
                openWhiteOption(minePoints[x][y - 1]);
            }
            //右边
            if (y + 1 <  minePoints[0].length) {
                openWhiteOption(minePoints[x][y + 1]);
            }

        }
    }

    //坐标点对象
    //cab  == > 0b1111111
    //x坐标， y坐标
    public void showFiledime(Point[][] points) {
        int col = points[0].length;
        int row = points.length;
        System.out.print("   ");
        //三目运算符 ：  表达式1？ 表达式2：表达式3
        //== 》 当表达式1为true， 结果就是表达式2,  当表达式1为false， 结果就是表达式3
        //输出列号
        for (int i = 0; i < col; i++) {
            System.out.print( (i + 1) + ((i + 1 > 9) ? "" : " ") + " ");  //不要换行
        }
        System.out.println(); //换行
        //同时修改多个相同的变量名 : ctrl + 2, r
        for (int i = 0; i < row; i++) {
            System.out.print( (i + 1) + ((i + 1 > 9) ? "" : " ") + " ");
            for (int j = 0; j < col; j++) {
                // 0bxxxx00x & 0b0000110 == > 主要是为了取出状态值 它得到 0bxxxx状态x
                //判断坐标点有没有打开    0b0可以看成是 0bxxxx00x表示状态为没有打开
                if ((points[i][j].getState() & 0b110) == 0b0) {
                    System.out.print("N  ");  //不要换行
                } else if ((points[i][j].getState() & 0b110) == 0b100){ //判断是否插旗   0b10x
                    System.out.print("F  ");  //不要换行
                } else{
                    if ((points[i][j].getState() & 0b1) == 0b1){ //判断 当前这个点是否为雷
                        System.out.print("M  ");      //不要换行
                    } else {
                        //如果不是雷， 则最后一位为0
                        // 所以只能显示附近雷的数量，以数字显示
                        //0bxxxxxxx >> 3 == > 则只保留 前4 位，即数字位
                        System.out.print((points[i][j].getState() >> 3) + "  ");  //不要换行
                    }
                }
            }
            System.out.println(); //控制换行
        }
    }

}

