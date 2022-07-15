package com.twelvet.hand.design.visitor;

/**
 * 抽象节点类
 */
public abstract class Node {
    /**
     * 接受操作
     */
    public abstract void accept(Visitor visitor);
}