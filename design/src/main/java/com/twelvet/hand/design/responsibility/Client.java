package com.twelvet.hand.design.responsibility;

import com.twelvet.hand.design.responsibility.impl.*;

public class Client {

    public static void main(String[] args) {

        //创建相关的审批人
        DepartmentAPProve departmentAPProve = new DepartmentAPProve("张主任");
        CollegeApprove collegeApprove = new CollegeApprove("李院长");
        ViceSchoolMasterApprove viceSchoolMasterApprove = new ViceSchoolMasterApprove("王副校");
        SchoolMasterApprove schoolMasterApprove = new SchoolMasterApprove("佟校长");

        // 需要将各个审批级别的下一个设置好 (处理人构成环形: )
        // 部门
        departmentAPProve.setApprove(collegeApprove);
        // 学院
        collegeApprove.setApprove(viceSchoolMasterApprove);
        // 副校长
        viceSchoolMasterApprove.setApprove(schoolMasterApprove);
        // 校长
        schoolMasterApprove.setApprove(departmentAPProve);


        //创建一个请求
        PurchaseRequest purchaseRequest = new PurchaseRequest(1, 31000, 1);
        // 开始提交处理
        departmentAPProve.processRequest(purchaseRequest);
    }

}
