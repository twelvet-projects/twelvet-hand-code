package com.twelvet.hand.design.facade.impl;

public class Projector {
    private static final Projector instance = new Projector();

    public static Projector getInstance() {
        return instance;
    }

    public void on() {
        System.out.println("投影仪 打开");
    }

    public void off() {
        System.out.println("投影仪 关闭");
    }

    public void focus() {
        System.out.println("投影仪 对焦");
    }
}