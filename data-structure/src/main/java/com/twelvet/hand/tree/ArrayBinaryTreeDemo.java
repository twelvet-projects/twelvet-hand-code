package com.twelvet.hand.tree;

import java.util.Arrays;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 数组二叉树
 */
public class ArrayBinaryTreeDemo {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(arr);
        arrayBinaryTree.perOrder();
    }

}

class ArrayBinaryTree {
    // 储存数据节点的数组
    private final int[] arr;

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    // 重载perOrder
    public void perOrder() {
        this.perOrder(0);
    }

    // 编写一个方法，完成顺序储存二叉树的前序遍历
    public void perOrder(int index) {
        // 如果数组为空，或者arr.length = 0
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
            return;
        }

        // 输出当前这个元素
        System.out.println(arr[index]);
        // 向右递归遍历
        if ((index * 2 + 1) < arr.length) {
            perOrder(2 * index + 1);
        }
        // 向右递归遍历
        if ((index * 2 + 2) < arr.length) {
            perOrder(2 * index + 2);
        }
    }

}
