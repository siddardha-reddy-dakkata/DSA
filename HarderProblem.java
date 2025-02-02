import java.util.*;
 
public class HarderProblem{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    int t = sc.nextInt();
    while (t-- > 0) {
        int n = sc.nextInt();
        long[] arr = new long[n];
        
        long[] res = new long[n];
        long next = 2 * 100001;
        
        HashSet<Long> set = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
            
            if (set.contains(arr[i])) {
                res[i] = ++next;
            }
            else {
                res[i] = arr[i];
                set.add(arr[i]);
            }
        }
        
        for (int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
        
    }
  }
}