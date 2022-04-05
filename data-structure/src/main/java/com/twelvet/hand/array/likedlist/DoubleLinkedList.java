package com.twelvet.hand.array.likedlist;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 、双向列表
 */
public class DoubleLinkedList {

    public static void main(String[] args) {

    }

}

/**
 * 定义HerNode，每个HeroNode对象就是一个节点
 */
class DoubleHeroNode {

    public int no;

    public String name;

    public String nickname;

    public HeroNode next;

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