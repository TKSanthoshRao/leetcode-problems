class Solution {
    public int minimumRecolors(String blocks, int k) {
        int cnt = 0;
        int max = 0;
        int ans = 0;
        int b = 0;
        for(char ch : blocks.toCharArray()){
            if(ch == 'B'){
                cnt++;
            }else{
              max =   Math.max(max,cnt);
                cnt = 0;
                 b++;
            }
        }
        max = Math.max(max,cnt);
        if(max>=k) return ans;
        if(k == blocks.length()) return b;
        int a = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<=blocks.length()-k;i++){
            a = 0;
            for(int j = i;j<i+k;j++){
                System.out.println(i+" "+j);
                if(blocks.charAt(j) == 'W'){
                    a++;
                }
            }
            min = Math.min(min,a);
        }
        return min;
    }
}