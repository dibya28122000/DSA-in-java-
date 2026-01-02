class Solution {
    public int maxVowels(String s, int k) {
        int currvowels = 0;
        for(int i = 0;i<k;i++){
            if(isvowel(s.charAt(i))) currvowels++;
        }
        int maxvowels = currvowels;
        for(int i = k;i<s.length();i++){
            if(isvowel(s.charAt(i))) currvowels++;
            if(isvowel(s.charAt(i-k))) currvowels--;
            maxvowels = Math.max(currvowels, maxvowels);
        }
        return maxvowels;
    }
    boolean isvowel(char c){
        if(c=='a'|| c=='e'|| c=='i'||
        c=='o'|| c=='u') return true;
        return false;
    }
}