package com.twelvet.hand.design.singleton;

import com.sun.org.apache.bcel.internal.classfile.InnerClass;

/**
 * 枚举单例
 * 严格意义上来说其他实现的单例模式都不是线程安全的，因为反射机制的存在
 * 反射可以破坏私有属性，并且通过反射创建对象，举个例子，通过反射破坏上面的静态内部类方式实现的单例模式
 */
public enum EnumSingleton {

    INSTANCE;

    public static EnumSingleton getInstance() {
        return INSTANCE;
    }
}

class Test {
    public static void main(String[] args) {
        System.out.println(EnumSingleton.getInstance() == EnumSingleton.getInstance());
    }
}