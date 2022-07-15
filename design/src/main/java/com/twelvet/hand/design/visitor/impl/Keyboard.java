package com.twelvet.hand.design.visitor.impl;

import com.twelvet.hand.design.visitor.ComputerPart;
import com.twelvet.hand.design.visitor.Visitor;

// 子类一
public class Keyboard extends ComputerPart {

    public Keyboard(String name, double price) {
        super(name, price);
    }

    @Override
    public double accept(Visitor visitor) {
        // 调用访问者的访问回调方法，将自身再传递给访问者，第二次分派，对不同的访问者做出不同的响应
        // 这个this是关键，也是重点
        return visitor.visitKeyboard(this);
    }

}
