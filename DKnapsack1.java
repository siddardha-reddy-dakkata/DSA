import java.util.*;

public class DKnapsack1 {
    public static void main(String[] Args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int bagWeight = sc.nextInt();

        int[] weights = new int[n];
        long[] prices = new long[n];
        

        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
            prices[i] = sc.nextLong();

        }

        // long[][] dp = new long[n][bagWeight + 1];

        long[] curr = new long[bagWeight + 1];
        long[] prev = new long[bagWeight + 1];

        for (int i = 0; i < n; i++ ) {

            for (int j = 1; j <= bagWeight; j++ ) {
                if (i == 0) {
                    if (j >= weights[i]) {
                        curr[j] = prices[i];
                    }
                    continue;
                }
                long myPick = j >= weights[i] ? prices[i] + prev[j - weights[i]] : 0;
                curr[j] = Math.max(prev[j], myPick);
            }
            prev = Arrays.copyOf(curr, bagWeight + 1);
        }

        // System.out.println(dp[n - 1][bagWeight]);
        System.out.println(prev[bagWeight]);

        sc.close();
    }    
}
