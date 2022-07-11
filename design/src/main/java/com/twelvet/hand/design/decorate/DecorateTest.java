package com.twelvet.hand.design.decorate;

import com.twelvet.hand.design.decorate.impl.Egg;
import com.twelvet.hand.design.decorate.impl.Ham;
import com.twelvet.hand.design.decorate.impl.HandCake;
import com.twelvet.hand.design.decorate.impl.Seasoning;

/**
 * @author twelvet
 * <p>
 * 测试
 */
public class DecorateTest {

    public static void main(String[] args) {
        Cake cake = new HandCake();
        System.out.println("手抓饼：" + cake.cost());

        Seasoning seasoning = new Seasoning(cake);
        System.out.println("+调味：" + seasoning.cost());

        Egg egg = new Egg(cake);
        System.out.println("+1个鸡蛋：" + egg.cost());

        Ham ham = new Ham(egg);
        System.out.println("+1片火腿：" + ham.cost());


    }

}
