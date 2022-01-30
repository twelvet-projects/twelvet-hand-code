package com.twelvet.hand.design.prototype;

import java.util.Date;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 实现原型克隆
 */
public class TwelveTPrototype implements Cloneable {

    private String name;

    private Date date;

    public TwelveTPrototype(String name, Date date) {

        this.name = name;
        this.date = date;

    }

    /**
     * 重写属性克隆
     *
     * @return TwelveTPrototype
     */
    @Override
    public TwelveTPrototype clone() {
        try {
            TwelveTPrototype clone = (TwelveTPrototype) super.clone();
            clone.date = (Date) this.date.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "TwelveTPrototype{" +
                "name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}
