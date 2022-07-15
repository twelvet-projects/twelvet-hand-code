package com.twelvet.hand.design.template;

public abstract class AbstractClass {

    //基本方法
    protected abstract void doSomething();

    protected abstract void doAnything();

    //模板方法
    public void templateMethod() {
        this.doSomething();
        if (this.isDoAnything()) {
            this.doAnything();
        }
        System.out.println(this.toString());
    }

    public boolean isDoAnything() {
        return true;
    }

}