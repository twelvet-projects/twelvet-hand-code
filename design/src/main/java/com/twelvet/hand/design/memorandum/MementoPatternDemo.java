package com.twelvet.hand.design.memorandum;

import com.twelvet.hand.design.memorandum.impl.CareTaker;
import com.twelvet.hand.design.memorandum.impl.Originator;

public class MementoPatternDemo {
    public static void main(String[] args) {
        Originator originator = new Originator();
        originator.setState("State #1");
        originator.setState("State #2");

        CareTaker careTaker = new CareTaker();
        careTaker.add(originator.saveStateToMemento());//保存档案

        originator.setState("State #3");
        careTaker.add(originator.saveStateToMemento()); //保存档案

        originator.setState("State #4");
        System.out.println("当前状态 : " + originator.getState());

        originator.getStateFromMemento(careTaker.get(0));//获取存档
        System.out.println("恢复到存档1状态: " + originator.getState());

        originator.getStateFromMemento(careTaker.get(1));
        System.out.println("恢复到存档2状态: " + originator.getState());
    }
}