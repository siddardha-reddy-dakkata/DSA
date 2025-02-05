import java.util.*;
 
public class NotVeryRudeSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        long n = sc.nextLong();
        long c = sc.nextLong();
 
        String s = sc.next();
 
        int i = 0, j = 0;
        long rudeness = 0, aCount = 0, bCount = 0, res = 0;
 
        while (j < n) {
            if (s.charAt(j) == 'a') {
                aCount++;
            }
            else {
                rudeness += aCount;
                bCount++;
            }
 
            while (rudeness > c && i <= j) {
                if (s.charAt(i) == 'a') {
                    rudeness -= bCount;
                    aCount--;
                }
                else {
                    bCount--;
                }
                i++;
            }
            res = Math.max(res, j - i + 1);
            j++;
        }
        System.out.println(res);
        sc.close();
    }
}