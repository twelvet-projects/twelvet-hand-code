package com.twelvet.hand.design.decorate.impl;

import com.twelvet.hand.design.decorate.Cake;

public class Egg extends Seasoning {

    public Egg(Cake cake) {
        super(cake);
    }

    /**
     * 鸡蛋两块
     *
     * @return int
     */
    public int cost() {
        return super.cost() + 2;
    }
}