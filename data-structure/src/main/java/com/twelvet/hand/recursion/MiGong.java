package com.twelvet.hand.recursion;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 、迷宫
 */
public class MiGong {

    public static void main(String[] args) {
        // 先创建一个二位数组，模拟迷宫
        int[][] map = new int[8][7];

        // 使用1代表墙
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        // 左右全部为墙
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        // 设置挡板
        map[3][1] = 1;
        map[3][2] = 1;

        // 输出地图
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        // 使用递归回溯给小球找路
        setWay(map, 1, 1);
        System.out.println("小球走过，并标识过的地图情况");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }

    /**
     * 1. map地址
     * 2. 表示从地图的哪个位置开始出发（1, 1）
     * 3. 如果小球能到map[6][5]位置，则说明通路找到
     * 4. 约定当map[i][j] 为0表示该点没有走过当为1表示墙，表示通路可走，3表示该点走过，但是走不通
     * 5. 在走迷宫时，需要确定一个策略 下->右->上->左，如果该点走不通，再回溯
     *
     * @param map 地图
     * @param i   从哪个位置开始寻找
     * @param j
     * @return 如果找到通路就返回true，否则false
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        } else {
            // 如果当前点没有走过
            if (map[i][j] == 0) {
                // 按照策略下->右->上->左
                // 假设该点是可以走通的
                map[i][j] = 2;
                // 向下走
                if (setWay(map, i + 1, j)) {
                    return true;
                } else if (setWay(map, i, j + 1)) {
                    // 向右走
                    return true;
                } else if (setWay(map, i - 1, j)) {
                    // 向上走
                    return true;
                } else if (setWay(map, i, j - 1)) {
                    // 向左走
                    return true;
                } else {
                    // 说明该点走不通
                    map[i][j] = 3;
                    return false;
                }
            } else {
                // 如果map[i][j] != 0，可能是1，2，3
                return false;
            }
        }
    }

}
