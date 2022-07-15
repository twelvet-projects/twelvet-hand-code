package com.twelvet.hand.design.observer;

public class ObserverPattern {

    public static void main(String[] args) {
        //创建一个主题
        ConcreteSubject subject = new ConcreteSubject();
        //定义一个观察者
        Observer observer = new ConcreteObserver();
        //注册观察者
        subject.addObserver(observer);
        //开始活动
        subject.doSomething();
    }
}