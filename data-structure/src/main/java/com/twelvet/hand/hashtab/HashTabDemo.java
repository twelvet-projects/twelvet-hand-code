package com.twelvet.hand.hashtab;

import java.util.Scanner;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 、哈希表
 */
public class HashTabDemo {

    public static void main(String[] args) {
        // 创建哈希表
        HashTab hashTab = new HashTab(7);

        // 写一个简单的菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("add 添加雇员");
            System.out.println("list 显示雇员");
            System.out.println("find 查找雇员");
            System.out.println("exit 退出系统");

            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();

                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("请输入要查找的id");
                    id = scanner.nextInt();
                    hashTab.findEmpById(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }

}

// 创建HashTab
class HashTab {
    private final EmpLinkedList[] empLinkedListArray;

    private final int size;

    public HashTab(int size) {
        this.size = size;
        // 初始化
        empLinkedListArray = new EmpLinkedList[size];
        // 这时不要分别初始化每个链表
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    // 添加员工
    public void add(Emp emp) {
        // 根据员工ID，得到该员工应当添加到哪条链表
        int empLinkedListNO = hashFun(emp.id);
        // 将emp添加到对应链表中
        empLinkedListArray[empLinkedListNO].add(emp);
    }

    // 遍历所有链表，遍历hashTab
    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list(i);
        }
    }

    // 根据输入的id，查找雇员
    public void findEmpById(int id) {
        int empLinkedLIstNO = hashFun(id);
        Emp emp = empLinkedListArray[empLinkedLIstNO].findEMpByID(id);
        if (emp != null) {
            System.out.printf("在第%d条链表中找到雇员 id = %d\n", (empLinkedLIstNO + 1), id);
        } else {
            System.out.println("在哈希表中，没有找到该员工");
        }
    }

    // 编写散列函数，使用一个简单取模法
    public int hashFun(int id) {
        return id % size;
    }
}

// 创建一个雇员
class Emp {

    public int id;

    public String name;

    public Emp next;

    public Emp(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}

class EmpLinkedList {
    // 头指针,执行第一个Emp，因此我们这个链表的head，是直接指向第一个Emp
    private Emp head;

    /**
     * 添加家员工到链表
     * 假定当添加雇员时 ID 是自增长 即id的分配总是从小到大
     * 因此我们将该雇员直接加入到本链表最后即可
     *
     * @param emp
     */
    public void add(Emp emp) {
        if (head == null) {
            head = emp;
            return;
        }
        Emp curEmp = head;
        while (curEmp.next != null) {
            // 说明到链表最后
            // 后移
            curEmp = curEmp.next;
        }
        // 退出时直接将emp 加入链表
        curEmp.next = emp;
    }

    /**
     * 遍历链表的雇员信息
     */
    public void list(int no) {
        if (head == null) {
            System.out.println("第" + (no + 1) + "链表为空");
            return;
        }
        System.out.print("第" + (no + 1) + "链表为");
        // 辅助指针
        Emp curEmp = head;
        while (true) {
            System.out.printf("=> id = %d name = %s \n", curEmp.id, curEmp.name);
            if (curEmp.next == null) {
                break;
            }
            // 后移
            curEmp = curEmp.next;
        }
    }

    /**
     * 根据ID查找雇员
     * 如果 找到就返回Emp， 如果没有就返回null
     *
     * @param id
     * @return
     */
    public Emp findEMpByID(int id) {
        if (head == null) {
            System.out.println("链表为空");
            return null;
        }
        // 辅助指针
        Emp curEmp = head;
        // 找到
        // 这是curEmp就指向要查找的雇员
        while (curEmp.id != id) {
            // 退出
            if (curEmp.next == null) {
                // 说明遍历当前链表没有找到改雇员
                curEmp = null;
                break;
            }
            // 后移
            curEmp = curEmp.next;
        }
        return curEmp;
    }

}
