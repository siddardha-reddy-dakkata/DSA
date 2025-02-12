import java.util.*;

public class NinjasTraining {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int points[][] = new int[n][3];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 3; j++) {
                    points[i][j] = sc.nextInt();
                }
            }
            System.out.println(ninjaTraining(n, points));
        }

        sc.close();
    }
    private static int ninjaTraining(int n, int[][] points) {
        int[] curr = new int[3];
        int[] prev = new int[3];

        prev[0] = points[0][0];
        prev[1] = points[0][1];
        prev[2] = points[0][2];


        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) curr[j] = points[i][j] + Math.max(prev[1], prev[2]);
                else if (j == 1) curr[j] = points[i][j] + Math.max(prev[0], prev[2]);
                else curr[j] = points[i][j] + Math.max(prev[0], prev[1]);
            }
            prev[0] = curr[0];
            prev[1] = curr[1];
            prev[2] = curr[2];


            // System.out.println(Arrays.toString(prev));
        }
        
        return Math.max(prev[0], Math.max(prev[1], prev[2]));
    }
}
