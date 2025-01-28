class Solution {
    public int findMaxFish(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int maxFish = 0;
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(!visited[i][j] && grid[i][j] > 0){
                    maxFish = Math.max(maxFish, dfs(i, j, grid, visited));
                }
            }
        }

        return maxFish;
    }

    private int dfs(int row, int col, int[][] grid, boolean[][] visited){
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || visited[row][col] || grid[row][col] == 0) {
            return 0;
        }

        visited[row][col] = true;
        int fish = grid[row][col];

        fish += dfs(row, col + 1, grid, visited);
        fish += dfs(row, col - 1, grid, visited);
        fish += dfs(row + 1, col, grid, visited);
        fish += dfs(row - 1, col, grid, visited);

        return fish;
    }
}