import java.util.Arrays;

public class Coin {
    public int coinChange(int[] coins, int amount) {
        // Sort coins in ascending order
        Arrays.sort(coins);
        int count = 0;
        int n = coins.length;

        // Loop from largest coin to smallest
        for (int i = n - 1; i >= 0 && amount > 0; i--) {
            if (coins[i] <= amount) {
                int use = amount / coins[i];
                count += use;
                amount -= use * coins[i];
                System.out.println("Used " + use + " coins/notes of: " + coins[i]);
            }
        }

        return amount == 0 ? count : -1; // Return -1 if amount cannot be formed
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] coins = {2000, 500, 200, 100, 50, 20, 10, 5, 2, 1};
        int amount = 3768;
        int minCoins = sol.coinChange(coins, amount);
        System.out.println("Minimum number of coins/notes: " + minCoins);
    }
}
