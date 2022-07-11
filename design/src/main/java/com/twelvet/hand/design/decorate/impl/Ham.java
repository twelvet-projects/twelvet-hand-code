package com.twelvet.hand.design.decorate.impl;

import com.twelvet.hand.design.decorate.Cake;

public class Ham extends Seasoning {
    public Ham(Cake cake) {
        super(cake);
    }

    /**
     * 火腿加两块
     *
     * @return int
     */
    public int cost() {
        return super.cost() + 2;
    }
}