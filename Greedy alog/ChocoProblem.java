import java.util.Arrays;
import java.util.Collections;

public class ChocoProblem {
    public static void main(String[] args) {
        int n = 4, m = 6;

        Integer CostVer[] = {2, 1, 3, 1, 4};  // vertical cuts = m - 1 = 5
        Integer CostHor[] = {4, 1, 2};        // horizontal cuts = n - 1 = 3

        Arrays.sort(CostVer, Collections.reverseOrder());
        Arrays.sort(CostHor, Collections.reverseOrder());

        int h = 0, v = 0;
        int hp = 1, vp = 1;
        int cost = 0;

        while (h < CostHor.length && v < CostVer.length) {
            if (CostHor[h] <= CostVer[v]) {
                cost += CostVer[v] * hp;
                vp++;
                v++;
            } else {
                cost += CostHor[h] * vp;
                hp++;
                h++;
            }
        }

        // Remaining vertical cuts
        while (v < CostVer.length) {
            cost += CostVer[v] * hp;
            vp++;
            v++;
        }

        // Remaining horizontal cuts
        while (h < CostHor.length) {
            cost += CostHor[h] * vp;
            hp++;
            h++;
        }

        System.out.println("Minimum total cost: " + cost);
    }
}
