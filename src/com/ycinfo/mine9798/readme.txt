
      分析
 ====================================

功能: 扫雷
     cmd

分析类结构:
   棋盘:  数组:  Point[][] board=new Point[][];
        元素:  Point( x,y,state)   ->  Point( x,y, mineCount,status,isMine)

   1。 Point类:  Point( x,y,state)   ->  Point( x,y, mineCount,status,isMine)
   2. MineMap类:
           1) 记录多少个格子
           2) 数组的初始化:  Point[][] board=new Point[][];
           埋雷:
               条件：要知道要埋多少个雷?   是否会埋重复?
                    state:
                        0000 ++  00  1
   3. 游戏控制类:  MineController
            1)控制游戏的运行
            2) 棋盘的显示
            3) 逻辑控制方法.....
   4. 程序入口类:   Main类


