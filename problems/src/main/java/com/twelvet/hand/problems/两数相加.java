package com.twelvet.hand.problems;

import com.twelvet.hand.problems.common.ListNode;
import org.junit.Test;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 两数相加
 * <p>
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class 两数相加 {

    @Test
    public void start() {
        ListNode l1 = builderListNode(2, 4, 3);

        ListNode l2 = builderListNode(5, 6, 4);

        ListNode listNode = addTwoNumbers(l1, l2);

        fmt(listNode);
    }


    /**
     * @param l1 ListNode
     * @param l2 ListNode
     * @return ListNode
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 != null || l2 != null) {
            if (l1 == null) {
                l1 = new ListNode(0);
            }
            if (l2 == null) {
                l2 = new ListNode(0);
            }
            int rval = l1.val + l2.val;
            if (rval >= 10) {
                rval = rval % 10;
                if (l1.next != null) {
                    l1.next.val += 1;
                } else {
                    l1.next = new ListNode(1);
                }
            }
            return new ListNode(rval, addTwoNumbers(l1.next, l2.next));
        }
        return null;
    }

    /**
     * 输出
     *
     * @param listNode ListNode
     */
    public void fmt(ListNode listNode) {
        System.out.print(listNode.val);

        ListNode next = listNode.next;

        if (next != null) {
            fmt(next);
        }
    }

    /**
     * 组装链表（逆序储存）
     *
     * @param vals 链表数值
     * @return 组装链表
     */
    public ListNode builderListNode(int... vals) {
        int len = vals.length;
        if (len > 0) {
            int length = vals.length - 1;

            ListNode listNode = new ListNode(vals[length]);

            int[] nextVals = new int[length];

            System.arraycopy(vals, 0, nextVals, 0, length);

            listNode.next = builderListNode(nextVals);

            return listNode;
        }

        return null;
    }

}