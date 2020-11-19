package com.ycinfo.clearMine;


import java.util.Random;

public class MineMap {
    private int width;
    private int height;
    private int mineCount;


    public MineMap() {
    }

    public MineMap(int width, int height, int mineCount) {
        this.width = width;
        this.height = height;
        this.mineCount = mineCount;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getMineCount() {
        return mineCount;
    }

    public void setMineCount(int mineCount) {
        this.mineCount = mineCount;
    }

    //获得地图
    public Point[][] getMineMap() {
        Point[][] points = new Point[height][width];
        //初始化地图
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                points[i][j] = new Point(i, j, 0);  //初始坐标
            }
        }
        return burnMine(points);
    }

    //随机埋雷
    public Point[][] burnMine(Point[][] points) {
        Random rand = new Random();
        for (int i = 0; i < mineCount; ) {   //注意不能  i++  ,一个雷是否埋成功，要在程序中判断
            int x = rand.nextInt(height); //生成 0 ~ height - 1的随机数
            int y = rand.nextInt(width); //生成 0 ~ width - 1的随机数
            //生成的坐标点上的值 如果是:   0bxxxxxx1表示有雷    0bxxxxxx0表示没有雷
            //而  0b1 可以看成是         0b0000001
            // 这样通过                 &运算   , 可以得到
            //                         0b0000001可写成 0b1   0b0000000 可写成0b0
            //所以:  points[x][y].getState() & 0b1) != 0b1 ,表示这个点上没有雷，则可以埋雷
            if (   (points[x][y].getState() & 0b1) != 0b1  ) {  //
                i++;
                //当前  points[x][y] 上的state值 肯定是  0bxxxxxx0,现在要在最后一位加个1,怎么做? 用或运算
                //   因为 0bxxxxxx0|0b1 可以看成是   0bxxxxxx0|0b0000001
                //                           结果为 0bxxxxxx1  , 埋雷成功
                points[x][y].setState(points[x][y].getState() | 0b1);

                //2. 接下来要考虑，更新这个点四周的点上雷的数量。
                //计算顺序这里定为 上，下，左右
                // 1) 先看上面的三个点
                if (x - 1 >= 0) {
                    //上面中间这个点
                    //雷的数量0b0000xxx 前四位表示
                    // 0b0000xxx + 0b1000 == > 0b0001xxx
                    points[x - 1][y].setState(points[x - 1][y].getState() + 0b1000);  //添加一个雷的数量
                    //上面左边的点
                    if (y - 1 >= 0) {
                        points[x - 1][y - 1].setState(points[x - 1][y - 1].getState() + 0b1000);  //添加一个雷的数量
                    }
                    //上面右边的点
                    if (y + 1 < width) {
                        points[x - 1][y + 1].setState(points[x - 1][y + 1].getState() + 0b1000);  //添加一个雷的数量
                    }
                }
                //2)下面的三个点
                if (x + 1 < height) {
                    //下面中间这个点
                    points[x + 1][y].setState(points[x + 1][y].getState() + 0b1000);  //添加一个雷的数量
                    //下面左边的点
                    if (y - 1 >= 0) {
                        points[x + 1][y - 1].setState(points[x + 1][y - 1].getState() + 0b1000);  //添加一个雷的数量
                    }
                    //下面右边的点
                    if (y + 1 < width) {
                        points[x + 1][y + 1].setState(points[x + 1][y + 1].getState() + 0b1000);  //添加一个雷的数量
                    }
                }
                //同x行的左边的点
                if (y - 1 >= 0) {
                    points[x][y - 1].setState(points[x][y - 1].getState() + 0b1000);  //添加一个雷的数量
                }
                //同x行右边的点
                if (y + 1 < width) {
                    points[x][y + 1].setState(points[x][y + 1].getState() + 0b1000);  //添加一个雷的数量
                }
            }
        }
        return points;
    }
}

