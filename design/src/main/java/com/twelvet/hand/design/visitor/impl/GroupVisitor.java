package com.twelvet.hand.design.visitor.impl;

import com.twelvet.hand.design.visitor.Visitor;

// 子类二 群体用户 为方便都是八折
public class GroupVisitor implements Visitor {

    @Override
    public double visitKeyboard(Keyboard keyboard) {
        return keyboard.price * 0.8;
    }

    @Override
    public double visitMouse(Mouse mouse) {
        return mouse.price * 0.8;
    }

}
