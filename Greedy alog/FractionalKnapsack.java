

public class FractionalKnapsack {
    public static void fractionalKnapsack(double[] values, double[] weights, double capacity) {
        int n = values.length;
        double[][] ratio = new double[n][2];

        // Calculate value-to-weight ratio
        for (int i = 0; i < n; i++) {
            ratio[i][0] = values[i] / weights[i]; // value/weight ratio
            ratio[i][1] = i; // index of the item
        }

        // Sort items by value-to-weight ratio in descending order
        java.util.Arrays.sort(ratio, (a, b) -> Double.compare(b[0], a[0]));

        double totalValue = 0.0;

        for (int i = 0; i < n && capacity > 0; i++) {
            int index = (int) ratio[i][1];
            if (weights[index] <= capacity) {
                // If the whole item can be added
                totalValue += values[index];
                capacity -= weights[index];
            } else {
                // If only part of the item can be added
                totalValue += values[index] * (capacity / weights[index]);
                capacity = 0; // Knapsack is full
            }
        }

        System.out.println("Maximum value in Knapsack = " + totalValue);
    }
    public static void main(String[] args) {
        double[] values = {60, 100, 120};
        double[] weights = {10, 20, 30};
        double capacity = 50;

        fractionalKnapsack(values, weights, capacity);
    }
}
