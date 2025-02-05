import java.util.*;
public class XeniaandColorfulGems {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            
            int[][] arr = new int[3][];

            int[] n = new int[3];
            for (int i = 0; i < 3; i++) {
                n[i] = sc.nextInt();
                arr[i] = new int[n[i]];
            }

            
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < n[i]; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }



            // long res = 0;
            



            // for (int i = 0; i < nr; i++) {
            //     long val = sc.nextLong();
            //     arr.add(new long[]{val, 0});
            // }
            // for (int i = 0; i < ng; i++) {
            //     long val = sc.nextLong();
            //     arr.add(new long[]{val, 1});
            // }
            // for (int i = 0; i < nb; i++) {
            //     long val = sc.nextLong();
            //     arr.add(new long[]{val, 2});
            // }

            
            // Collections.sort(arr,new  Comparator<long[]>() {
            //     @Override
            //     public int compare(long[] a, long[] b) {
            //         return Long.compare(a[0], b[0]);
            //     }
            // });


            // int[] freq = new int[3];
            // int[] ind = new int[3];

            // int count = 0, i = 0, j = 0;

            // while (i < arr.size()) {
            //     long currVal = arr.get(i)[0], currInd = arr.get(i)[1];
            //     freq[(int)currInd]++;

            //     if (freq[(int)currInd] == 1) {
            //         count++;
            //     }

            //     while (count == 3) {
            //         long tempVal = arr.get(j)[0], tempInd = arr.get(j)[1];
                
            //         long reqVal = (nums[ind[0]]);
            //         res = Math.max(res, reqVal);
            //     }
            // }


            // System.out.println(res);
        }
        sc.close();
    }
}
