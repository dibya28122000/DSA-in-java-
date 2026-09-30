import java.util.*;

class Solution {

    public int longestStrChain(String[] words) {

        Arrays.sort(words, (a, b) -> a.length() - b.length());

        int n = words.length;
        int maxLen = 1;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {

            dp[i] = 1;

            for (int j = 0; j < i; j++) {

                if (isPredecessor(words[j], words[i])) {

                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }

    public boolean isPredecessor(String a, String b) {

       int m = a.length();
       int n = b.length();

       if(n-m!=1){
        return false;
       }

        int i = 0;
        int j = 0;

        while (i < m && j < n) {

            if (a.charAt(i) == b.charAt(j)) {
                i++;
            } 
            j++;
            
        }

        return i == m;
    }
}