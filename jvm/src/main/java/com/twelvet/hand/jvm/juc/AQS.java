package com.twelvet.hand.jvm.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author twelvet
 * <p>
 * AQS
 */
public class AQS {

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        boolean b = reentrantLock.tryLock();
        reentrantLock.unlock();
        Map<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("", "");
    }



}
