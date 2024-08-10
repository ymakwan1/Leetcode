class Solution {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int[][] expandedGrid = new int[3 * n][3 * n];
        
        // Expand the grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                if (grid[i].charAt(j) == '/') {
                    expandedGrid[3 * i][3 * j + 2] = 1;
                    expandedGrid[3 * i + 1][3 * j + 1] = 1;
                    expandedGrid[3 * i + 2][3 * j] = 1;
                } else if (grid[i].charAt(j) == '\\') {
                    expandedGrid[3 * i][3 * j] = 1;
                    expandedGrid[3 * i + 1][3 * j + 1] = 1;
                    expandedGrid[3 * i + 2][3 * j + 2] = 1;
                }
            }
        }
        
        int regions = 0;
        
        // DFS to count regions
        for (int i = 0; i < 3 * n; i++) {
            for (int j = 0; j < 3 * n; j++) {
                if (expandedGrid[i][j] == 0) {
                    dfs(expandedGrid, i, j);
                    regions++;
                }
            }
        }
        
        return regions;
    }
    
    private void dfs(int[][] grid, int i, int j) {
        int n = grid.length;
        if (i < 0 || i >= n || j < 0 || j >= n || grid[i][j] != 0) {
            return;
        }
        
        grid[i][j] = 1; // Mark the cell as visited
        
        // Explore the 4 possible directions
        dfs(grid, i - 1, j); // up
        dfs(grid, i + 1, j); // down
        dfs(grid, i, j - 1); // left
        dfs(grid, i, j + 1); // right
    }
}
