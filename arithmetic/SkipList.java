package zeus.arithmetic;


import java.util.Random;

/**
 * 设计一个跳表
 * 该跳表每一层都是有序的链表
 */
public class SkipList {

    private int level = 8;  // 将跳表设计为8层

    Random random = new Random();

    class Node {
        private int val;

        Node[] next = new Node[level];  // 记录每一层的next,netx[i]表示当前结点第i层的next

        Node (int val) {
            this.val = val;
        }
    }

    private Node dummyHead = new Node(-1);

    public void Skiplist() {
        
    }

    // 找到每一层小于target的最大数的结点
    public void find(int target, Node[] preNodes) {
        Node cur = dummyHead;

        // 自上而下找到每层的小于target的最大数的结点
        for (int i = level - 1; i >= 0; i--) {
            // 找到当前第i层的比target还要小的数的最大数的结点
            while (cur.next[i] != null && cur.next[i].val < target) cur = cur.next[i];

            // 将当前i层的小于target的最大数的结点填入到该数组中
            preNodes[i] = cur;
        }
    }

    // 查询
    public boolean search(int target) {
        Node[] levelNodes = new Node[level];    // 每一层的结点数

        find(target, levelNodes);

        return levelNodes[0].next[0] != null && levelNodes[0].next[0].val == target;
    }

    // 添加
    public void add(int target) {
        Node[] levelNodes = new Node[level];
        find(target, levelNodes);
        Node node = new Node(target);
        for (int i = 0; i < level; i++) {
            // 插入一个结点
            node.next[i] = levelNodes[i].next[i];
            levelNodes[i].next[i] = node;
            if (random.nextInt(2) == 0) break;
        }
    }

    // 擦除
    public boolean erase(int target) {
        Node[] levelNodes = new Node[level];

        find(target, levelNodes);

        Node node = levelNodes[0].next[0];

        // 结点不存在
        if (node == null || node.val != target) return false;

        for (int i = 0; (i < level && levelNodes[i].next[i] == node); i++)
            levelNodes[i].next[i] = levelNodes[i].next[i].next[i];
        return true;
    }

    public static void main(String[] args) {

    }
}
