public class RevserAnArray {

    public static void revserAnArray(int nums[]) {
        int first = 0, last = nums.length-1;

        while (first < last) {
            int temp = nums[first];
            nums[first] = nums[last];
            nums[last] = temp;
            first++;
            last--;
        }
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3 ,4 , 5, 6, 7, 8, 9 };
        revserAnArray(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();

    }
}