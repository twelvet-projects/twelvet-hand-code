package com.twelvet.hand.design.visitor;

import com.twelvet.hand.design.visitor.impl.NodeA;
import com.twelvet.hand.design.visitor.impl.NodeB;

//这里由于有两个节点，因此，对应就有两个访问操作。
public interface Visitor {
    /**
     * 对应于NodeA的访问操作
     */
    public void visit(NodeA node);
    /**
     * 对应于NodeB的访问操作
     */
    public void visit(NodeB node);
}