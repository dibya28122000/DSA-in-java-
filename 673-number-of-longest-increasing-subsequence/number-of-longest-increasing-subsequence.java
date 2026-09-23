class Solution {
    public int findNumberOfLIS(int[] nums) {

        int n = nums.length;

        int[] dp = new int[n];
        int[] count = new int[n];

        int maxlen = 0;
        int ans = 0;

        for (int i = n - 1; i >= 0; i--) {

            dp[i] = 1;
            count[i] = 1;

            for (int j = i + 1; j < n; j++) {

                if (nums[i] < nums[j]) {

                    if (dp[i] < 1 + dp[j]) {

                        dp[i] = 1 + dp[j];
                        count[i] = count[j];

                    }
                    else if (dp[i] == 1 + dp[j]) {

                        count[i] = count[i] + count[j];
                    }
                }
            }

            if (dp[i] > maxlen) {

                maxlen = dp[i];
                ans = count[i];

            }
            else if (dp[i] == maxlen) {

                ans = ans + count[i];
            }
        }

        return ans;
    }
}