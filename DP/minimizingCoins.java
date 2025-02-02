import java.util.*;


public class minimizingCoins {
  public static void main(String[]Args) {
    Scanner sc = new Scanner(System.in);
    
    int n = sc.nextInt();
    int k = sc.nextInt();
    
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
    
    long[] dp = new long[k + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    
    boolean ans = false;
    for (int i = 1; i <= k; i++) {
        long myMin = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            if (i - arr[j] >= 0) {
                myMin = Math.min(myMin, dp[i - arr[j]]);
            }
        }
        
        dp[i] = myMin + 1;
    }
    if (dp[k] >= Integer.MAX_VALUE) System.out.println(-1);
    else System.out.println(dp[k]);
  }
}