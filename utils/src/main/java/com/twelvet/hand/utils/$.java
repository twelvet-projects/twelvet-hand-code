package com.twelvet.hand.utils;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author twelvet
 * <p>
 * 工具类
 */
public class $ {

    /**
     * 线程池
     */
    public static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
            // 核心数量
            10,
            // 最大线程数量
            // 最大核心*2,获取cpu数量
            Runtime.getRuntime().availableProcessors() * 2,
            // 保持一定连接时间
            10,
            // 以分钟计算
            TimeUnit.SECONDS,
            // 队列
            new LinkedBlockingQueue<>(30),
            // 线程工厂
            Executors.defaultThreadFactory(),
            // 拒绝策略
            new ThreadPoolExecutor.CallerRunsPolicy()
    );

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
