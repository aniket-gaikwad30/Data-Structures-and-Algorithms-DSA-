public class ContainerWithMostWater {
    public static  int maxArea(int[] height) {
        int waterContent = 0;

        int left = 0 , right = height.length -1;

        while (left<right) {
            int leftHeigth = height[left];
            int rightHeight = height[right];

            waterContent = Math.max(waterContent,(right-left) * Math.min(leftHeigth, rightHeight) );

            if(leftHeigth<rightHeight){
                left++;
            }else{
                right--;
            }
            
        }

        return waterContent;
    }

    public static void main(String[] args) {
        int []height = {1,8,6,2,5,4,8,3,7};

        System.out.println(maxArea(height));
    }
}