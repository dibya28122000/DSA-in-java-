import java.util.*;

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Map<String, List<String>> memo = new HashMap<>();
        return dfs(s, set, memo);
    }

    private List<String> dfs(String s, Set<String> set, Map<String, List<String>> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        List<String> result = new ArrayList<>();

        if (s.length() == 0) {
            result.add("");
            return result;
        }

        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);

            if (set.contains(prefix)) {
                String remaining = s.substring(i);
                List<String> subSentences = dfs(remaining, set, memo);

                for (String sub : subSentences) {
                    if (sub.isEmpty()) {
                        result.add(prefix);
                    } else {
                        result.add(prefix + " " + sub);
                    }
                }
            }
        }

        memo.put(s, result);
        return result;
    }
}