import java.util.LinkedList;
import java.util.Queue;

public class IsSubTree {

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

    // Level Order Traversal
    public static void levelOrderTraversal(Node root) {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node currNode = q.remove();
            if (currNode == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currNode.data + " ");
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
    }

    // Check if two trees are identical
    public static boolean isIdentical(Node root, Node subroot) {
        if (root == null && subroot == null) {
            return true;
        }
        if (root == null || subroot == null || root.data != subroot.data) {
            return false;
        }

        return isIdentical(root.left, subroot.left) && isIdentical(root.right, subroot.right);
    }

    // Check if subroot is subtree of root
    public static boolean isSubTree(Node root, Node subroot) {
        if (subroot == null) return true;   // Empty tree is always a subtree
        if (root == null) return false;

        if (isIdentical(root, subroot)) {
            return true;
        }

        return isSubTree(root.left, subroot) || isSubTree(root.right, subroot);
    }

    public static void main(String[] args) {
        // Main tree:
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

        System.out.println("Level Order Traversal of Main Tree:");
        levelOrderTraversal(root);

        // Subtree to test:
        //      2
        //     / \
        //    4   5
        Node subroot = new Node(2);
        subroot.left = new Node(4);
        subroot.right = new Node(5);

        System.out.println("Is subtree: " + isSubTree(root, subroot));
    }
}
