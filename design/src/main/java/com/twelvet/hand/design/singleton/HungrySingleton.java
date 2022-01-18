package com.twelvet.hand.design.singleton;

/**
 * 饿汉式单例
 * 在类加载时就创建对象，由于在类加载时就创建单例，因此不存在线程安全问题
 */
public class HungrySingleton {

    private static final HungrySingleton INSTANCE = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return INSTANCE;
    }
}
