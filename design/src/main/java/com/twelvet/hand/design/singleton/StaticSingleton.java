package com.twelvet.hand.design.singleton;

/**
 * 静态内部类式
 * 使用静态内部类解决了线程安全问题，并实现了延时加载
 */
public class StaticSingleton {

    private StaticSingleton() {

    }

    /**
     * 不会在外部类初始化时就直接加载，只有当调用了getInstance方法时才会静态加载，线程安全，final保证了在内存中只有一份
     */
    private static class InnerClass {
        private static final StaticSingleton INSTANCE = new StaticSingleton();
    }

    public static StaticSingleton getInstance() {
        return InnerClass.INSTANCE;
    }
}

