
import java.util.LinkedList;
import java.util.Queue;

public class Diameter{

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


    public static int height(Node root){
        if(root==null){
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static int diameter(Node root){
        if(root == null){
            return 0;
        }


        int leftDiameter = diameter(root.left);
        int leftHeight = height(root.left);

        int rightDiameter = diameter(root.right);

        int rightHeight = height(root.right);

        int selfDiameter = leftHeight + rightHeight + 1;

        return Math.max(selfDiameter, Math.max(rightDiameter, leftDiameter));
    }


    static class Info{
        int height;
        int diameter;

        public Info(int height, int diameter){
            this.height = height;
            this.diameter = diameter;
        }
    }

    public static Info diameterOptimized(Node root){
    if(root == null){
        return new Info(0, 0);
    }

    Info leftInfo = diameterOptimized(root.left);
    Info rightInfo = diameterOptimized(root.right);

    int height = Math.max(leftInfo.height, rightInfo.height) + 1;

    int diameter = Math.max(Math.max(leftInfo.diameter, rightInfo.diameter), leftInfo.height + rightInfo.height + 1);

    return new Info(height, diameter);
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


        System.out.println( height(root));
        System.out.println("diameter : " + diameter(root));
        Info diameter = diameterOptimized(root);
        System.out.println("diameter : " + diameter.diameter);


       
    }
}
