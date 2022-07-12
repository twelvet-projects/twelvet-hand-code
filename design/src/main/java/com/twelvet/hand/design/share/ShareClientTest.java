package com.twelvet.hand.design.share;

import com.twelvet.hand.design.share.impl.User;
import com.twelvet.hand.design.share.impl.WebSiteFactory;


public class ShareClientTest {
    public static void main(String[] args) {
        // 创建一个工厂类
        WebSiteFactory factory = new WebSiteFactory();

        // 客户要一个以新闻形式发布的网站
        WebSite news = factory.getWebSiteCategory("新闻");
        news.use(new User("jerry"));

        // 客户要一个以博客形式发布的网站
        WebSite blog3 = factory.getWebSiteCategory("博客");
        blog3.use(new User("tom"));

        System.out.println("网站的分类共有：" + factory.getWebSiteCount());
    }
}