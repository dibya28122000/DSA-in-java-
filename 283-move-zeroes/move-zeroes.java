class Solution {
    public void moveZeroes(int[] nums) {
        int res[]=new int[nums.length];
        int ind=0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                res[ind]=nums[i];
                ind++;
            }
        }  
        while(ind<nums.length){
            res[ind]=0;
            ind++;
        } 
        for(int i=0;i<nums.length;i++){
            nums[i]=res[i];
        }
    }
}