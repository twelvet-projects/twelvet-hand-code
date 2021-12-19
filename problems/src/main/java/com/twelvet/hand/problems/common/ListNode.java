package com.twelvet.hand.problems.common;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description:
 */
public class ListNode {

    //数据 ：节点数据
    public int val;

    //对象 ：引用下一个节点对象。在Java中没有指针的概念，Java中的引用和C语言的指针类似
    public ListNode next;

    //构造方法 ：构造方法和类名相同
    public ListNode(int val) {
        //把接收的参数赋值给当前类的val变量
        this.val = val;
    }
}
