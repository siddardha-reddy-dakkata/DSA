import java.util.*;

public class SubsetsWithoutDuplicates {
    public static void main(String[] Args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        findSubsets(0, arr, new ArrayList<>(), res);

        // Collections.sort(res);
        for (ArrayList<Integer> i: res) System.out.println(i);
        sc.close();

    }
    private static void findSubsets(int ind, int[] nums, ArrayList<Integer> ds, ArrayList<ArrayList<Integer>> res) {
        res.add(new ArrayList<>(ds));
        for (int i = ind; i < nums.length; i++) {
            if (i != ind && nums[i] != nums[i - 1]) continue;
            ds.add(nums[i]);
            findSubsets(i + 1, nums, ds, res);
            ds.remove(ds.size() - 1);
        }
    }
    
}
