class Dsu{
    int size[];
    int par[];
    public Dsu(int n){
        size = new int[n];
        par = new int[n];
        for(int i = 0;i<n;i++){
            size[i] = 1;
            par[i] = i;
        }
    }
    
    public  int findPar(int node){
        if(par[node] == node) return node;
        return par[node] = findPar(par[node]);
    }
    public  int unionBySize(int u,int v){
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
    public int makeConnected(int n, int[][] connections) {
        Dsu dsu = new Dsu(n);
        int arr[] = new int[n];
        int cnt =0;
        for(int i = 0;i<connections.length;i++){
                if(dsu.unionBySize(connections[i][0],connections[i][1])==1) cnt++;
        }
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0;i<n;i++){

            hs.add(dsu.findPar(i));
        }
        if(cnt>=(hs.size()-1)) return hs.size()-1;
        return -1;
    }
}