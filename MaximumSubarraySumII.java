import java.util.*;

public class MaximumSubarraySumII {
    public double[] medianSlidingWindow(int[] nums, int k) {
        Comparator<Integer> compare = (a, b) -> (nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : a - b);

        TreeSet<Integer> low = new TreeSet<>(compare.reversed());
        TreeSet<Integer> high = new TreeSet<>(compare);

        // PriorityQueue<Integer> low = new PriorityQueue<>(Collections.reverseOrder()), high = new PriorityQueue<>();

        long[] sum = new long[2];

        double[] res = new double[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            if (low.isEmpty() || nums[low.first()] >= nums[i]) {
                low.add(i);
                sum[0] += nums[i];
            }
            else {
                high.add(i);
                sum[1] += nums[i];
            }

            balance(low, high, sum, nums);

            if (i >= k) {
                if (low.contains(i - k)) {
                    sum[0] -= nums[i - k];
                    low.remove(i - k);
                }
                else {
                    sum[1] -= nums[i - k];
                    high.remove(i - k);
                }

                balance(low, high, sum, nums);
            }

            if (i >= k - 1) {
                if (k % 2 == 1) res[i - k + 1] = (double) nums[low.first()];
                else {
                    res[i - k + 1] = ((double) nums[low.first()] +  (double) nums[high.first()]) / 2.0;
                }  
            }

        }

        return res;
    }
    private void balance(TreeSet<Integer> low, TreeSet<Integer> high, long[] sum, int[] nums) {
        if (low.size() > high.size() + 1) {
            int val = low.pollFirst();
            high.add(val);

            sum[0] -= nums[val];
            sum[1] += nums[val];
        }

        if (low.size() < high.size()) {
            int val = high.pollFirst();
            low.add(val);

            sum[0] += nums[val];
            sum[1] -= nums[val];
        }
    }
}

