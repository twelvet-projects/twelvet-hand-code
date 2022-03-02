package com.twelvet.hand.array;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 单链表
 */
class SingLeLinkedListRun {

    public static void main(String[] args) {
        HeroNode heroNodeSonJiang = new HeroNode(1, "松江", "及时雨");
        HeroNode heroNodeLuJunYi = new HeroNode(2, "松江", "玉麒麟");
        HeroNode heroNodeWuYon = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNodeLinChong = new HeroNode(4, "林冲", "豹子头");

        // 创建链表
        SingLeLinkList singLeLinkList = new SingLeLinkList();
        singLeLinkList.add(heroNodeLinChong);
        singLeLinkList.add(heroNodeWuYon);
        singLeLinkList.add(heroNodeLuJunYi);
        singLeLinkList.add(heroNodeSonJiang);

        singLeLinkList.list();

    }

}

public class SingLeLinkList {

    private final static Logger log = LoggerFactory.getLogger(SingLeLinkList.class);

    private final HeroNode head = new HeroNode(0, "", "");

    /**
     * 添加节点到单项链表
     * 当不考虑编号顺序时
     * 找到当前链表的最后节点
     * 将最后的这个节点的next，指向新的节点     *
     *
     * @param heroNode HeroNode
     */
    public void add(HeroNode heroNode) {

        // 因为head节点不能动，因此我们需要一个辅助变量遍历temp
        HeroNode temp = head;
        // 遍历链表，找到最后
        while (temp.next != null) {
            // 找到链表最后

            // 如果没有找到最后，将temp后移
            temp = temp.next;
        }
        // 当退出while循环时，temp就指向了链表的最后
        // 将最后这个接地那的next，指向新的节点
        temp.next = heroNode;
    }

    /**
     * 显示链表
     */
    public void list() {
        // 判断是否为空
        if (head.next == null) {
            log.error("链表为空");
            return;
        }
        // 因为头节点，不能动，因此我们需要一个辅助变量来遍历
        HeroNode temp = head.next;
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
class HeroNode {

    public int no;

    public String name;

    public String nickname;

    public HeroNode next;

    public HeroNode(int hNo, String hName, String hNikeName) {
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