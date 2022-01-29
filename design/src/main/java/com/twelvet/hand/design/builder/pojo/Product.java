package com.twelvet.hand.design.builder.pojo;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 建造的产品
 */
public class Product {

    /**
     * 手机
     */
    private String phone = "手机";

    /**
     * 电脑
     */
    private String computer = "电脑";

    /**
     * 路由器
     */
    private String router = "路由器";

    /**
     * 手表
     */
    private String watch = "手表";

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getComputer() {
        return computer;
    }

    public void setComputer(String computer) {
        this.computer = computer;
    }

    public String getRouter() {
        return router;
    }

    public void setRouter(String router) {
        this.router = router;
    }

    public String getWatch() {
        return watch;
    }

    public void setWatch(String watch) {
        this.watch = watch;
    }

    @Override
    public String toString() {
        return "Product{" +
                "phone='" + phone + '\'' +
                ", computer='" + computer + '\'' +
                ", router='" + router + '\'' +
                ", watch='" + watch + '\'' +
                '}';
    }
}
