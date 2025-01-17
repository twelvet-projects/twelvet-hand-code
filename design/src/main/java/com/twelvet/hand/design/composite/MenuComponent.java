package com.twelvet.hand.design.composite;

/**
 * 抽象根节点
 */
public abstract class MenuComponent {
    //菜单名
    protected String name;
    //菜单层级
    protected int level;

    //添加子菜单
    public void add(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    //移除子菜单
    public void remove(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    //获取指定的子菜单
    public MenuComponent getChild(int index) {
        throw new UnsupportedOperationException();
    }

    //获取菜单名称
    public String getName() {
        return name;
    }

    //打印菜单名称(子菜单或菜单项)
    public abstract void print();
}