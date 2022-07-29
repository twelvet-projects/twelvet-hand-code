package com.twelvet.hand.dac;

/**
 * @author twelvet
 * <p>
 * 汉罗塔算法
 */
public class Hanoitower {
    public static void main(String[] args) {
        hanoiTower(2, 'A', 'b', 'C');
    }

    // 汉罗塔的移动方法
    // 使用分治算法
    public static void hanoiTower(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println("第第一个盘从" + a + "->" + c);
        } else {
            // 如果我们有n >= 2情况，我们总是可以看像是两个盘1，最下边的一个盘2，上面的所有盘
            // 1. 先把最上面的所有盘A->B,移动过程会使用到C
            hanoiTower(num - 1, a, c, b);
            // 2. 把最下边的盘A->C
            System.out.println("第" + num + "个盘从" + a + "->" + c);
            // 3. 把B塔的所有盘从B->C，移动过程使用到a塔
            hanoiTower(num - 1, b, a, c);
        }
    }
}
