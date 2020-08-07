package com.cigit.recursion;

/**
 * @Description:
 * @Author:zhuzhou
 * @Date: 2020/8/7 11:22
 * 递归解决迷宫问题
 **/
public class MiGong {

    public static void main(String[] args) {
        /**
         * 创建一个二维数组当做地图
         */
        int[][] map = new int[8][7];
        //第一行和最后一行全是1表示墙
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
            //制造屏障
           /* map[2][1] = 1;
            map[1][2] = 1;*/
        }
        System.out.println("走之前");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println("走之后");
        setWay(map,1,1);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + "  ");
            }
            System.out.println();
        }
    }

    /**
     * 寻找迷宫出路，起点为map[1][1],终点为map[6][5]
     * 约定,当map[i][j]=0,表示没走过,当为1时表示墙，2表示路可以走通，3表示改点走过，但走不通
     * 在走迷宫时，需要确定一个策略(方法) 下->右->上->左 , 如果该点走不通，再回溯
     *
     * @param map 每次传过来的地图
     * @param i   横坐标
     * @param j   纵坐标
     * @return
     */
    public static  boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {//表示找到了终点
            return true;
        } else {
            if (map[i][j] == 0) {//如果这个点还没走过
                map[i][j] = 2;//假定当前这个点走的通
                //按照下->右->上->左的顺序走
                if (setWay(map, i + 1, j)) {//往下走
                    return true;
                } else if (setWay(map, i, j + 1)) {//往右走
                    return true;
                } else if (setWay(map, i - 1, j)) {//往上走
                    return true;
                } else if (setWay(map, i, j - 1)) {//往左走
                    return true;
                } else {
                    map[i][j] = 3;//说明走不通是死路
                    return false;
                }
            }else{// 如果map[i][j] != 0 , 可能是 1， 2， 3
                return false;
            }
        }

    }

}
