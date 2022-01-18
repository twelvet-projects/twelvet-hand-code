package com.twelvet.hand.design.singleton;

/**
 * 枚举单例
 * 严格意义上来说其他实现的单例模式都不是线程安全的，因为反射机制的存在
 * 反射可以破坏私有属性，并且通过反射创建对象，举个例子，通过反射破坏上面的静态内部类方式实现的单例模式
 */
public class EnumSingleton {


    private EnumSingleton() {

    }

    /**
     * 不会在外部类初始化时就直接加载，只有当调用了getInstance方法时才会静态加载，线程安全，final保证了在内存中只有一份
     */
    private static class InnerClass {
        private static final EnumSingleton INSTANCE = new EnumSingleton();
    }

    public static EnumSingleton getInstance() {
        return InnerClass.INSTANCE;
    }
}
