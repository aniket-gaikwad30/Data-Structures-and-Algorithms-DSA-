import java.util.Arrays;

public class MinAbsDiff {

    public static void minAbsDiff(int []a , int []b){
        Arrays.sort(a);
        Arrays.sort(b);

        int minSum = 0;

        for(int i = 0 ; i < a.length; i++){
            minSum += Math.abs(a[i]-a[i]);
        }

        System.out.println("Min Sum is "+ minSum);
    }
    public static void main(String[] args) {
        minAbsDiff(new int[]{1,2,3},new int[]{2,1,3});
    }
}