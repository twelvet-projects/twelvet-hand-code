package com.twelvet.hand.tree;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 二叉树(比父节点小的数放左边 ， 大的放右边)
 */
public class BinaryTreeDemo {

    public static void main(String[] args) {
        // 需要创建一颗二叉树
        BinaryTree binaryTree = new BinaryTree();
        // 创建需要的节点
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");

        // 说明，我们先手动创建该二叉树，后面我们学习递归的方式创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRoot(root);

        System.out.println("前序遍历");
        binaryTree.perOrder();

        System.out.println("中遍历");
        binaryTree.infixOrder();

        System.out.println("后续遍历");
        binaryTree.postOrder();

        // 前序搜索
        System.out.println("前序搜索");
        HeroNode perNode = binaryTree.perOrderSearch(5);
        if (perNode != null) {
            System.out.printf("找到了，信息为 no = %d name = %s\n", perNode.getNo(), perNode.getName());
        } else {
            System.out.printf("没有找到 no = %d\n", 5);
        }

        // 中序搜索
        System.out.println("中序搜索");
        HeroNode infixNode = binaryTree.infixOrderSearch(5);
        if (infixNode != null) {
            System.out.printf("找到了，信息为 no = %d name = %s\n", infixNode.getNo(), infixNode.getName());
        } else {
            System.out.printf("没有找到 no = %d\n", 5);
        }

        // 后续搜索
        System.out.println("后续搜索");
        HeroNode postNode = binaryTree.postOrderSearch(5);
        if (postNode != null) {
            System.out.printf("找到了，信息为 no = %d name = %s\n", postNode.getNo(), postNode.getName());
        } else {
            System.out.printf("没有找到 no = %d\n", 5);
        }

        System.out.println("删除前，前序遍历");
        binaryTree.perOrder();
        binaryTree.delNode(5);
        System.out.println("删除后，前序遍历");
        binaryTree.perOrder();

    }
}

// 定义tree二叉树
class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    /**
     * 删除节点
     */
    public void delNode(int no) {
        if (root != null) {
            // 如果只有一个root节点，这里立即判断root是不是就是要删除的节点
            if (root.getNo() == no) {
                root = null;
            } else {
                root.delNOde(no);
            }
        } else {
            System.out.println("空树，不能删除");
        }
    }

    // 前序遍历
    public void perOrder() {
        if (this.root != null) {
            this.root.perOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    // 中序遍历
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    // 后续遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    // 前序遍历查找
    public HeroNode perOrderSearch(int no) {
        if (root != null) {
            return root.perOrderSearch(no);
        } else {
            return null;
        }
    }

    // 中序遍历查找
    public HeroNode infixOrderSearch(int no) {
        if (root != null) {
            return root.infixOrderSearch(no);
        } else {
            return null;
        }
    }

    // 后序遍历查找
    public HeroNode postOrderSearch(int no) {
        if (root != null) {
            return root.postOrderSearch(no);
        } else {
            return null;
        }
    }
}

class HeroNode {
    private int no;

    private String name;

    private HeroNode left;

    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * 递归删除节点
     * 1.如果删除的节点是叶子节点，则删除该节点
     * 2.如果删除的节点是非叶子节点，则删除该子树
     */
    public void delNOde(int no) {

        /**
         * 1.因为我们的二叉树是单向的，所以我们是判断当前节点的子节点是否需要删除节点，而不能去判断当前这个节点是不是需要删除节点
         * 2.如果当前节点的左子节点不为空，并且左子节点就是要删除的节点，就将this.left = null，并且返回（结束递归删除）
         * 3.如果当前节点的右子节点不为空，并右字节集电就是要删除节点，就将this.left = null；并且返回（结束递归删除）
         * 4.如果第二第三步没有删除节点，那么我们就需要向左子树进行递归删除
         * 5.如果第四步也没有，则应当向右子树进行递归删除
         */

        // 2.如果当前节点的左子节点不为空，并且左子节点就是要删除的节点，就将this.left = null，并且返回（hu结束递归删除）
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }

        // 3.如果当前节点的右子节点不为空，并右字节集电就是要删除节点，就将this.left = null；并且返回（接受递归删除）
        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }

        // 4.如果第二第三步没有删除节点，那么我们就需要向左子树进行递归删除
        if (this.left != null) {
            this.left.delNOde(no);
        }

        // 5.如果第四步也没有，则应当向右子树进行递归删除
        if (this.right != null) {
            this.right.delNOde(no);
        }

    }

    // 编写前序遍历的方法 从左遍历，到右 遍历前输出
    public void perOrder() {
        // 先输出父节点
        System.out.println(this);
        if (this.left != null) {
            this.left.perOrder();
        }
        // 递归向右子树前序遍历
        if (this.right != null) {
            this.right.perOrder();
        }
    }

    // 中序遍历 从左遍历，到右 遍历时输出
    public void infixOrder() {
        // 递归向左子数递归遍历
        if (this.left != null) {
            this.left.perOrder();
        }
        // 输出父节点
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    // 后序遍历 从左遍历，到右 遍历完再输出
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        // 输出父节点
        System.out.println(this);
    }


    /**
     * 前序遍历查找
     *
     * @return 如果找到就返回该node，如果没有找到返回null
     */
    public HeroNode perOrderSearch(int no) {
        // 比较当前节点是不是
        if (this.no == no) {
            return this;
        }
        // 1.则判断当前节点的左子节点是否为空，如果不为空，则递归前序查找
        // 2.如果左递归前序查找，找到节点则返回
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.perOrderSearch(no);
        }
        if (resNode != null) {
            // 说明我们在左子树找到
            return resNode;
        }
        // 1.左递归前序查找，找到节点，则返回，否则继续判断
        // 2.当前的节点的右子节点是否为空，如果不为空，则继续向右递归前序查找
        if (this.right != null) {
            resNode = this.right.perOrderSearch(no);
        }
        return resNode;
    }

    // 中序查找
    public HeroNode infixOrderSearch(int no) {
        // 判断当前节点的左子节点是否为空，如果不为空，则递归中序查找
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.infixOrderSearch(no);
        }

        if (resNode != null) {
            // 说明我们在左子树找到
            return resNode;
        }
        // 如果找到则返回如果没有找到，就和当前节点比较，如果是则返回当前节点
        if (this.no == no) {
            return this;
        }

        // 否则继续进行右递归中序查找
        if (this.right != null) {
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;
    }

    // 后续查找
    public HeroNode postOrderSearch(int no) {
        // 判断当前节点的左子节点是否为空，如果不为空，则递归中序查找
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.postOrderSearch(no);
        }

        if (resNode != null) {
            // 说明我们在左子树找到
            return resNode;
        }
        // 说明左子树递归进行后续遍历查找
        if (this.right != null) {
            resNode = this.right.postOrderSearch(no);
        }

        if (resNode != null) {
            return resNode;
        }

        // 否则继续进行右递归中序查找
        if (this.no == no) {
            return this;
        }
        return resNode;
    }

}
