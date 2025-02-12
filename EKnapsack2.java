import java.util.*;

public class EKnapsack2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        int n = sc.nextInt();
        long capacity = sc.nextLong(), maxProfit = 0;

        long[] weight = new long[n], profit = new long[n];

        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextLong();
            profit[i] = sc.nextLong();

            maxProfit += profit[i];
        }


        long[] dp = new long[(int)maxProfit + 1];

        // So my dp[i] stores minWeigth to achieve profit of i 

        

        sc.close();
    }    
}
