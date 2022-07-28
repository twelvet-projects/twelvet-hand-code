package com.twelvet.hand.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author twelvet
 * <p>
 * 图
 */
public class Graph {

    /**
     * 储存顶点集合
     */
    private final List<String> vertexList;

    /**
     * 储存图对应的领结矩阵
     */
    private final int[][] edges;

    /**
     * 标识边的数目
     */
    private int numOfEdges;

    /**
     * 定义数组，记录某个节点是否被访问
     */
    private boolean[] isVisited;

    public static void main(String[] args) {
        int n = 5;
        String[] vertexs = {"A", "B", "C", "D", "E"};
        Graph graph = new Graph(n);
        for (String vertex : vertexs) {
            graph.insertVertex(vertex);
        }
        // 添加边
        graph.insertEdge(0, 1, 1); // A-B
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);

        // 显示临界矩阵
        graph.showGraph();

        System.out.println("深度遍历");
        graph.dfs();
    }

    public Graph(int n) {
        // 初始化矩阵和vertexList
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        numOfEdges = n;
        isVisited = new boolean[n];
    }

    /**
     * 得到第一个领界节点的下标
     *
     * @param index
     * @return 如果存在就返回对应的下标，否则返回-1
     */
    public int getFirstNeighbor(int index) {
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[index][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    // 根据前一个临界接地那的下标来获取下一个领界节点
    public int getNextNeighbor(int v1, int v2) {
        for (int j = v2 + 1; j < vertexList.size(); j++) {
            if (edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    /**
     * 深度优先遍历算法
     *
     * @param isVisited
     * @param i
     */
    private void dfs(boolean[] isVisited, int i) {
        // 首先我们访问该节点
        System.out.println(getValueByIndex(i) + "->");
        // 将节点设置为已经访问
        isVisited[i] = true;
        // 查找节点i的第一个临界接节点w
        int w = getFirstNeighbor(i);
        while (w != -1) {
            if (!isVisited[w]) {
                dfs(isVisited, w);
            }
            // 如果w节点已经被访问过
            w = getNextNeighbor(i, w);
        }
    }

    // 对dfs进行一个重载，遍历我们所有的节点，并进行dfs
    public void dfs() {
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }

    // 返回节点个数
    public int getNumOfVertex() {
        return vertexList.size();
    }

    // 得到变的数目
    public int getNumOfEdges() {
        return numOfEdges;
    }

    // 返回节点i下标对应的数据0->"A" 1->"B"
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    // 显示图对应的矩阵
    public void showGraph() {
        for (int[] edge : edges) {
            System.out.println(Arrays.toString(edge));
        }
    }

    // 插入节点
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    /**
     * 添加边
     *
     * @param v1     表示点的下标即第几个顶点 "A"-"B" "A"->0 "B"->1
     * @param v2     第二个顶点对应的下标
     * @param weight 表示
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }
}
