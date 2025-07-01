class Dsu{
    int par[];
    int size[];
    public Dsu(int n){
        par = new int[n+1];
        size = new int[n+1];
        for(int i = 0;i<=n;i++){
            size[i] = 1;
            par[i] = i;
        }
    }
        public int findPar(int node){
            if(node == par[node]){
                return node;
            }
            return par[node] = findPar(par[node]);
        }
        public int union(int u,int v){
            int parU = findPar(u);
            int parV = findPar(v);
            if(parU == parV) return 1;

            if(size[parU]<size[parV]){
                par[parU] = parV;
                size[parV]+=size[parU];
            }else{
                par[parV] = parU;
                size[parU]+=size[parV];
            }
            return -1;
        }
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Dsu ds = new Dsu(edges.length);
        int arr[] = new int[2];
        for(int i[] : edges){
            if(ds.union(i[0],i[1]) == 1){
                arr[0] = i[0];
                arr[1] = i[1];
            }
        }
        return arr;
    }
}