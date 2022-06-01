package com.twelvet.hand.array.likedlist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author twelvet
 * <p>
 * 约瑟夫环形链表
 */
public class Josepfu {
    private final static Logger log = LoggerFactory.getLogger(Josepfu.class);

    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoys();
        log.warn("=========================================================");
        circleSingleLinkedList.countBoy(2, 2, 5);
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
        for (int i = 1; i <= nums; i++) {
            // 根据编号创建小孩节点
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                // 构成环
                first.setNext(first);
                // 指向第一个小孩
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    /**
     * 遍历环形链表
     */
    public void showBoys() {
        // 判断是否为空数据
        if (first == null) {
            log.error("数据为空");
            return;
        }
        // first不能移动，需要使用辅助指针
        Boy curBoy = first;
        while (true) {
            log.info("小孩编号为：{}", curBoy.getNo());
            // 判断是否循环完毕
            if (curBoy.getNext() == first) {
                break;
            }
            // curBoy后移
            curBoy = curBoy.getNext();
        }
    }

    /**
     * 根据用户的输入，计算小孩的出拳顺序
     *
     * @param k  表示从第几个小孩开始
     * @param m 表示数几下
     * @param nums     表示最初有多少小孩在圈中
     */
    public void countBoy(int k, int m, int nums) {
        // 校验数据
        if (first == null || k < 1 || k > nums) {
            log.error("参数有误，请重新输入");
            return;
        }

        // 创建辅助指针，帮助小孩出圈
        Boy helper = first;
        // 指针指向链表最后一个节点，让其以最后一个开始数 1->5
        while (helper.getNext() != first) {
            // curBoy后移
            helper = helper.getNext();
        }

        // 小孩报数前，先让first和helper移动k-1次，移动到需要开始的位置前一个
        for (int i = 0; i < k - 1; i++) {
            // 1 -> 2
            first = first.getNext();
            // 5 -> 1
            helper = helper.getNext();
        }
        // 当小孩报数时，让first和helper指针同时的移动m-1次（移动到需要出圈的小孩），然后出圈
        // 这里是一个循环操作，知道圈中只有一个节点
        while (helper != first) {
            // 说明圈中只有一个节点
            // 让first和helper指针同时移动m-1
            for (int i = 0; i < m - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            // 这时first指向的节点就是要出圈的小孩节点
            log.info("小孩{}出圈", first.getNo());
            // 这时将first指向小孩节点出圈
            first = first.getNext();
            helper.setNext(first);
        }
        log.info("最后留在圈中的小孩编号：{}", helper.getNo());
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