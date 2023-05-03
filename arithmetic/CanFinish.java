package zeus.arithmetic;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class CanFinish {

    /**
     * 算法思想:拓扑排序；
     * 数据结构：邻接表，入度数组，队列
     * 拓扑排序背景：得到的有向图的拓扑排序的结果不唯一；
     * 核心是检验图中是否有环；(无向图中检验是否有环，使用的数据结构是使用并查集)；
     * 使用邻接表来存储图，用一个队列存储各个结点的，如果入度为0的结点将其放入队列。
     * 如果队列非空就取队首入度为0的结点，将这节点输出到结果集合，并且将这结点的所有邻接点的入度减去1
     * 如果被减1的结点的入度变成0后，就将该结点继续入队。最后如果结果集合中的顶点个数和课程数相等就结束
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if (numCourses <= 0) return false;

        int pLen = prerequisites.length;

        if (pLen == 0) return true;

        int[] inDegree = new int[numCourses];   // 入度数组

        HashSet<Integer>[] adj = new HashSet[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj[i] = new HashSet<>();
        }

        for (int[] p : prerequisites) {
            inDegree[p[0]]++;
            adj[p[1]].add(p[0]);
        }

        Queue<Integer> queue = new LinkedList<>();

        // 首先加入入度为0的结点
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // 记录已经出队的课程数量
        int courseNum = 0;
        while (!queue.isEmpty()) {
            int top = queue.poll();
            courseNum++;

            // 遍历当前出队结点的所有后继结点
            for (int successor : adj[top]) {
                inDegree[successor]--;
                if (inDegree[successor] == 0) {
                    queue.add(successor);
                }
            }
        }
        return (courseNum == numCourses) ? true : false;
    }
}
