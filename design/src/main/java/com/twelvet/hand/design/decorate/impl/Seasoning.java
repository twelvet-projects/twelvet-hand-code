package com.twelvet.hand.design.decorate.impl;

import com.twelvet.hand.design.decorate.Cake;

public class Seasoning extends Cake {

    private final Cake cake;

    public Seasoning(Cake cake) {
        this.cake = cake;
    }

    /**
     * 调料不用钱
     *
     * @return int
     */
    @Override
    public int cost() {
        return cake.cost();
    }

}