class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for(int i = 0; i < n; i++){
            if(color[i] == -1){
                if(!dfs(i, 0, color, graph)){
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(int i, int currColor, int[] color, int[][] graph){
        color[i] = currColor;
        for(int n : graph[i]){
            if(color[n] == -1){
                if(!dfs(n, 1 - currColor, color, graph)){
                    return false;
                }
            }else if(currColor == color[n]){
                return false;
            }
        }

        return true;
    }
}