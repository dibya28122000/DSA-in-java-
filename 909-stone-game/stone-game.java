import java.util.Arrays;

class Solution {
    public boolean stoneGame(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, n - 1, nums, dp) >= 0;
    }

    public int solve(int i, int j, int[] nums, int[][] dp) {

        // Base case
        if (i == j) {
            return nums[i];
        }

        // If already calculated
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // Take left
        int left = nums[i] - solve(i + 1, j, nums, dp);

        // Take right
        int right = nums[j] - solve(i, j - 1, nums, dp);

        // Store the result
        dp[i][j] = Math.max(left, right);

        return dp[i][j];
    }
}