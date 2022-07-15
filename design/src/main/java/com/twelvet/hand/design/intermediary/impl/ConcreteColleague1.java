package com.twelvet.hand.design.intermediary.impl;

import com.twelvet.hand.design.intermediary.Colleague;
import com.twelvet.hand.design.intermediary.Mediator;

public class ConcreteColleague1 extends Colleague {
    public ConcreteColleague1(Mediator mediator) {
        super(mediator);
    }
 
    public void send(String message) {
        getMediator().send(message, this);
    }
 
    public void Notify(String message) {
        System.out.println("同事1收到消息：" + message);
    }
}
 
 
