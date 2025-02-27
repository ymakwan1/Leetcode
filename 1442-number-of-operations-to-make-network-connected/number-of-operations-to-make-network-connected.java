class DS{
    private int[] parent;
    private int[] size;

    public DS(int n){
        parent = new int[n];
        size = new int[n];
        
        for(int i = 0; i < n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int u){
        if(u == parent[u]){
            return u;
        }

        return parent[u] = find(parent[u]);
    }

    public void unionBySize(int x, int y){
        int rootX = find(x);
        int rootY = find(y);

        if(rootX != rootY){
            if(size[rootX] < size[rootY]){
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            }else{
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            }
        }
    }
    public int countConnections(){
        int count = 0;
        for(int i = 0; i < parent.length; i++){
            if(parent[i] == i){
                count++;
            }
        }
        return count;
    }
}

class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        DS ds = new DS(n);
        for(int[] c : connections){
            ds.unionBySize(c[0], c[1]);
        }
        return ds.countConnections() - 1;
    }
}