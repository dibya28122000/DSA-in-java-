class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;

        Integer dp[][] = new Integer[n][n];

        return solve(0, n - 1, nums, dp) >= 0;
    }

    public int solve(int i, int j, int[] nums, Integer[][] dp) {

        // Base case
        if (i == j) {
            return nums[i];
        }

        // Already calculated
        if (dp[i][j] != null) {
            return dp[i][j];
        }

        // Take left
        int left = nums[i] - solve(i + 1, j, nums, dp);

        // Take right
        int right = nums[j] - solve(i, j - 1, nums, dp);

        // Store the maximum answer
        dp[i][j] = Math.max(left, right);

        return dp[i][j];
    }
}