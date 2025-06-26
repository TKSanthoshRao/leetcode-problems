class Pair{
    int ch,wei;
    public Pair(int ch,int wei){
        this.ch = ch;
        this.wei = wei;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();
        for(int i = 0;i<=n;i++){
            adj.add(new ArrayList<Pair>());
        }
        int dis[] = new int[n+1];
        Arrays.fill(dis,Integer.MAX_VALUE);
        for(int i = 0;i<times.length;i++){
            adj.get(times[i][0]).add(new Pair(times[i][1],times[i][2]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a,b) -> a.wei - b.wei);
        dis[k] = 0;
        pq.offer(new Pair(k,0));
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            for(Pair node : adj.get(curr.ch)){
                if(curr.wei+node.wei<dis[node.ch]){
                    dis[node.ch] = curr.wei+node.wei;
                    pq.offer(new Pair(node.ch,curr.wei+node.wei));
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 1;i<=n;i++){
            if(dis[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max,dis[i]);
        }
        return max;
    }
}