class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];

        Arrays.fill(dp, -1);

        return solve(0, arr, k,dp);
    }

    public int solve(int i, int[] arr, int k,int[]dp) {

        // Base case
        if (i >= arr.length) {
            return 0;
        }

        // If already calculated
        if (dp[i] != -1) {
            return dp[i];
        }

        int maxNum = -1;
        int len = 0;
        int result = Integer.MIN_VALUE;

        for (int j = i; j < arr.length && j < i + k; j++) {

            maxNum = Math.max(maxNum, arr[j]);

            len = j - i + 1;

            int cost = maxNum * len + solve(j + 1, arr, k,dp);

            result = Math.max(result, cost);
        }

        return dp[i] = result;
    }
}