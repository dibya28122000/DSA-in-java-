class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int left = 0;
        int used = 0;
        int maxLen = 0;


        for (int right = 0; right < n; right++) {
            while ((used & nums[right]) != 0) {

                used = used ^ nums[left];

                left++;
            }
            used = used | nums[right];
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
