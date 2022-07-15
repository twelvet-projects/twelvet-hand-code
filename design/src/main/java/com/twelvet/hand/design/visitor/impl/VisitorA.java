package com.twelvet.hand.design.visitor.impl;

import com.twelvet.hand.design.visitor.Visitor;
import com.twelvet.hand.design.visitor.impl.NodeA;
import com.twelvet.hand.design.visitor.impl.NodeB;

/**
 * 具体访问者VisitorA类
 */
public class VisitorA implements Visitor {
    /**
     * 对应于NodeA的访问操作
     */
    @Override
    public void visit(NodeA node) {
        System.out.println(node.operationA());
    }

    /**
     * 对应于NodeB的访问操作
     */
    @Override
    public void visit(NodeB node) {
        System.out.println(node.operationB());
    }
}
