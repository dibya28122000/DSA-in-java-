class Solution {
    public int removeElement(int[] nums, int val) {
        return remove(nums, val, 0, 0);
    }

    private int remove(int[] nums, int val, int i, int k) {
        if (i == nums.length) {
            return k;
        }

        if (nums[i] != val) {
            nums[k] = nums[i];
            k++;
        }

        return remove(nums, val, i + 1, k);
    }
}