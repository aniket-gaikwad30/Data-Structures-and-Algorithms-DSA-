public class KadanesAlogrithm {

    public static int findMaxSubArray(int nums[]){
        int currSum = 0, maxSum = Interger.MIN_VALUE;

        

        for(int i = 0; i < nums.length ; i++){
            currSum += nums[i];

            if(currSum > maxSum){
                maxSum = currSum;
            }
            if(currSum < 0){
                currSum = 0; 
            }
        }

        return maxSum;
    }



    public static void main(String[] args) {
        int nums[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
        System.out.println(findMaxSubArray(nums));
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();   
    }
}
