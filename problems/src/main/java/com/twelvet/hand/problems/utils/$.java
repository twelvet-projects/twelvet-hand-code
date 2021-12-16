package com.twelvet.hand.problems.utils;

/**
 * @author twelvet
 * <p>
 * 工具类
 */
public class $ {

    /**
     * 计数器开始
     */
    public static long START_TIME = 0;

    /**
     * 打印number
     *
     * @param numbers numbers
     */
    public static void fmt(int[] numbers) {
        for (int j : numbers) {
            System.out.println(j);
        }
    }

    /**
     * 计数器开始
     */
    public static void startTimer() {
        START_TIME = System.currentTimeMillis();
    }

    /**
     * 获得计时器时间
     */
    public static void fmtTimer() {
        System.out.printf("运行时间（毫秒）：%s\n", System.currentTimeMillis() - START_TIME);
    }

}
