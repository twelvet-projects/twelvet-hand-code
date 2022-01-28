package com.twelvet.hand.design.singleton;

import com.twelvet.hand.utils.$;

/**
 * @author twelvet
 * <p>
 * 懒汉式单例
 */
public class LazySingleton {

    /**
     * 保证 instance 在所有线程中同步
     */
    private static volatile LazySingleton INSTANCE = null;

    /**
     * private 避免类在外部被实例化
     */
    private LazySingleton() {
        System.out.println(Thread.currentThread().getName());
    }

    public static synchronized LazySingleton getInstance() {
        // getInstance 方法前加同步
        if (INSTANCE == null) {
            INSTANCE = new LazySingleton();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            $.threadPoolExecutor.execute(LazySingleton::getInstance);
        }
    }

}
