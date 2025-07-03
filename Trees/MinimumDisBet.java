import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumDisBet {

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

    // Helper function to find path from root to given node
    public static ArrayList<Node> findPath(Node root, int n, ArrayList<Node> path) {
        if (root == null) return null;

        path.add(root);

        if (root.data == n) return path;

        if (root.left != null && findPath(root.left, n, path) != null) return path;
        if (root.right != null && findPath(root.right, n, path) != null) return path;

        path.remove(path.size() - 1);
        return null;
    }

    // Main function to find Lowest Common Ancestor
    public static Node findLowestCommonAncestor(Node root, int n1, int n2) {
        ArrayList<Node> path1 = findPath(root, n1, new ArrayList<>());
        ArrayList<Node> path2 = findPath(root, n2, new ArrayList<>());

        if (path1 == null || path2 == null) return null;

        int i;
        for (i = 0; i < path1.size() && i < path2.size(); i++) {
            if (!path1.get(i).equals(path2.get(i))) {
                break;
            }
        }

        return path1.get(i - 1);
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

        int n1 = 4, n2 = 5;
        Node lca = findLowestCommonAncestor(root, n1, n2);
        if (lca != null) {
            System.out.println("Lowest Common Ancestor of " + n1 + " and " + n2 + " is: " + lca.data);
        } else {
            System.out.println("Lowest Common Ancestor not found.");
        }
    }
}
