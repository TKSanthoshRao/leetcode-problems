public class Pair{
    int des;
    int dis;
    int stops;
    public Pair(int des,int dis,int stops){
        this.des = des;
        this.dis = dis;
        this.stops = stops;
    }
}
class Solution {
    public int dijkstra(int n, ArrayList<ArrayList<Pair>> adj,int src, int dst, int k){
        Queue<Pair> q = new LinkedList<Pair>();
        int dis[] = new int[n];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[src] = 0;
        q.offer(new Pair(src,0,0));
        while(!q.isEmpty()){
            Pair curr = q.poll();
            if (curr.stops>k) continue;

            for(Pair p : adj.get(curr.des)){
                if(curr.dis+p.dis<dis[p.des] && curr.stops<=k)
                {
                    dis[p.des] = curr.dis+p.dis;
                    q.offer(new Pair(p.des,curr.dis+p.dis,curr.stops+1));
                }
            }
        }
        if(dis[dst] == Integer.MAX_VALUE) return -1;
        return dis[dst];
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<Pair>());
        }
        for(int i = 0;i<flights.length;i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2],0));
        }
        return dijkstra(n, adj,src,dst,k);
    }
}