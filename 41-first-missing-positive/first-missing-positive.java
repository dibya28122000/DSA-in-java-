class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int a = 1;
        while (true) {
            if (!set.contains(a)) {
                return a;
            }
            a++;
        }
    }
}