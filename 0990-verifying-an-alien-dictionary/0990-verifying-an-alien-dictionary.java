class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character,Integer> hm = new HashMap<>();
        int ch = 0;
        for(char i : order.toCharArray()){
            hm.put(i,ch);
            ch++;
        }
        for(int i = 1;i<words.length;i++){
            String word1 = words[i-1];
            String word2 = words[i];
            int len = Math.min(word1.length(),word2.length());
            boolean valid = false;
            for(int j = 0;j<len;j++){
                char ch1 = word1.charAt(j);
                 char ch2 = word2.charAt(j);
                if(ch1!=ch2 && hm.get(ch1)<hm.get(ch2)){
                    valid = true;
                   break;
                }else  if(ch1!=ch2 && hm.get(ch1)>hm.get(ch2)){
                   return false;
                }
            }
            if (!valid && word1.length() > word2.length()) {
                return false;
            }
        }
        return true;
    }
}