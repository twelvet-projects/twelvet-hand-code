package com.twelvet.hand.design.interpreter.impl;

import com.twelvet.hand.design.interpreter.Expression;

//数据源
public class TerminalExpression implements Expression {

    private final String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    //数据判断
    @Override
    public boolean interpret(String context) {
        //判断是否字符串中是否包含指定字符
        return context.contains(data);
    }
}