package com.twelvet.hand.huffmancode;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @author twelvet
 * <p>
 * 赫夫曼压缩数据
 */
public class HuffmanCode {

    public static void main(String[] args) {
        // 压缩文件
        /*String srcFile = "C:\\Users\\admin\\Desktop\\demo\\workspace.xml";
        String dstFile = "C:\\Users\\admin\\Desktop\\demo\\dst.zip";

        zipFile(srcFile, dstFile);
        System.out.println("压缩文件成功");*/

        // 解压文件
        String srcFile = "C:\\Users\\admin\\Desktop\\demo\\dst.zip";
        String dstFile = "C:\\Users\\admin\\Desktop\\demo\\workspace.xml";

        unzipFile(srcFile, dstFile);
        System.out.println("解压文件成功");

        /*String content = "i like like like java do you like a java";
        byte[] contentBytes = content.getBytes(StandardCharsets.UTF_8);
        System.out.println(contentBytes.length);

        byte[] huffmanCodesBytes = huffmanZip(contentBytes);
        System.out.println("压缩后的结果是：" + Arrays.toString(huffmanCodesBytes) + " 长度：" + huffmanCodesBytes.length);

        // 测试byteToBitString
        System.out.println(byteToBitString(true, (byte) 1));

        byte[] sourceBytes = decode(huffmanCodes, huffmanCodesBytes);
        System.out.println("原来的字符串" + new String(sourceBytes));*/
        /*List<Node> nodes = getNodes(contentBytes);
        System.out.println(nodes);

        // 测试创建的二叉树
        System.out.println("赫夫曼树");
        Node huffmanTreeRoot = createHuffmanTree(nodes);
        huffmanTreeRoot.perOrder();

        // 是否生成了对应的赫夫曼编码
        getCodes(huffmanTreeRoot);
        System.out.println("生成的赫夫曼编码表");
        System.out.println(huffmanCodes);

        byte[] zip = zip(contentBytes, huffmanCodes);
        System.out.println(Arrays.toString(zip));*/

        // 发送huffmanCodeBytes数组

    }

    /**
     * 将一个文件进行压缩
     *
     * @param srcFile 传入希望压缩的文件路径
     * @param dstFile 压缩后将文件放到哪个目录下
     */
    public static void zipFile(String srcFile, String dstFile) {

        try (
                // 创建一个文件的输入流
                FileInputStream is = new FileInputStream(srcFile);
                // 创建文件的输出流，存放压缩文件
                OutputStream os = new FileOutputStream(dstFile);
                // 创建一个和文件输出流关联的ObjectOutputStream
                ObjectOutputStream oos = new ObjectOutputStream(os);
        ) {
            // 创建一个和源文件大小一样的byte数组
            byte[] b = new byte[is.available()];
            // 读取文件
            is.read(b);
            // 直接对源文件压缩
            byte[] huffmanBytes = huffmanZip(b);
            // 把赫夫曼编码后的字节数组写入压缩文件
            oos.writeObject(huffmanBytes);

            // 这里我们以对象流的方式些人赫夫曼编码 是为了以后我们恢复源文件时使用
            // 注意一定要把赫夫曼编码写入压缩文件
            oos.writeObject(huffmanCodes);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 完成对压缩文件的解压
     *
     * @param zipFile 准备压缩的文件
     * @param dstFile 将文件压缩到哪个路径
     */
    public static void unzipFile(String zipFile, String dstFile) {
        try (
                // 定义一个文件输入流
                InputStream is = new FileInputStream(zipFile);
                // 定义一个对象输入流
                ObjectInputStream ois = new ObjectInputStream(is);
                // 定义文件的输出流
                OutputStream os = new FileOutputStream(dstFile);
        ) {
            byte[] huffmanBytes = (byte[]) ois.readObject();
            Map<Byte, String> huffmanCodes = (Map<Byte, String>) ois.readObject();
            byte[] bytes = decode(huffmanCodes, huffmanBytes);
            // 写入数据到dstFile文件
            os.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 编写一个方法，完成对压缩数据的解码
     *
     * @param huffmanCodes 赫夫曼编码表map
     * @param huffmanBytes 赫夫曼编码得到的字节数组
     * @return 就是原来的字符串对应的数组
     */
    private static byte[] decode(Map<Byte, String> huffmanCodes, byte[] huffmanBytes) {

        // 1. 先得到huffmanBytes对应的二进制的字符串,形式1010100010111...
        StringBuilder stringBuilder = new StringBuilder();
        // 将byte数组转成二进制字符串
        for (int i = 0; i < huffmanBytes.length; i++) {
            boolean flag = (i == huffmanBytes.length - 1);
            stringBuilder.append(byteToBitString(!flag, huffmanBytes[i]));
        }
        // 把字符串安装指定的赫夫曼编码进行解码
        // 把赫夫曼编码表进行调整，因为反向查询a->100 100->a
        Map<String, Byte> map = new HashMap<>();
        for (Map.Entry<Byte, String> byteStringEntry : huffmanCodes.entrySet()) {
            map.put(byteStringEntry.getValue(), byteStringEntry.getKey());
        }
        // 创建要给集合存放byte
        List<Byte> list = new ArrayList<>();
        for (int i = 0; i < stringBuilder.length(); ) {
            int count = 1; // 小的计算器
            boolean flag = true;
            Byte b = null;
            while (flag) {
                // 取出一个'1' '0'
                // i 不动，让count移动，指定匹配到一个字符
                String key = stringBuilder.substring(i, i + count);
                b = map.get(key);
                if (b == null) {// 说明没有匹配到
                    count++;
                } else {
                    // 匹配到
                    flag = false;
                }
            }
            list.add(b);
            i += count;// i 直接移动到count
        }

        // 当for循环结束后，我们list中就存放了所有字符"i like like like java do you like a java"
        // 把list中的数据放入到byte[]并返回
        byte[] b = new byte[list.size()];
        for (int i = 0; i < b.length; i++) {
            b[i] = list.get(i);
        }
        return b;
    }

    /**
     * 完成数据的解压
     * 1. 将huffmanCodeBytes [-88, -65, -56, -65, -56, -65, -55, 77, -57, 6, -24, -14, -117, -4, -60, -90, 28]
     * 重写先转成赫夫曼编码对应的二进制的字符串"1010100010111..."
     * 2. 赫夫曼编码对应的二进制的字符串"1010100010111..."=>对照赫夫曼编码=>"i like like like java do you like a java"
     *
     * @param flag 如果是true则需要补高位,最后一个字节无需补高位
     * @param b    传入的byte
     * @return 是该b对应的二进制字符串(注意是按补码返回)
     */
    private static String byteToBitString(boolean flag, byte b) {

        // 使用变量保存 b
        int temp = b;
        // 如果是正数我们还存在补高位
        if (flag) {
            temp |= 256;
        }

        String str = Integer.toBinaryString(temp);

        if (flag || temp < 0) {
            return str.substring(str.length() - 8);
        } else {
            return str;
        }

    }

    /**
     * 使用一个方法将前面的方法封装起来，便于调用
     *
     * @param bytes 原始的字符串对应的字节数组
     * @return 是经过赫夫曼编码处理后的字节数组(压缩后的数组)
     */
    private static byte[] huffmanZip(byte[] bytes) {
        List<Node> nodes = getNodes(bytes);
        // 根据nodes创建赫夫曼树
        Node huffmanTreeRoot = createHuffmanTree(nodes);
        // 对应的赫夫曼编码
        Map<Byte, String> huffmanCodes = getCodes(huffmanTreeRoot);
        // 根据生成的赫夫曼编码，压缩后的赫夫曼编码字节数组
        return zip(bytes, huffmanCodes);
    }

    /**
     * 编写一个方法，将字符串对应的byte[]数组，通过生成的赫夫曼编码表，返回一个赫夫曼编码表压缩后的字节数组
     *
     * @param bytes        这是原始的字符串对应的byte[]
     * @param huffmanCodes 生成的赫夫曼map
     * @return
     */
    private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
        // 1. 利用huffmanCodes将bytes转成赫夫曼编码对应的字符串
        StringBuilder stringBuilder = new StringBuilder();

        // 遍历bytes数组
        for (byte b : bytes) {
            stringBuilder.append(huffmanCodes.get(b));
        }
        // System.out.println("测试 stringBuilder = " + stringBuilder.toString());
        int len = (stringBuilder.length() + 7) / 8;

        // 创建存储压缩后的byte数组
        byte[] huffmanCodeBytes = new byte[len];
        // 记录是第几个byte
        int index = 0;
        // 每8位对应一个byte，所以步长8
        for (int i = 0; i < stringBuilder.length(); i += 8) {
            String strByte;

            if (i + 8 > stringBuilder.length()) { // 不够8位
                strByte = stringBuilder.substring(i);
            } else {
                strByte = stringBuilder.substring(i, i + 8);
            }
            // 将strByte转成一个byte放入到huffmanCodeBytes
            huffmanCodeBytes[index] = (byte) Integer.parseInt(strByte, 2);
            index++;
        }

        return huffmanCodeBytes;
    }


    // 生成赫夫曼树对应的赫夫曼编码
    // 1. 将赫夫曼编码表储存放在Map<Byte, String> 形式
    static Map<Byte, String> huffmanCodes = new HashMap<>();
    // 32->01 97->100 100->11000等等【形式】
    static StringBuilder stringBuilder = new StringBuilder();
    // 2. 在生成赫夫曼编码，需要去拼接路径，定义一个StringBuilder存储某个叶子节点的路径

    // 为了调用方便，重载getCodes
    private static Map<Byte, String> getCodes(Node root) {
        if (root == null) {
            return null;
        }
        // 处理root的左子树
        getCodes(root.left, "0", stringBuilder);
        // 处理右子树
        getCodes(root.right, "1", stringBuilder);
        return huffmanCodes;
    }

    /**
     * 将传入的node节点的所有叶子结点的赫夫曼编码，并放到huffmanCodes集合
     *
     * @param node          传入节点
     * @param code          路径：左子节点是0，右子节点是1
     * @param stringBuilder 用于拼接路径
     */
    private static void getCodes(Node node, String code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        // 将code加入到stringBuilder2
        stringBuilder2.append(code);
        // 如果node == null不处理
        if (node != null) {
            // 判断当前node 是叶子节点还是非叶子节点
            if (node.data == null) { // 非叶子节点
                // 递归处理
                // 向左递归
                getCodes(node.left, "0", stringBuilder2);
                // 向右递归
                getCodes(node.right, "1", stringBuilder2);
            } else {// 说明是一个叶子节点
                // 就表示找到某个叶子节点的最后
                huffmanCodes.put(node.data, stringBuilder2.toString());
            }
        }
    }


    /**
     * @param bytes 接受一个字节数组
     * @return 返回的就是List形式
     */
    private static List<Node> getNodes(byte[] bytes) {
        // 1. 创建一个ArrayList
        List<Node> nodes = new ArrayList<>();
        // 存储每一个byte出现的次数->map
        Map<Byte, Integer> counts = new HashMap<>();
        for (byte b : bytes) {
            counts.merge(b, 1, Integer::sum);
        }

        // 把每一个键值对转成一个Node对象，并加入到node集合
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }

    private static Node createHuffmanTree(List<Node> nodes) {
        while (nodes.size() > 1) {
            // 排序
            Collections.sort(nodes);
            // 取出第一颗最小的二叉树
            Node left = nodes.get(0);
            // 取出第二颗最小的二叉树
            Node right = nodes.get(1);
            // 创建一颗新的二叉树。它的根节点没有data只有权值
            Node parent = new Node(null, left.weight + right.weight);
            parent.left = left;
            parent.right = right;

            // 将已处理的两颗二叉树从nodes删除
            nodes.remove(left);
            nodes.remove(right);
            // 将新的二叉树加入到nodes
            nodes.add(parent);
        }
        // nodes 最后的节点，就是赫夫曼的根节点
        return nodes.get(0);
    }

}

class Node implements Comparable<Node> {
    /**
     * 存放数据本身， 比如'a' => 97 ' ' => 32
     */
    Byte data;

    /**
     * 权值，标识字符出现次数
     */
    int weight;

    Node left;

    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    /**
     * 前序遍历
     */
    public void perOrder() {

        System.out.println(this);
        if (this.left != null) {
            this.left.perOrder();
        }

        if (this.right != null) {
            this.right.perOrder();
        }

    }
}