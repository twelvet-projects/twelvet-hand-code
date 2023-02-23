package com.twelvet.hand.recursion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 八皇后
 */
public class EightQueens {

    private static final Logger log = LoggerFactory.getLogger(EightQueens.class);

    /**
     * 定义一个max表示共有多少个皇后
     */
    int max = 8;

    /**
     * 定义数组array，保存皇后放置位置的结果，比如arr = {0, 4, 7, 5, 2, 6, 1, 3}
     */
    int[] array = new int[max];

    static int count = 0;

    public static void main(String[] args) {
        EightQueens eightQueens = new EightQueens();
        eightQueens.check(0);
        System.out.println();
        log.info("一共解法有：{}种", count);
    }

    /**
     * 放置第n个皇后
     *
     * @param n 第n个皇后
     */
    private void check(int n) {
        // n = 8
        if (n == max) {
            print();
            return;
        }

        // 依次放入皇后，并判断是否冲突
        for (int i = 0; i < max; i++) {
            // 先把当前这个皇后n，放到该行的第1列
            array[n] = i;
            // 判断当前放置第n个皇后到i时，是否冲突
            if (judge(n)) {
                // 不冲突，接着放n + 1，即开始递归
                check(n + 1);
            }
        }

        // 如果冲突，就继续执行 array[n] = i，即第n个皇后，放置本行的后一个位置
    }

    /**
     * 查看当我们放置第n个皇后，就去检查皇后是否和前面已经摆放的皇后冲突
     *
     * @param n 表示第n个皇后
     * @return true不冲突
     */
    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            // 1. array[i] == array[n]，表示判断第n个皇后是否和前面的n - 1个皇后在同一列
            // 2. Math.abs(n - i) == Math.abs(array[n] - array[i])，表示判断第n个皇后是否和第i个皇后是否在同一条斜线
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 将皇后摆放的位置输出
     */
    private void print() {
        count++;
        for (int j : array) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

}
