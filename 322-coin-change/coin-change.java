import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {

        int[][] dp = new int[coins.length][amount + 1];

        for (int[] temp : dp) {
            Arrays.fill(temp, -1);
        }

        int ans = helper(coins, amount, 0, dp);

        if (ans == Integer.MAX_VALUE) {
            return -1;
        }

        return ans;
    }

    private int helper(int[] coins, int amount, int i, int[][] dp) {

        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return Integer.MAX_VALUE;
        }

        if (i == coins.length) {
            return Integer.MAX_VALUE;
        }

        if (dp[i][amount] != -1) {
            return dp[i][amount];
        }

        int take = helper(coins, amount - coins[i], i, dp);

        if (take != Integer.MAX_VALUE) {
            take = take + 1;
        }

        int skip = helper(coins, amount, i + 1, dp);

        dp[i][amount] = Math.min(take, skip);

        return dp[i][amount];
    }
}