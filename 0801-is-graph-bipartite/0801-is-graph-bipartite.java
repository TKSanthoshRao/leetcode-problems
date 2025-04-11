class Solution {
    public boolean dfs(int start,int[][] adj,int color[],int startColor){
        color[start] = startColor;
        for(int i : adj[start]){
            if(color[i]==-1){
                if(dfs(i,adj,color,1-startColor) == false)
                 return false;
            }else if(color[i] == startColor){
                return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int colors[] = new int[graph.length];
    Arrays.fill(colors,-1);

        for(int i = 0;i<graph.length;i++){
            if (colors[i] == -1) {
                if (!dfs(i, graph, colors, 0)) return false;
            }
        }
        return true;
    }
}