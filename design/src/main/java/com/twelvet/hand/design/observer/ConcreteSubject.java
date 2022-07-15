package com.twelvet.hand.design.observer;

public class ConcreteSubject extends Subject {
 
    //具体业务
    public void doSomething() {
        //...
 
        System.out.println("具体目标发生改变...");
        System.out.println("--------------");
        super.notifyObserver();
    }
 
}