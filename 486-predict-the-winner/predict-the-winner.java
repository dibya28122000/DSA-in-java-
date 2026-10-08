class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;

        return solve(0, n - 1, nums) >= 0;
    }

    public int solve(int i, int j, int[] nums) {

        // Base case
        if (i == j) {
            return nums[i];
        }

        // Take left
        int left = nums[i] - solve(i + 1, j, nums);

        // Take right
        int right = nums[j] - solve(i, j - 1, nums);

        // Take the better option
        return Math.max(left, right);
    }
}