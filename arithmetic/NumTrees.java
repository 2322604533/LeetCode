package zeus.arithmetic;

public class NumTrees {
    /**
     * n个结点最多有多少个不同的二叉查找树
     * @param n
     * @return
     */
    public static int numTrees(int n) {
        int G[] = new int[n+1];

        G[0] = 1;
        G[1] = 1;
        for (int i = 2; i < n+1; i++) {
            for (int j = 1; j < i+1; j++) {
                G[i] = G[i] + G[j-1]*G[i-j];
            }
        }
        return G[n];
    }

    public static void main(String[] args) {
        int res = numTrees(3);
        System.out.println("res:"+res);
    }
}
