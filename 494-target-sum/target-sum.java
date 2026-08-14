class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return countWays(nums, target, 0, 0);
    }

    static int countWays(int[] nums, int target, int index, int sum) {

        if (index == nums.length) {
            return (sum == target) ? 1 : 0;
        }

        int plus = countWays(
            nums, target, index + 1, sum + nums[index]
        );

        int minus = countWays(
            nums, target, index + 1, sum - nums[index]
        );

        return plus + minus;
    }
}