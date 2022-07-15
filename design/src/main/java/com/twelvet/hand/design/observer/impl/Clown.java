package com.twelvet.hand.design.observer.impl;

import java.util.Observable;
import java.util.Random;

//小丑类
public class Clown extends Observable {
    public static final int good = 0;
    public static final int bad = 1;
    public static final int complete = 2;

    public void perform() {
        System.out.println("小丑开始表演");
        //0-2随机值
        int random = new Random().nextInt(2);
        switch (random) {
            case good:
                System.out.println("小丑表演得好");
                break;
            case bad:
                System.out.println("小丑表演得不好");
                break;
        }
        setChanged();
        //小丑的状态传给观众的update方法的第二个参数
        notifyObservers(random);
    }

    public void exit() {
        System.out.println("小丑表演结束");
        setChanged();
        //小丑的状态传给观众的update方法的第二个参数
        notifyObservers(complete);
    }

}