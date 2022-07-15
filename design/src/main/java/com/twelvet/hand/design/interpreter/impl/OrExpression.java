package com.twelvet.hand.design.interpreter.impl;

import com.twelvet.hand.design.interpreter.Expression;

//解析器
public class OrExpression implements Expression {
    //数据源1
    private Expression expr1 = null;
    //数据源2
    private Expression expr2 = null;

    public OrExpression(Expression expr1, Expression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    //传进来的数据进行判断   只要有一个true 那么就就返回true   否则就false
    @Override
    public boolean interpret(String context) {
        return expr1.interpret(context) || expr2.interpret(context);
    }
}