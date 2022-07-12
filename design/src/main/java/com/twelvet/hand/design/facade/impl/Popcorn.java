package com.twelvet.hand.design.facade.impl;

public class Popcorn {
    private static final Popcorn instance = new Popcorn();

    public static Popcorn getInstance() {
        return instance;
    }

    public void on() {
        System.out.println("爆米花机 打开");
    }

    public void off() {
        System.out.println("爆米花机 关闭");
    }

    public void pop() {
        System.out.println("爆米花机 蹦爆米花");
    }
}