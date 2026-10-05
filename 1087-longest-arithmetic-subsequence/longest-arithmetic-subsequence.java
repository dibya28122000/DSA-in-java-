class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][1001];
        for(int temp[] : dp){
            Arrays.fill(temp, 1);
        }

        int maxLen = 1;

        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                int diff = nums[i] - nums[j];
                int diffIndex = diff + 500;

            
                dp[i][diffIndex] = dp[j][diffIndex] + 1;
                maxLen = Math.max(dp[i][diffIndex], maxLen);
                
            }
        }
        return maxLen;
    }
}