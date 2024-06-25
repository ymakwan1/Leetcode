class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        int m = grid.length;
        int n = grid[0].length;
        
        // Directions arrays for moving in 4 possible directions: up, down, left, right
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        // Traverse each cell in the grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Check if it's a land cell
                if (grid[i][j] == 1) {
                    // Check all 4 possible neighbors
                    for (int k = 0; k < 4; k++) {
                        int ni = i + dx[k];
                        int nj = j + dy[k];
                        
                        // If neighbor is out of bounds or water, increment perimeter
                        if (ni < 0 || ni >= m || nj < 0 || nj >= n || grid[ni][nj] == 0) {
                            perimeter++;
                        }
                    }
                }
            }
        }
        
        return perimeter;
    }
}
