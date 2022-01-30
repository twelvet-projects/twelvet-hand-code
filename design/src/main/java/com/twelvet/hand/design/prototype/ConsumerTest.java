package com.twelvet.hand.design.prototype;

import java.util.Date;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 测试类
 */
public class ConsumerTest {

    public static void main(String[] args) {
        Date date = new Date();
        TwelveTPrototype twelveTPrototype = new TwelveTPrototype("twelvet", date);
        System.out.println(twelveTPrototype);

        System.out.println("===========进行克隆=============");

        TwelveTPrototype clone = twelveTPrototype.clone();

        System.out.println("===========修改原数据（并不会对克隆数据造成影响）=============");

        twelveTPrototype.setDate(new Date(1643548074000L));

        System.out.println(twelveTPrototype);

        System.out.println("===========克隆数据=============");
        System.out.println(clone);

    }

}
