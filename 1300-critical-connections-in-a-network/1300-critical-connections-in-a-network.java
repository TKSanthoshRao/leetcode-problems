class Solution {
    public void dfs(int i, int par,List<List<Integer>> sol,ArrayList<ArrayList<Integer>> adj, boolean vis[], int time[], int low[],int timer[]){
            vis[i] = true;
            time[i] = timer[0];
            low[i] = timer[0];
            timer[0]++;
            for(int nei : adj.get(i)){
                if(nei == par) continue;
            if(!vis[nei]){
                dfs(nei,i,sol,adj,vis,time,low,timer);
                low[i] = Math.min(low[nei],low[i]);
                if(low[nei]>time[i]){
                    sol.add(Arrays.asList(i,nei));
                }
            }else{
                low[i] = Math.min(low[i],low[nei]);
                }
            }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> sol = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++) adj.add(new ArrayList<Integer>());
        for(int i = 0;i<connections.size();i++){
            adj.get(connections.get(i).get(0)).add(connections.get(i).get(1));
            adj.get(connections.get(i).get(1)).add(connections.get(i).get(0));
        }
        int timer[] = new int[1];
        timer[0] = 0;
        boolean vis[] = new boolean[n];
        int time[] = new int[n];
        int low[] = new int[n];
        dfs(0,-1,sol,adj,vis,time,low,timer);
        return sol;
    }
}