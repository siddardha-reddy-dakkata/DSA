import java.util.*;


public class AdrenalineRush {
    public static void main(String[] Args) {
        Scanner sc = new Scanner(System.in); 
        
        int n = sc.nextInt();
        int[] arr = new int[n];

        if (n < 2) {
            System.out.println(0);
            return;
        }

        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();


        boolean[] vis = new boolean[n + 1];
        int i = 0, curr = 1;

        while (i < n) {
            if (arr[i] == curr) {
                curr++;
                i++;
            }
            else if (arr[i] < curr) {
                i++;
            }
            else {
                vis[curr] = true;
                curr++;
            }
        }

        int res = n * (n - 1);
        for (i = 1; i <= n; i++) {
            if (vis[i]) res -= n - 1;
            // System.out.println(vis[i] + " " + i);
        }
        for (int ele: arr) System.out.print(ele + " ");
        System.out.println();
        System.out.println(res);
        for (i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                System.out.println(vis[arr[i]] + " " + arr[i]);
                if (!vis[arr[i]]) System.out.println(arr[i] + " " + arr[j]);
                System.out.println(arr[j] + " " + arr[i]);
            }

            // for (int j = 0; j < i; j++) {
            //     System.out.println(arr[i] + " " + arr[j]);
            //     if (!vis[arr[i]]) System.out.println(arr[j] + " " + arr[i]);
            // }
        }
    }
}
