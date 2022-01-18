package com.twelvet.hand.design.singleton;

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

    private LazySingleton() {
    }    //private 避免类在外部被实例化

    public static synchronized LazySingleton getInstance() {
        //getInstance 方法前加同步
        if (INSTANCE == null) {
            INSTANCE = new LazySingleton();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        // 需要的时候才会实例化
        System.out.println(getInstance() == getInstance());
    }

}
