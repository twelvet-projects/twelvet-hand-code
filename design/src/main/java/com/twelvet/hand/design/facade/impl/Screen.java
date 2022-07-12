package com.twelvet.hand.design.facade.impl;

public class Screen {
    private static final Screen instance = new Screen();

    public static Screen getInstance() {
        return instance;
    }

    public void up() {
        System.out.println("屏幕 升起");
    }

    public void down() {
        System.out.println("屏幕 降落");
    }
}