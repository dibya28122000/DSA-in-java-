class Solution {
  public int numSubarraysWithSum(int[] nums, int goal) {
      return atMost(nums,goal)-atMost(nums,goal-1);
    }
  public int atMost(int[]nums, int k){
    if(k<0){
      return 0;
        }
      int l=0;
      int s=0;
      int c=0;
for(int r=0; r<nums.length; r++){
  s += nums[r]; 
     while(s > k){
         s-=nums[l];
            l++;
        }
        c+=r-l+1;
           }
       return c;
    }
}