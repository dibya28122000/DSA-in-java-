import java.util.*;
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        int minSum = Integer.MAX_VALUE;
        ArrayList<String> ans = new ArrayList<>();
        for (int j = 0; j < list2.length; j++) {
            String str = list2[j];
            if (map.containsKey(str)) {
                int sum = map.get(str) + j;
                if (sum < minSum) {
                    minSum = sum;
                    ans.clear();
                    ans.add(str);
                }
                else if (sum == minSum) {
                    ans.add(str);
                }
            }
        }
        return ans.toArray(new String[0]);
    }
}
