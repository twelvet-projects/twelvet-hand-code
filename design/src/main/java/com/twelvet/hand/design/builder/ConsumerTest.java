package com.twelvet.hand.design.builder;

import com.twelvet.hand.design.builder.pojo.Product;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 测试类
 */
public class ConsumerTest {

    public static void main(String[] args) {
        Work work = new Work();
        Product product = work.phone("小米手机")
                .getProduct();
        System.out.println(product);
    }

}
