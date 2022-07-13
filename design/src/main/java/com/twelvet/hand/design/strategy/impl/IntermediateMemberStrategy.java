package com.twelvet.hand.design.strategy.impl;

import com.twelvet.hand.design.strategy.MemberStrategy;

// 中级会员 打百分之10的折扣
public class IntermediateMemberStrategy implements MemberStrategy {
    @Override
    public double calcPrice(double price, int n) {
        return (price * n) - price * n * 0.1;
    }
}