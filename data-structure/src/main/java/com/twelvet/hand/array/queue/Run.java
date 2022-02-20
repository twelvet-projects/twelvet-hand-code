package com.twelvet.hand.array.queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 启动入口
 */
public class Run {

    private final static Logger log = LoggerFactory.getLogger(Run.class);

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
