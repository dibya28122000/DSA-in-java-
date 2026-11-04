class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        int n = nums.length;
        int left = 0;
        int product = 1;
        int count = 0;

        for (int r = 0; r < n; r++) {

            product = product * nums[r];

            while (product >= k && left <= r) {
                product = product / nums[left];
                left++;
            }

            count = count + (r - left + 1);
        }

        return count;
    }
}