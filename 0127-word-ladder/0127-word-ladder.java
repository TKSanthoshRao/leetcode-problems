class Pair{
    String str;
    int lvl;
    public Pair(String str,int lvl){
        this.str = str;
        this.lvl = lvl;
    }
}
class Solution {
    public int dfs(HashSet<String> hs , String s, String e){
        Queue<Pair> q = new LinkedList<Pair>();
        q.offer(new Pair(s,1));
        hs.remove(s);
        while(!q.isEmpty()){
            Pair node = q.poll();
            String word = node.str;
            StringBuilder str = new StringBuilder(word);
            int lvl = node.lvl;
            if(str.toString().equals(e)) return lvl;
            for(int i = 0;i<str.length();i++){
                str = new StringBuilder(word);
                for(char ch = 'a';ch<='z';ch++){
                        str.setCharAt(i,ch);
                         String newWord = str.toString();
                        if(hs.contains(newWord)){
                            q.offer(new Pair(newWord,lvl+1));
                            hs.remove(newWord);
                        }
                }
            }
        }
        return 0;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> hs = new HashSet<>();
        for(String i : wordList) hs.add(i);
        if(!hs.contains(endWord)) return 0;
        return dfs(hs,beginWord,endWord);
    }
}