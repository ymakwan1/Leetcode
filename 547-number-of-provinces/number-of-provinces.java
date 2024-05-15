class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        boolean[] visited = new boolean[n];
        int provinces = 0;

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(isConnected, visited, i);
                provinces++;
            }
        }

        return provinces;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int city){
        if(visited[city])
            return;
        visited[city] = true;
        for(int n = 0; n < isConnected.length; n++){
            if(isConnected[city][n] == 1 && !visited[n]){
                dfs(isConnected, visited, n);
            }
        }
    }
}