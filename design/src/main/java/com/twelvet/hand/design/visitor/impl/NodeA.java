package com.twelvet.hand.design.visitor.impl;

import com.twelvet.hand.design.visitor.Node;
import com.twelvet.hand.design.visitor.Visitor;

/**
 * 具体节点类NodeA
 */
public class NodeA extends Node {
    /**
     * 接受操作
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    /**
     * NodeA特有的方法
     */
    public String operationA() {
        return "NodeA";
    }
}
