import java.util.*;

public class Balanced {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            long[] arr = new long[n];

            for (int i = 0; i < n; i++) arr[i] = sc.nextLong();

            long low = 1, high = (long) (Math.max(10, 9)), mid, res = 1;

            while (low <= high) {
                mid = (long) (low + high) / 2;

                if (predicate(arr, mid)) {
                    low = mid + 1;
                    res = mid;
                }
                else high = mid - 1;
            }
            System.out.println(res);
        }

    }
    private static boolean predicate(long[] arr, long mid) {
        if (arr.length == 1) return arr[0] >= mid;
        else if (arr.length == 2) return arr[0] >= mid && arr[1] >= mid;

        for (int i = arr.length - 1; i > 1; i--) {
            if (arr[i] < mid) return false;

            long avail = arr[i] - mid;
            long d = (long) avail / 3;

            arr[i - 1] += d;
            arr[i - 2] += (3 * d);
        }

        if (arr[0] < mid || arr[1] < mid) return false;
        return true;
    }
}