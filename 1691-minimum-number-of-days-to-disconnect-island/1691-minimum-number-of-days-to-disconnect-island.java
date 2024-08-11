import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private static final int[] directions = {-1, 0, 1, 0, -1}; // For moving in 4 directions

    public int minDays(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        if (isDisconnected(grid)) return 0;  // Already disconnected

        int landCells = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) landCells++;
            }
        }

        if (landCells <= 2) return landCells;  // If there are 1 or 2 land cells, return that count

        // Check if removing a single cell disconnects the island
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;  // Temporarily remove the cell
                    if (isDisconnected(grid)) {
                        return 1;  // If disconnecting, return 1
                    }
                    grid[i][j] = 1;  // Restore the cell
                }
            }
        }

        // If no single cell disconnects the island, then return 2
        return 2;
    }

    // Check if the grid is disconnected using BFS
    private boolean isDisconnected(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();

        // Find the first land cell to start BFS
        boolean foundLand = false;
        for (int i = 0; i < n && !foundLand; i++) {
            for (int j = 0; j < m && !foundLand; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                    foundLand = true;
                }
            }
        }

        if (!foundLand) return true;  // If there's no land, it's considered disconnected

        // BFS to explore all connected land cells
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];

            for (int i = 0; i < 4; i++) {
                int newRow = r + directions[i];
                int newCol = c + directions[i + 1];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == 1 && !visited[newRow][newCol]) {
                    visited[newRow][newCol] = true;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }

        // After BFS, check if there are any unvisited land cells
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    return true;  // If there are unvisited land cells, the island is disconnected
                }
            }
        }

        return false;  // The island is still connected
    }
}
