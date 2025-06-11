import java.util.Stack;

public class NextGreaterElement {

    public static int[] nextGreater(int arr[]){
        int nextGreaterElement[] = new int[arr.length];
        Stack<Integer> s = new Stack<>();

        for(int i = arr.length-1; i >= 0; i--){
            //step 1 while condation 
            while (!s.isEmpty() && arr[s.peek()]<= arr[i]) {
                s.pop();
            }

            //step 2 if -else 
            if(s.isEmpty()){
                nextGreaterElement[i] = -1;
            }else{
                nextGreaterElement[i] = arr[s.peek()];
            }

            //step 3 push in stack
            s.push(i);
        }

        return nextGreaterElement;

    }
    public static void main(String[] args) {
        

        int arr[] = {6, 8 ,0, 1 ,3};

        int[] greater = nextGreater(arr);

        for (int i : greater) {
            System.out.print(i+" ");
        }

        

        
    }
}
