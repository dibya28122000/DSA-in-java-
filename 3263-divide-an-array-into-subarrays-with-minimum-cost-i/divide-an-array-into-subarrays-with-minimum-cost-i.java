class Solution {
    public int minimumCost(int[] nums) {

        int n = nums.length;
        int ans = Integer.MAX_VALUE;

        // first element is always included
        int first = nums[0];

        for (int i = 1; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {

                int cost = first + nums[i] + nums[j];
                ans = Math.min(ans, cost);

            }
        }

        return ans;
    }
}
