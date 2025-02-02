import java.util.*;


public class CoinCombinations1 {
  public static void main(String[]Args) {
    Scanner sc = new Scanner(System.in);
    
    int n = sc.nextInt();
    int k = sc.nextInt();
    long[] dp = new long[k + 1];
    int mod = 1000000007;
    
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
        if (arr[i] <= k) dp[arr[i]]++;
    }
    
    // Arrays.fill(dp, Integer.MAX_VALUE);
    // dp[0] = 0;
    for (int i = 1; i <= k; i++) {
        for (int j = 0; j < n; j++) {
            if (i - arr[j] >= 0) {
                dp[i] = (dp[i] + dp[i - arr[j]]) % mod;
            }
        }
    }
    System.out.println(dp[k]);
  }
}