package com.twelvet.hand.jvm.oom;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 演示栈中的异常：StackOverflowError
 * 默认情况下：count可以达到1w+
 * 手动设置栈大小参数：-Xss256k count2k左右
 */
public class StackError {

    private static int count = 0;

    /**
     * 异常演示
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        count++;
        System.out.println(count);
        main(args);
    }

}
