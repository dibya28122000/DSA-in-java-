import java.util.*;
class Solution {
    public int totalFruit(int[] num) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < num.length; right++) {
          
          map.put(num[right],
          map.getOrDefault(num[right], 0) + 1);

          while(map.size()>2){

            map.put(num[left],
            map.get(num[left]) - 1);

                if (map.get(num[left]) == 0) {
                    map.remove(num[left]);
                }
                left++;
            }
             int len = right - left + 1;
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
          }

           
    }

