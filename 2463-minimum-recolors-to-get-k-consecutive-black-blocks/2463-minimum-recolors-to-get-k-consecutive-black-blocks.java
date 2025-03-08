class Solution {
    public int minimumRecolors(String blocks, int k) {
        int l = 0,w = 0,b = Integer.MAX_VALUE;

        for(int i = 0;i<blocks.length();i++){
            if(blocks.charAt(i) == 'W'){
                w++;
            }

            if(i-l+1 == k){
                b = Math.min(b,w);
                if(blocks.charAt(l) == 'W') w--;
                l++;
            }

        }
        return b;
    }
}