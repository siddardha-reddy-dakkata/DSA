/*package whatever //do not write package name here */

import java.util.*;

public class RangeSumQueries {
    static void buildTree(int[] arr, int[] segmentTree, int index, int start, int end) {
        if (start == end) {
            segmentTree[index] = arr[start];
            return;
        }
        
        int mid = (start + end) >> 1;
        buildTree(arr, segmentTree, index * 2, start, mid);
        buildTree(arr, segmentTree, index * 2 + 1, mid + 1, end);
        
        segmentTree[index] = segmentTree[index * 2] + segmentTree[index * 2 + 1];
    }
    
    static int search(int qStart, int qEnd, int s, int e, int[] segmentTree, int index) {
        if (qStart > e || qEnd < s) {
            return 0;
        }
        else if (s >= qStart && e <= qEnd) {
            return segmentTree[index];
        }
        
        int mid = (s + e) >> 1;
        int left = search(qStart, qEnd, s, mid, segmentTree, index * 2);
        int right = search(qStart, qEnd, mid + 1, e, segmentTree, index * 2 + 1);
        
        return left + right;
    }
    
    
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    
	    int n = sc.nextInt();
	    int q = sc.nextInt();
	    
	    int[] arr = new int[n];
	    for (int i = 0; i < n; i++) {
	        arr[i] = sc.nextInt();
	    }
	    
	    int[] segmentTree = new int[4 * n + 1];
	    buildTree(arr, segmentTree, 1, 0, n - 1);
	    
	   
	   while (q-- > 0) {
	       int start = sc.nextInt();
	       int end = sc.nextInt();
	       
	       int res = search(start - 1, end - 1, 0, n - 1, segmentTree, 1);
	       System.out.println(res);
	   }
	}
}


