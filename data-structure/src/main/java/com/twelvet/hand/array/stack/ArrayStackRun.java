package com.twelvet.hand.array.stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

/**
 * @author twelvet
 * <p>
 * 栈
 */
public class ArrayStackRun {

    private static final Logger log = LoggerFactory.getLogger(ArrayStackRun.class);

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(4);
        // 接受用户输入
        String key;
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while (loop) {
            System.out.println("s(show)：显示栈");
            System.out.println("e(exit)：退出程序");
            System.out.println("push：添加数据到栈");
            System.out.println("pop：从栈取出数据");
            key = scanner.next();
            switch (key) {
                case "s":
                    arrayStack.list();
                    break;
                case "push":
                    log.info("输入一个数");
                    int vale = scanner.nextInt();
                    arrayStack.push(vale);

                    break;
                case "pop":
                    try {
                        int res = arrayStack.pop();
                        log.info("取出的数据是：{}", res);
                    } catch (Exception e) {
                        log.error(e.getMessage());
                    }
                    break;
                case "e":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
    }

}

class ArrayStack {

    private static final Logger log = LoggerFactory.getLogger(ArrayStack.class);

    /**
     * 栈的大小
     */
    private int maxSize;

    /**
     * 数组，数组模拟栈
     */
    private int[] stack;

    /**
     * 栈初始化为-1
     */
    private int top = -1;

    /**
     * 构造器设置数据初始化
     *
     * @param maxSize 堆栈大小
     */
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    /**
     * 判断栈是否满
     *
     * @return true||false
     */
    public boolean isFull() {
        // 当最大减1代表满了
        return top == maxSize - 1;
    }

    /**
     * 判断栈是否为空
     *
     * @return true||false
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 入栈
     *
     * @param value 入堆栈数据
     */
    public void push(int value) {
        if (isFull()) {
            log.error("堆栈已满，无法添加");
        }
        top++;
        stack[top] = value;
    }

    /**
     * 出堆栈，返回顶部数据
     *
     * @return 返回数据
     */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空，没有数据");
        }
        int value = stack[top];
        top--;
        return value;
    }

    /**
     * 显示栈，遍历时需要从栈顶开始显示数据
     */
    public void list() {
        if (isEmpty()) {
            throw new RuntimeException("栈空，没有数据");
        }
        for (int i = top; i >= 0; i--) {
            log.info("stack[{}]：{}", i, stack[i]);
        }
    }

}