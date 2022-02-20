package com.twelvet.hand.array.queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

class CircleArrayQueueRun {

    private final static Logger log = LoggerFactory.getLogger(ArrayQueue.class);

    public static void main(String[] args) {

        // 有效输入数据最大为2
        CircleArrayQueue queue = new CircleArrayQueue(3);

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
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    log.info("输入一个数");
                    int vale = scanner.nextInt();
                    queue.addQueue(vale);

                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        log.info("取出的数据是：{}", res);
                    } catch (Exception e) {
                        log.error(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = queue.headQueue();
                        log.info("队列头的数据树：{}", res);
                    } catch (Exception e) {
                        log.error(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }

        }

    }
}

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 环形队列
 */
public class CircleArrayQueue {

    private final static Logger log = LoggerFactory.getLogger(CircleArrayQueue.class);

    /**
     * 数组最大容量
     */
    private final int maxSize;

    /**
     * 队列头
     * front指向队列的第一个元素，也就是说arr[front]就是队列的第一个元素
     */
    private int front;

    /**
     * 队列尾
     * rear指向队列最后一个元素的后一个位置，因为希望空出一个空间作为约定
     */
    private int rear;

    /**
     * 该数据用于存放数据，模拟队列
     */
    private final int[] arr;

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    /**
     * 判断队列是否满
     *
     * @return boolean
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
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
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
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

        // 这里需要分析出front是指向队列的第一个元素
        // 1.先把front对应的值保留到一个零时变量
        // 2.将front后移,考虑取模
        // 3.将零时保存的变量返回
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    /**
     * 显示队列的所有数据
     */
    public void showQueue() {

        if (isEmpty()) {
            log.error("队列空的，没有数据");
            return;
        }

        // 从front开始遍历，遍历多少个元素
        for (int i = front; i < front + size(); i++) {
            log.info("arr[{}] = {}\n", i % maxSize, arr[i % maxSize]);
        }

    }

    /**
     * 求出当前队列有效数据的个数
     *
     * @return int
     */
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    /**
     * 显示队列的头数据，注意不试取数据
     *
     * @return int
     */
    public int headQueue() {

        if (isEmpty()) {
            throw new RuntimeException("队列空的，没有数据");
        }
        return arr[front];
    }

}
