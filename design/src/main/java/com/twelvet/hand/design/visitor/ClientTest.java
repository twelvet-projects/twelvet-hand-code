package com.twelvet.hand.design.visitor;

import com.twelvet.hand.design.visitor.impl.*;
import com.twelvet.hand.design.visitor.impl.NodeB;
import com.twelvet.hand.design.visitor.impl.VisitorB;

/**
 * @author twelvet
 * <p>
 */
public class ClientTest {

    public static void main(String[] args) {
        //创建一个结构对象
        ObjectStructure os = new ObjectStructure();
        //给结构增加一个节点
        os.add(new NodeA());
        //给结构增加一个节点
        os.add(new NodeB());

        //创建一个访问者
        Visitor visitor = new VisitorB();
        os.action(visitor);
    }
}
