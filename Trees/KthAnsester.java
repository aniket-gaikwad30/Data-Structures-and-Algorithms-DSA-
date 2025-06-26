import java.util.Queue;
import java.util.LinkedList;

public class KthAnsester {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Level Order Traversal (BFS)
    public static void levelOrderTraversal(Node root) {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node currNode = q.remove();
            if (currNode == null) {
                System.out.println();
                if (q.isEmpty()) break;
                q.add(null);
            } else {
                System.out.print(currNode.data + " ");
                if (currNode.left != null) q.add(currNode.left);
                if (currNode.right != null) q.add(currNode.right);
            }
        }
    }

    public static int kthAncestor(Node root, int k, int node) {
        if (root == null) return -1;

        if (root.data == node) return 0;

        int left = kthAncestor(root.left, k, node);
        int right = kthAncestor(root.right, k, node);

        if (left == -1 && right == -1) return -1;

        if (left >= 0 || right >= 0) {
            if (left + right + 1 == k) {
                System.out.println("Kth Ancestor of " + node + " is: " + root.data);
            }
            return left + right + 1;
        }

        return -1;
    }
    public static void main(String[] args) {

         // Sample Tree:
        //         1
        //       /   \
        //      2     3
        //     / \   / \
        //    4   5 6   7

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Level Order Traversal:");
        levelOrderTraversal(root);
        
    }
}
