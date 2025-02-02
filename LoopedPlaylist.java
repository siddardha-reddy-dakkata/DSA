import java.util.*;

public class LoopedPlaylist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long arr[] = new long[n], p = sc.nextLong(), total = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
            total += arr[i];
        }

        
        long res = ((long) Math.floorDiv(p, total)) * n;
        // System.out.println(res);
        p %= total;
        
        int minInd = 0;
        long minSongs = Long.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            long currSongs = getNumberOfSongs(arr, i, p);

            if (currSongs < minSongs) {
                minSongs = currSongs;
                minInd = i;
            }
        }

        res += minSongs;
        minInd++;
        System.out.println(minInd + " " + res);
    }    

    private static long getNumberOfSongs(long[] arr, int start, long total) {
        int n = arr.length;
        long currSum = 0;
        

        for (int i = 0; i < arr.length; i++) {
            currSum += (arr[(start + i) % n]);

            if (currSum >= total) return i + 1;
        }
        return 0;
    }
}
