
public class PrintNosInReverse {

    public static void reverse(int n) {

        if (n == 1) {
            System.out.println(n);
            return;
        }

        System.out.println(n);
        reverse(n - 1);
    }

    public static void main(String[] args) {
        int nums = 10;
        reverse(nums);

    }
}
