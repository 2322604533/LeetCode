package zeus.arithmetic;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你无向连通图中一个节点的引用，请你返回该图的深拷贝（克隆）。
 */
// L133
public class CloneGraph {

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> neighbors; // 相邻的结点

        public Node() {
            this.val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int val) {
            this.val = val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int val, ArrayList<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }
    }

    // 获得一个内部类，或者将内部类改成静态内部类
    public Node newNode() {
        return new Node();
    }

    /**
     * 为了防止多次遍历同一个节点，陷入死循环，
     * 我们需要用一种数据结构记录已经被克隆过的节点。
     * 利用哈希表
     * @param node
     * @return
     */
    public Node cloneGraph(Node node) {
        // 使用 visited 记录被访问过的结点，以免造成死循环
        Map<Node, Node> visited = new HashMap<>();
        return dfs(node, visited);  // return clonNode
    }

    /**
     * Map<Node,Node> 前者为原始结点，后者为克隆的结点
     * @param node
     * @param visited
     * @return
     */
    private Node dfs(Node node, Map<Node, Node> visited) {
        if (node == null) return null;

        // 如果原图的结点已经被访问过，则直接从哈希表中取出对应的结点返回
        if (visited.containsKey(node)) return visited.get(node);

        // 对结点进行克隆，每次克隆前都new一个链表来存储邻接点的相邻结点
        Node clonNode = new Node(node.val, new ArrayList<>());

        // 用哈希表未被访问的原结点和被克隆的结点
        visited.put(node, clonNode);

        // 遍历原图该结点的邻接点，并且更新邻接结点的列表
        for (Node n : node.neighbors) {
            clonNode.neighbors.add(dfs(n, visited));
        }
        return clonNode;
    }
}
