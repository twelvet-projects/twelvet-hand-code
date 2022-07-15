package com.twelvet.hand.design.responsibility.impl;

import com.twelvet.hand.design.responsibility.Approve;

/**
 * 学院
 */
public class CollegeApprove extends Approve {

    public CollegeApprove(String name) {
        super(name);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
        // TODO Auto-generated method stub
        if (purchaseRequest.getPrice() < 5000 && purchaseRequest.getPrice() <= 10000) {
            System.out.println(" 请求编号 id = " + purchaseRequest.getId() + " 被 " + this.name + "处理");
        } else {
            approve.processRequest(purchaseRequest);
        }
    }

}