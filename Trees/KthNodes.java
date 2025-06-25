
import java.util.LinkedList;
import java.util.Queue;

public class KthNodes{

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


    public static void kthnodes(Node root, int k, int level){
        if(root == null){
            return;
        }

        if(level == k){
            System.out.print(root.data + " ");
        }
        kthnodes(root.left , k, level + 1);
        kthnodes(root.right, k , level + 1);
    }


    

    public static void main(String[] args) {
        // Sample tree:
        //         1
        //       /   \
        //      2     3
        //     / \   / \
        //    4   5 6   7

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        // root.left.left.left = new Node(89);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Level Order Traversal:");
        levelOrderTraversal(root);

        kthnodes(root, 2, 1);




       
    }
}
