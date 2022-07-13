package com.twelvet.hand.design.strategy.impl;

import com.twelvet.hand.design.strategy.MemberStrategy;

// 高级会员类 20%折扣
public class AdvanceMemberStrategy implements MemberStrategy {
    @Override
    public double calcPrice(double price, int n) {
        return price * n - price * n * 0.2;
    }
}