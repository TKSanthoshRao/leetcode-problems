class Solution {
    public int strStr(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int lps[] = new int[m];
        int i = 1,j = 0;
        while(i<m){
            if(str2.charAt(i) == str2.charAt(j)){
                lps[i] = j+1;
                i++;
                j++;
            }else if(j == 0){
                lps[i] = 0; 
                i++;
            }else{
                j = lps[j-1];
            }
        }
        i = 0;
        j = 0;
        while(i<n){
            if(str1.charAt(i) == str2.charAt(j)){
                i++;
                j++;
            }else
            {
                if(j == 0){
                    i++;
                }else{
                    j = lps[j-1];
                }
            }
            if(j == m) return i-m;
        }
        return -1;
    }
}