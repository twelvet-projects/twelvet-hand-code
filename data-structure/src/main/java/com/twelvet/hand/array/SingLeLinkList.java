package com.twelvet.hand.array;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 单链表
 */
class SingLeLinkedListRun {

    private static final Logger log = LoggerFactory.getLogger(SingLeLinkedListRun.class);

    public static void main(String[] args) {
        HeroNode heroNodeSonJiang = new HeroNode(1, "松江", "及时雨");
        HeroNode heroNodeLuJunYi = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNodeWuYon = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNodeLinChong = new HeroNode(4, "林冲", "豹子头");

        // 创建链表
        SingLeLinkList singLeLinkList = new SingLeLinkList();
        /*singLeLinkList.add(heroNodeLinChong);
        singLeLinkList.add(heroNodeWuYon);
        singLeLinkList.add(heroNodeLuJunYi);
        singLeLinkList.add(heroNodeSonJiang);*/

        // 按顺序插入
        singLeLinkList.addOrder(heroNodeWuYon);
        singLeLinkList.addOrder(heroNodeLinChong);
        singLeLinkList.addOrder(heroNodeLuJunYi);
        singLeLinkList.addOrder(heroNodeSonJiang);

        // 插入失败，因为已经存在
        singLeLinkList.addOrder(heroNodeSonJiang);

        singLeLinkList.list();

        log.info("修改后的链表情况");

        // 测试修改节点的代码
        HeroNode newHeroNode = new HeroNode(2, "小卢", "玉麒麟");
        singLeLinkList.update(newHeroNode);

        singLeLinkList.list();

        // 删除一个节点
        singLeLinkList.delete(1);
        log.info("删除节点后");
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
     * 第二种方式在天津英雄时，根据排名将英雄插入到指定位置
     * 如果有这个排名，则天津失败，并给出提示
     */
    public void addOrder(HeroNode heroNode) {

        // 因为头节点不能动，因此我们任然通过一个辅助指针（变量）
        // 因为单链表，找的temp是位于添加位置的前一个节点，否则插入不了
        HeroNode temp = head;
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
     * 修改节点的信息，根据no标号来修改，即no编号不能改
     *
     * @param newHeroNode HeroNode
     */
    public void update(HeroNode newHeroNode) {

        if (head.next == null) {
            log.error("链表为空");
            return;
        }
        // 找到需要修改的接地那，根据no标号
        // 定义一个辅助变量
        HeroNode temp = head.next;
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
     * head不能动，因此我们需要一个temp辅助节点找到待删除节点前一个节点
     * 说明我们在比较时，是temp.next.no和需要删除的节点的no比较
     */
    public void delete(int no) {
        HeroNode temp = head;
        // 标记是否找到待删除节点
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                // 已经找到脸部的最后
                break;
            }
            if (temp.next.no == no) {
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
            temp.next = temp.next.next;
        } else {
            log.error("要删除的{}节点不存在", no);
        }
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