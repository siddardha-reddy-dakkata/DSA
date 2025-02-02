import java.util.*;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) arr[i] = sc.next();

        int maxLen = 0, ind = 0;
        boolean isSame = true;

        
        while (true) {
            // System.out.println(ind + 1);
            if (!isSame || arr[0].length() <= ind) break;
            // System.out.println(ind + 1);

            for (int i = 0 ; i < n; i++) {
                if (arr[i].length() <= ind) {
                    isSame = false;
                    break;
                }
                else if (arr[i].charAt(ind) != arr[0].charAt(ind)) {
                    isSame = false;
                    break;
                }
            }

            if (isSame) {
                maxLen++;
            }
            ind++;
        }

        System.out.println(arr[0].substring(0, maxLen));
    }
}