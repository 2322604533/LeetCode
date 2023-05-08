package zeus.arithmetic;


import java.util.ArrayList;
import java.util.List;


// L133
public class CloneGraph {

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> neighbors;
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

    public Node CloneGraph() {
        return null;
    }
}
