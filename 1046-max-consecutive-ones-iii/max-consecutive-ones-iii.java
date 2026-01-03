class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0,  right = 0;
        int zerocount=0;
        int ans= 0;
        while(right<nums.length){
            if(nums[right]==0) zerocount++;
            while(zerocount>k){
                if(nums[left] == 0) zerocount--;
                left++;
            }
            ans = Math.max(ans, right-left+1);
            right++;
        }
        return ans;
    }
}