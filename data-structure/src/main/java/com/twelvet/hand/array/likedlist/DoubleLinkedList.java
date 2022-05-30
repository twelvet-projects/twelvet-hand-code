package com.twelvet.hand.array.likedlist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 、双向列表
 */
class DoubleLinkedListRun {

    private static final Logger log = LoggerFactory.getLogger(DoubleLinkedListRun.class);

    public static void main(String[] args) {
        DoubleHeroNode heroNodeSonJiang = new DoubleHeroNode(1, "松江", "及时雨");
        DoubleHeroNode heroNodeLuJunYi = new DoubleHeroNode(2, "卢俊义", "玉麒麟");
        DoubleHeroNode heroNodeWuYon = new DoubleHeroNode(3, "吴用", "智多星");
        DoubleHeroNode heroNodeLinChong = new DoubleHeroNode(4, "林冲", "豹子头");

        // 创建链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(heroNodeLinChong);
        doubleLinkedList.add(heroNodeWuYon);
        doubleLinkedList.add(heroNodeLuJunYi);
        doubleLinkedList.add(heroNodeSonJiang);
        doubleLinkedList.list();

        // 修改
        DoubleHeroNode newHeroNOde = new DoubleHeroNode(4, "公孙胜", "入云龙");
        doubleLinkedList.update(newHeroNOde);
        log.warn("修改后的链表情况");
        doubleLinkedList.list();

        // 删除
        doubleLinkedList.delete(3);
        log.warn("删除后的链表情况");
        doubleLinkedList.list();

    }

}

public class DoubleLinkedList {

    private static final Logger log = LoggerFactory.getLogger(DoubleLinkedList.class);

    private final DoubleHeroNode head = new DoubleHeroNode(0, "", "");

    public DoubleHeroNode getHead() {
        return head;
    }

    /**
     * 添加节点到单项链表
     * 当不考虑编号顺序时
     * 找到当前链表的最后节点
     * 将最后的这个节点的next，指向新的节点
     *
     * @param heroNode HeroNode
     */
    public void add(DoubleHeroNode heroNode) {

        // 因为head节点不能动，因此我们需要一个辅助变量遍历temp
        DoubleHeroNode temp = head;
        // 遍历链表，找到最后
        while (temp.next != null) {
            // 找到链表最后

            // 如果没有找到最后，将temp后移
            temp = temp.next;
        }
        // 当退出while循环时，temp就指向了链表的最后
        // 形成一个双向链表
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    /**
     * 修改节点的信息，根据no标号来修改，即no编号不能改
     *
     * @param newHeroNode HeroNode
     */
    public void update(DoubleHeroNode newHeroNode) {

        if (head.next == null) {
            log.error("链表为空");
            return;
        }
        // 找到需要修改的接地那，根据no标号
        // 定义一个辅助变量
        DoubleHeroNode temp = head.next;
        // 表示是否知道该节点
        boolean flag = false;
        while (true) {
            if (temp == null) {
                // 到链表的尾部
                break;
            }
            if (temp.no == newHeroNode.no) {
                // 找到
                flag = true;
                break;
            }
            temp = temp.next;
        }

        // 根据flag判断是否找到要修改的节点
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else {
            log.error("没有找到编号为{}的节点，不能被修改\n", newHeroNode.no);
        }
    }

    /**
     * 删除节点
     * 对于双向链表，我们可以直接找到要删除的这个节点
     * 找到后，自我删除即可
     */
    public void delete(int no) {

        // 判断当前链表是否为空
        if (head.next == null) {
            log.error("当前链表为空，无法删除");
            return;
        }

        DoubleHeroNode temp = head.next;
        // 标记是否找到待删除节点
        boolean flag = false;
        while (true) {
            if (temp == null) {
                // 已经找到脸部的最后
                break;
            }
            if (temp.no == no) {
                // 找到的待删除节点的前一个节点temp
                flag = true;
                break;
            }
            // temp 后移，遍历
            temp = temp.next;
        }
        // 判断flag
        if (flag) {
            // 可以删除
            temp.pre.next = temp.next;
            // 最后一个节点不需要执行，否则空指针
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            log.error("要删除的{}节点不存在", no);
        }
    }

    /**
     * 第二种方式在天津英雄时，根据排名将英雄插入到指定位置
     * 如果有这个排名，则天津失败，并给出提示
     */
    public void addOrder(DoubleHeroNode heroNode) {

        // 因为头节点不能动，因此我们任然通过一个辅助指针（变量）
        // 因为单链表，找的temp是位于添加位置的前一个节点，否则插入不了
        DoubleHeroNode temp = head;
        // flag标志添加的编号是否存在，默认为false
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode.no) {
                // 位置找到，就在temp的后面char
                break;
            } else if (temp.next.no == heroNode.no) {
                // 说明希望添加的heroNode的编号已然存在
                flag = true;
                break;
            }
            // 后移，遍历当前链表
            temp = temp.next;
        }

        // 不能移动，说明编号存在
        if (flag) {
            log.error("准备插入的英雄编号：{}已经存在了，不能加入\n", heroNode.no);
        } else {
            // 插入到链表中，temp的后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }

    }

    /**
     * 遍历双向链表
     */
    public void list() {
        // 判断是否为空
        if (head.next == null) {
            log.error("链表为空");
            return;
        }
        // 因为头节点，不能动，因此我们需要一个辅助变量来遍历
        DoubleHeroNode temp = head.next;
        while (temp != null) {

            // 判断是否到链表最后
            log.info("{}", temp);

            // 将temp后移，一定小心
            temp = temp.next;
        }
    }

}

/**
 * 定义HerNode，每个HeroNode对象就是一个节点
 */
class DoubleHeroNode {

    public int no;

    public String name;

    public String nickname;

    // 指向下一个节点，默认null
    public DoubleHeroNode next;

    // 指向前一个节点，默认null
    public DoubleHeroNode pre;

    public DoubleHeroNode(int hNo, String hName, String hNikeName) {
        this.no = hNo;
        this.name = hName;
        this.nickname = hNikeName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}