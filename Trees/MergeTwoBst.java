import java.util.ArrayList;

public class MergeTwoBst {


    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public static void getInOrder(Node root, ArrayList<Integer> arr){
        if(root == null){
            return;
        }
        getInOrder(root.left, arr);
        arr.add(root.data);
        getInOrder(root.right, arr);
    }

     public static Node mergeTree(ArrayList<Integer> arr, int start, int end){
        if(start > end){
            return null;
        }

        int mid = (start + end)/ 2;

        Node root = new Node(arr.get(mid));
        root.left = mergeTree(arr, start, mid-1);
        root.right = mergeTree(arr, mid + 1, end);
        return root;
    }

    public static Node mergeTwoBSTs(Node root1, Node root2){
        //step 1
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInOrder(root1, arr1);

        //step 2
        ArrayList<Integer> arr2 = new ArrayList<>();
        getInOrder(root2, arr2);

        //merge arr1 , arr2
        ArrayList<Integer> finalArr = new ArrayList<>();

        int i=0,j = 0;

        while(i <=arr1.size()-1 && j <= arr2.size()-1){
            if(arr1.get(i)<= arr2.get(j)){
                finalArr.add(arr1.get(i));
                i++;
            }else{
                finalArr.add(arr2.get(j));
                j++;
            }
        }

        while(i <= arr1.size()-1){
            finalArr.add(arr1.get(i));
            i++;
        }

        while(j <= arr2.size()- 1){
            finalArr.add(arr2.get(j));
                j++;
        }

        //step 3 = create binary tree

        return mergeTree(finalArr, 0, finalArr.size()-1);

    }

    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

   
    public static void main(String[] args) {
        //tree 1
        Node root1 = new Node(3);
        root1.left = new Node(1);
        root1.right = new Node(5);

        /*
         tree represetation
            *        3  
                    / \  
                   1   5 
         */

        //tree 2
        Node root2 = new Node(7);
        root2.left = new Node(0);
        root2.right = new Node(10);
        /*
         tree represetation
            *        4  
                    / \  
                   2   6 
         */
        
        
        inorder(mergeTwoBSTs(root1, root2));
        System.out.println();
    }
}
