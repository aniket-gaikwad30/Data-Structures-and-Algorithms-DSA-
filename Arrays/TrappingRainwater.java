public class TrappingRainwater {

    public static void trap(int[] height) {
        int n = height.length;
        if (n == 0)
            return;

        int leftMax[] = new int[n];
        int rightMax[] = new int[n];

        // Fill leftMax[]
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // Fill rightMax[]
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        // Calculate trapped water
        int totalTrapped = 0;
        for (int i = 0; i < n; i++) {

            // int waterLevel = Math.min(leftMax[i], rightMax[i]);

            // totalTrapped += waterLevel-height[i];

            totalTrapped += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        System.out.println(totalTrapped);
    }

    public static void main(String[] args) {
        int arr[] = { 4, 2, 0, 6, 3, 2, 5 };
        trap(arr); 
    }
}
