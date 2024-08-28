class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int rows = grid1.length;
        int cols = grid1[0].length;
        int subIslandCount = 0;
        
        // Step 1: Traverse grid2 and look for islands
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // If we find a '1' in grid2, we start a DFS to check if it's a sub-island
                if (grid2[i][j] == 1) {
                    // Step 2: If DFS returns true, it's a valid sub-island, so we increment the count
                    if (dfs(grid1, grid2, i, j)) {
                        subIslandCount++;
                    }
                }
            }
        }
        
        return subIslandCount;
    }
    
    private boolean dfs(int[][] grid1, int[][] grid2, int i, int j) {
        // If we're out of bounds or if the current cell is '0' in grid2, we return true (valid sub-island so far)
        if (i < 0 || j < 0 || i >= grid1.length || j >= grid1[0].length || grid2[i][j] == 0) {
            return true;
        }
        
        // If grid1 has '0' where grid2 has '1', this can't be a sub-island
        if (grid1[i][j] == 0) {
            return false;
        }
        
        // Mark the current cell as visited in grid2
        grid2[i][j] = 0;
        
        // Check all 4 directions (up, down, left, right)
        boolean up = dfs(grid1, grid2, i - 1, j);
        boolean down = dfs(grid1, grid2, i + 1, j);
        boolean left = dfs(grid1, grid2, i, j - 1);
        boolean right = dfs(grid1, grid2, i, j + 1);
        
        // The current island is a sub-island only if all 4 directions are valid
        return up && down && left && right;
    }
}
