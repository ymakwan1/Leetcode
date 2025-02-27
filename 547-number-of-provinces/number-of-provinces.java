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

    public int countProvinces(){
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
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DS ds = new DS(n);

        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(isConnected[i][j] == 1){
                    ds.unionBySize(i, j);
                }
            }
        }

        return ds.countProvinces();
    }
}