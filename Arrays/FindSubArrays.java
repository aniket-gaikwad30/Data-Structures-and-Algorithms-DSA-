public class FindSubArrays {


    public static void findSubArrays(int nums[]){
        for(int i = 0; i < nums.length ; i++){
            for(int j = i + 1 ; j < nums.length ; j ++){
                for(int k=i; k<= j; k++){
                    System.out.print(" ["+nums[k]+"] ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3 ,4 , 5 };
        findSubArrays(nums);
        for(int i = 0; i < nums.length ; i++){
            System.out.print(nums[i] + " ");
        }
    }
    
}
