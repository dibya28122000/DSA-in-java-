class Solution {
    public void reverseString(char[] s) {
        char temp;
        for(int left = 0, right = s.length - 1;
            left < right;
            left++, right--) {
            temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
    }
}