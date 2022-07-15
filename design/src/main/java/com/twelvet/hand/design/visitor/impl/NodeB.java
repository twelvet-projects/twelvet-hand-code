package com.twelvet.hand.design.visitor.impl;

import com.twelvet.hand.design.visitor.Node;
import com.twelvet.hand.design.visitor.Visitor;

/**
 * 具体节点类NodeB
 */
public class NodeB extends Node {
    /**
     * 接受方法
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    /**
     * NodeB特有的方法
     */
    public String operationB() {
        return "NodeB";
    }
}
