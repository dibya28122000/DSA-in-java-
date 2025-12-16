class Solution {
    public String reverseWords(String s) {
        s = s.trim().replaceAll("\\s+", " ");
        int n = s.length();
        char[] s2 = new char[n];
        for (int i=0;i<n;i++){
            s2[i] = s.charAt(n-1-i);
        }
        int start = 0;
        for (int i=0;i<=n;i++){
            if (i==n||s2[i]==' '){
                int l=start,r=i-1;
                while (l<r){
                    char temp=s2[l];
                    s2[l]=s2[r];
                    s2[r]=temp;
                    l++;
                    r--;
                }
                start=i+1;
            }
        }
        return new String(s2);
    }
}