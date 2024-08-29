class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        boolean visited[] = new boolean[n];
        int numOfStones = 0;

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(stones, visited, i);
                numOfStones++;
            }
        }

        return n - numOfStones;
    }

    private void dfs(int[][] stones, boolean[] visited, int curr){
        visited[curr] = true;
        for(int j = 0; j < stones.length; j++){
            if(!visited[j] && (stones[curr][0] == stones[j][0] || stones[curr][1] == stones[j][1])){
                dfs(stones, visited, j);
            }
        }
    }
}