package com.twelvet.hand.array;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 稀疏数组
 */
public class SparseArray {

    /**
     * 棋盘大小
     */
    private final static int SIZE = 11;

    /**
     * 五子棋盘
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        int[][] chessArr = getChessArr();

        // 转换一个稀疏数组
        int[][] sparseArr = transSparseArr(chessArr);

        // 恢复二维数组
        transChessArr(sparseArr);
    }

    /**
     * 得到一个棋盘二维数组
     *
     * @return int[][]
     */
    public static int[][] getChessArr() {
        // 创建一个原始的二维数组11 * 11
        // 0：没有棋子，1：黑子，2：白色棋子
        int[][] chessArr = new int[SIZE][SIZE];

        // 棋子坐落位置
        chessArr[1][2] = 1;
        chessArr[2][4] = 2;

        // 增加一个白棋
        // chessArr[8][8] = 2;

        System.out.println("原始二维数组：");
        for (int[] rows : chessArr) {

            for (int row : rows) {
                System.out.printf("%d\t", row);
            }
            System.out.println();
        }

        return chessArr;
    }

    /**
     * 转换稀疏数组
     * <p>
     * 遍历原始二维数组，得到有效数据的个数 sum
     * 根据sum就可以和藏家稀疏数组sparseArr int[sum + i][3]
     * 将二维数组的有效数据存入稀疏数组
     *
     * @return int[][]
     */
    public static int[][] transSparseArr(int[][] chessArr) {

        // 将二维数组转稀疏数组的思路
        // 1.先遍历二维数组 得到非零的个数
        int sum = 0;
        for (int[] rows : chessArr) {

            for (int row : rows) {
                if (row != 0) {
                    sum++;
                }
            }
        }
        System.out.printf("sum = %d\n", sum);
        // 2.创建对应的稀疏数组
        int[][] sparseArr = new int[sum + 1][3];
        // 给稀疏数组赋值
        sparseArr[0][0] = SIZE;
        sparseArr[0][1] = SIZE;
        sparseArr[0][2] = sum;


        // 遍历二维数组，将非零的值存放到sparseArr中
        // count用于记录是第几个非零数据
        int count = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {

                if (chessArr[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr[i][j];
                }

            }
        }

        System.out.println();
        System.out.println("得到的稀疏数组为：");
        System.out.printf("%s\t%s\t%s\t\n", "行", "列", "值");
        for (int[] ints : sparseArr) {
            System.out.printf("%d\t%d\t%d\t\n", ints[0], ints[1], ints[2]);
        }

        System.out.println();

        return sparseArr;

    }

    /**
     * 转换二维数组
     * <p>
     * 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组，比如上面的棋盘
     * 在读取稀疏数组剩下的行数据，并赋给原始数组即可
     *
     * @param sparseArr int[][]
     */
    public static void transChessArr(int[][] sparseArr) {
        int[][] chessArr = new int[sparseArr[0][0]][sparseArr[0][1]];

        for (int i = 0; i < sparseArr.length - 1; i++) {
            int current = i + 1;

            // 获取行
            int span = sparseArr[current][0];
            // 获取列
            int row = sparseArr[current][1];
            chessArr[span][row] = sparseArr[current][2];
        }

        System.out.println("恢复后的原始二维数组：");
        for (int[] rows : chessArr) {

            for (int row : rows) {
                System.out.printf("%d\t", row);
            }
            System.out.println();
        }

    }

}
