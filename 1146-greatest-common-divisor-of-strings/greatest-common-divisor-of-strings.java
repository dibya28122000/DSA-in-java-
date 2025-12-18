class Solution {
    public String gcdOfStrings(String str1, String str2) {
        String x="";
        int len;
        if(str1.length()<str2.length()){
            len=str1.length();
        }
        else{
            len=str2.length();
        }
        for(int i=0;i<len;i++){
            if(str1.charAt(i)==str2.charAt(i)){
                x=x+str1.charAt(i);
            } 
            else{
                break;
            }
        }
        for (int i=x.length();i>0;i--){
            String temp=x.substring(0,i);
            String s1="";
            String s2="";
            for(int j=0;j<str1.length();j+=temp.length()){
                s1=s1+temp;
            }
            for(int j=0;j<str2.length();j+=temp.length()){
                s2=s2+temp;
            }
            if(s1.equals(str1) && s2.equals(str2)){
                return temp;
            }
        }
        return "";
    }
}