package com.twelvet.hand.design.visitor.impl;

import com.twelvet.hand.design.visitor.Visitor;

// 子类一 个人用户 为方便都是九折
public class PersonVisitor implements Visitor {

    @Override
    public double visitKeyboard(Keyboard keyboard) {
        return keyboard.price * 0.9;
    }

    @Override
    public double visitMouse(Mouse mouse) {
        return mouse.price * 0.9;
    }

}
