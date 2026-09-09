class Solution {

    public boolean canPartition(int[] nums) {

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }

        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;

        Boolean[][] dp = new Boolean[nums.length][target + 1];

        return helper(nums, nums.length - 1, target, dp);
    }

    public boolean helper(int[] nums, int index, int target, Boolean[][] dp) {

        if (target == 0) {
            return true;
        }

        if (index < 0) {
            return false;
        }

        if (dp[index][target] != null) {
            return dp[index][target];
        }

      
        boolean notTake = helper(nums, index - 1, target, dp);

       
        boolean take = false;

        if (nums[index] <= target) {
            take = helper(nums, index - 1, target - nums[index], dp);
        }

        dp[index][target] = take || notTake;

        return dp[index][target];
    }
}