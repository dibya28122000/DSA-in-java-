
class Solution {
    public int findNumberOfLIS(int[] nums) {

        int n = nums.length;

        int[] dp = new int[n];
        int[] count = new int[n];

        int maxlen = 0;

        for (int i = n - 1; i >= 0; i--) {

            dp[i] = 1;
            count[i] = 1;

            for (int j = i + 1; j < n; j++) {

                if (nums[i] < nums[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    count[i] = count[j];
                }

                else if (nums[i] < nums[j] && dp[i] == dp[j] + 1) {
                    count[i] += count[j];
                }
            }

            maxlen = Math.max(maxlen, dp[i]);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (dp[i] == maxlen) {
                ans += count[i];
            }
        }

        return ans;
    }
}
