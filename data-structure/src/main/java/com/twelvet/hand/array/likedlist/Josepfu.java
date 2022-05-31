package com.twelvet.hand.array.likedlist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author twelvet
 * <p>
 * 约瑟夫环形链表
 */
public class Josepfu {

    public static void main(String[] args) {

    }

}

/**
 * 创建一个环形的单向链表
 */
class CircleSingleLinkedList {

    private final static Logger log = LoggerFactory.getLogger(CircleSingleLinkedList.class);

    /**
     * 创建一个first节点，当前没有编号
     */
    private Boy first = new Boy(-1);

    /**
     * 添加小孩节点，构成一个环形链表
     *
     * @param nums 数量
     */
    public void addBoy(int nums) {
        if (nums < 1) {
            log.error("nums的值不正确");
            return;
        }

        // 辅助指针，帮助构建环形链表
        Boy curBoy = null;

        // 循环创建环形链表
        for (int i = 0; i < nums; i++) {
            // 根据编号创建小孩节点
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
            }
        }

    }

}

class Boy {

    /**
     * 编号
     */
    private int no;

    /**
     * 指向下一个节点，默认null
     */
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}