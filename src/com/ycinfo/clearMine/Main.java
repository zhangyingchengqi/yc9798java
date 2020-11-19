package com.ycinfo.clearMine;

/**
 * 游戏的入门口类
 * @author Administrator
 *
 */
public class Main {
    public static void main(String[] args) {
         //步骤一: 点的测试
//        Point p=new Point();
//        p.setX(0);
//        p.setY(0);
//        p.setState(0b0000101);// 0b  0000(周围没有雷） 10（状态为 标志) 1 （是雷)
//
//        System.out.println(   p );


        //步骤二: 生成棋盘
//        MineMap mm=new MineMap(5,5,2);
//        System.out.println(  mm );


        new ClearMine().start();

		/*//测试地图
		ClearMineGame cmg = new ClearMineGame();
		MineMap mm = new MineMap(9, 9, 9);

		Point[][] points = mm.getMineMap();

		for (int i = 0; i < points.length; i++) {
			for (int j = 0; j < points[0].length; j++) {

				//0bxxxxxxx  ==> 0bxxxx01x
				// 0bxxxxxxx & 1111001 = > 0bxxxx00x
				// 0bxxxx00x | 0b10
				points[i][j].setState((points[i][j].getState() & 0b1111001) | 0b10 );
			}
		}

		cmg.showFiledime(points);*/
    }
}
