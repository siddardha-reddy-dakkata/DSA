import java.util.*;
 
public class FactoryMachines {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    long n = sc.nextLong();
    long t = sc.nextLong();
    long maxi = 0, mini = Long.MAX_VALUE;
    
    long[] arr = new long[(int) n];
    for (int i = 0 ; i < n; i++) {
        arr[i] = sc.nextLong();
        maxi = Math.max(maxi, arr[i]);
        mini = Math.min(mini, arr[i]);
    }
    
    
    long low = 0, high = maxi * t, mid;
    long res = Long.MAX_VALUE; 
    
    for (int i = 0; i < 200; i++) {
        mid = (long) ((low + high) / 2);
        
        if (working(arr, n, mid, t)) {
            res = Math.min(res, mid);
            // System.out.print(mid + " ");
 
            high = mid - 1;
        }
        else {
            low = mid + 1;
        }
    };
    // System.out.println();
    
 
    System.out.println(Math.min(res, maxi * t));

    sc.close();
  }
  
  private static boolean working(long[] arr, long n, long mid, long t) {
      long curr = 0;
      for (int i = 0; i < n; i++) {
          curr += (long) (mid / arr[i]);
	  if (curr >= t) return true;
      }
      return curr >= t;
  }
}
