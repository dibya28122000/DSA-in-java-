class Solution {
    public String removeStars(String s) {
        StringBuilder stack = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch != '*') {
                stack.append(ch);   // push character
            } else {
                stack.deleteCharAt(stack.length() - 1); // pop character
            }
        }

        return stack.toString();
    }
}
