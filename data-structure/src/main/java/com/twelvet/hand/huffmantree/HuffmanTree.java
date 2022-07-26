package com.twelvet.hand.huffmantree;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author twelvet
 * <p>
 * 赫夫曼树
 */
public class HuffmanTree {

    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        Node root = createHuffmanTree(arr);

        // 测试一把
        perOrder(root);
    }

    // 前序遍历
    public static void perOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("空数，不能遍历");
        }
    }

    /**
     * 创建赫夫曼树的方法
     *
     * @param arr 需要创建成赫夫曼树的数组
     * @return 创建好后的赫夫曼树的root节点
     */
    public static Node createHuffmanTree(int[] arr) {
        // 第一步为了操作方便
        // 1. 遍历arr数组
        // 2. 将arr的每个元素构成一个Node
        // 3. 将Node放入到ArrayList中
        ArrayList<Node> nodes = new ArrayList<>();
        for (int value : arr) {
            nodes.add(new Node(value));
        }

        while (nodes.size() > 1) {
            Collections.sort(nodes);
            System.out.println(nodes);

            // 取出根节点权值最小的两个二叉树
            // 1. 取出权值最小的节点(二叉树)
            Node leftNode = nodes.get(0);
            // 2. 取出权值第二小的节点(二叉树)
            Node rightNode = nodes.get(1);
            // 构建一颗新的二叉树
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;
            // 4. 从ArrayList删除处理过的二叉树
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);
        }

        // 返回赫夫曼树的root节点
        return nodes.get(0);
    }

}

// 创建节点类
// 为了让Node 对象支持排序Collection集合排序
// 让Node 实现 Comparable接口
class Node implements Comparable<Node> {

    /**
     * 节点权值
     */
    int value;

    /**
     * 指向左子节点
     */
    Node left;

    /**
     * 指向右子节点
     */
    Node right;

    // 前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        // 表示从小到大排序
        return this.value - o.value;
    }
}
