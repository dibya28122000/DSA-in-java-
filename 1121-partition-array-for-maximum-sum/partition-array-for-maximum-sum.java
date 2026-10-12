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

        for (int j = i; j < arr.length && j < i + k; j++) 
        //as they have given k at most and in example it is given k =3 so we can have 1 also 2 and 3 so if we divide at 1 that is at 1 so i and j are at same position so i = j and j because k is 3 and index start from 0 so it should be less than k 
        {
            maxNum = Math.max(maxNum, arr[j]);
            len = j - i + 1;
            int cost = maxNum * len + solve(j + 1, arr, k,dp);
            result = Math.max(result, cost);
        }
        return dp[i] = result;
    }
}