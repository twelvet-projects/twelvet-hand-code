package com.twelvet.hand.array.queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

class ArrayQueueRun {

    private final static Logger log = LoggerFactory.getLogger(ArrayQueue.class);

    public static void main(String[] args) {

        ArrayQueue queue = new ArrayQueue(3);

        // 接受用户输入
        char key;
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while (loop) {
            System.out.println("s(show)：显示队列");
            System.out.println("e(exit)：退出程序");
            System.out.println("a(add)：添加数据到队列");
            System.out.println("g(get)：从队列取出数据");
            System.out.println("h(head)：查看队列头的数据");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's' -> queue.showQueue();
                case 'a' -> {
                    log.info("输入一个数");
                    int vale = scanner.nextInt();
                    queue.addQueue(vale);
                }
                case 'g' -> {
                    try {
                        int res = queue.getQueue();
                        log.info("取出的数据是：{}", res);
                    } catch (Exception e) {
                        log.error(e.getMessage());
                    }
                }
                case 'h' -> {
                    try {
                        int res = queue.headQueue();
                        log.info("队列头的数据树：{}", res);
                    } catch (Exception e) {
                        log.error(e.getMessage());
                    }
                }
                case 'e' -> {
                    scanner.close();
                    loop = false;
                }
                default -> {
                }
            }

        }

    }
}

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 数组队列
 */
public class ArrayQueue {

    private final static Logger log = LoggerFactory.getLogger(ArrayQueue.class);

    /**
     * 数组最大容量
     */
    private final int maxSize;

    /**
     * 队列头
     */
    private int front;

    /**
     * 队列尾
     */
    private int rear;

    /**
     * 该数据用于存放数据，模拟队列
     */
    private final int[] arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        // 指向队列头部,分析出front是指向队列头的前一个位置
        front = -1;
        // 指向队列尾，指向队列尾部的数据（）既就是队列最后一个数据
        rear = -1;
    }

    /**
     * 判断队列是否满
     *
     * @return boolean
     */
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    /**
     * 判断队列是否为空
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * 添加数据到队列
     *
     * @param n 数据
     */
    public void addQueue(int n) {
        if (isFull()) {
            log.info("队列满，不能继续添加数据");
            return;
        }
        rear++;
        arr[rear] = n;
        log.info("成功添加进入队列");
    }

    /**
     * 获取队列数据
     *
     * @return int
     */
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，不能获取数据");
        }
        front++;
        return arr[front];
    }

    /**
     * 显示队列的所有数据
     */
    public void showQueue() {

        if (isEmpty()) {
            log.error("队列空的，没有数据");
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            log.info("arr[{}] = {}\n", i, arr[i]);
        }

    }

    /**
     * 显示队列的头数据，注意不是取数据
     *
     * @return int
     */
    public int headQueue() {

        if (isEmpty()) {
            throw new RuntimeException("队列空的，没有数据");
        }
        return arr[front + 1];
    }

}
