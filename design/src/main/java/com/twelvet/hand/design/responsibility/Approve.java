package com.twelvet.hand.design.responsibility;

import com.twelvet.hand.design.responsibility.impl.PurchaseRequest;

public abstract class Approve {

    /**
     * 下一个处理者
     */
    public Approve approve;
    /**
     * 名字
     */
    public String name;

    public Approve(String name) {
        super();
        this.name = name;
    }

    /**
     * 下一个处理者
     *
     * @param approve
     */
    public void setApprove(Approve approve) {
        this.approve = approve;
    }

    /**
     * 处理审批请求的方法，得到一个请求，处理是子类完成，因此该方法做成抽象
     *
     * @param purchaseRequest
     */
    public abstract void processRequest(PurchaseRequest purchaseRequest);

    public String getName() {
        return name;
    }

}
