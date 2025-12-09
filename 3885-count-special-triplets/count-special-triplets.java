import java.util.*;

class Solution {
    public int specialTriplets(int[] nums) {
        long MOD = 1_000_000_007, ans = 0;
        Map<Integer, Long> left = new HashMap<>();
        Map<Integer, Long> right = new HashMap<>();

        for (int x : nums)
            right.put(x, right.getOrDefault(x, 0L) + 1);

        for (int j = 0; j < nums.length; j++) {
            int mid = nums[j];
            right.put(mid, right.get(mid) - 1);

            long t = mid * 2L;
            ans = (ans + left.getOrDefault((int)t, 0L)
                        * right.getOrDefault((int)t, 0L)) % MOD;

            left.put(mid, left.getOrDefault(mid, 0L) + 1);
        }

        return (int) ans;
    }
}