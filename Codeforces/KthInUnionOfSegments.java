import java.util.*;

public class KthInUnionOfSegments {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		long k = sc.nextInt();

		long[] l = new long[n];
		long[] r = new long[n];

		for (int i = 0; i < n; i++) {
			l[i] = sc.nextInt();
			r[i] = sc.nextInt();
		}

		
		long low = (long) Math.pow(10,-11) - 1, high = (long) Math.pow(10,11), mid;
		long res = high;

		while (low <= high) {
			mid = low + (long) (high - low) / 2;


			if (check(l, r, mid, k)) {
				res = mid;
				high = mid - 1;
				// System.out.println(res);
			}
			else {
				low = mid + 1;
				// System.out.println("False");
			}
		}
		
		System.out.println(res);
	}
	
	private static boolean check(long[] l, long[] r, long mid, long k) {
		long count = 0;
		for (int i = 0; i < l.length; i++) {
			if (l[i] > mid) continue;
			
			count += (Math.min(mid,r[i]) - l[i]) + 1;
		}

		// if (mid == 91) System.out.println(count >= k);
		return count >= k + 1;
		
	}
}






		
	