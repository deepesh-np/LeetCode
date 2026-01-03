import java.util.*;

class Solution {
    public int maxSumMinProduct(int[] nums) {
        int n = nums.length;
        long MOD = 1_000_000_007L;

        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int[] left = new int[n];   
        int[] right = new int[n];  
        Arrays.fill(right, n);

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                right[stack.pop()] = i;
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        long maxProduct = 0;
        for (int i = 0; i < n; i++) {
            long sum = prefix[right[i]] - prefix[left[i] + 1];
            long product = sum * nums[i];
            maxProduct = Math.max(maxProduct, product);
        }

        return (int) (maxProduct % MOD);
    }
}
