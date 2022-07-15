package com.twelvet.hand.design.template.impl;

import com.twelvet.hand.design.template.AbstractClass;

public class ConcreteClass1 extends AbstractClass {
    private boolean isFlag = true;

    @Override
    protected void doSomething() {
        System.out.println("我是1 doSomething");

    }

    @Override
    protected void doAnything() {
        System.out.println("我是1 doAnything");

    }

    @Override
    public boolean isDoAnything() {
        return this.isFlag;
    }

    //要不要doAnything,使用时决定
    public void setIsDoAnything(boolean isDo) {
        this.isFlag = isDo;
    }
}