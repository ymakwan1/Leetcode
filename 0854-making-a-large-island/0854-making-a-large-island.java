import java.util.*;

class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        Map<Integer, Integer> islandSize = new HashMap<>();
        int islandId = 2; // Start from 2 to differentiate from 1s
        int maxIsland = 0;

        // Step 1: Find all islands and store their sizes
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int size = dfs(grid, i, j, islandId);
                    islandSize.put(islandId, size);
                    maxIsland = Math.max(maxIsland, size);
                    islandId++;
                }
            }
        }

        // Step 2: Check all 0s to see the max island we can get by flipping
        int[] directions = {-1, 0, 1, 0, -1};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> uniqueIslands = new HashSet<>();
                    for (int d = 0; d < 4; d++) {
                        int ni = i + directions[d], nj = j + directions[d + 1];
                        if (ni >= 0 && nj >= 0 && ni < n && nj < n && grid[ni][nj] > 1) {
                            uniqueIslands.add(grid[ni][nj]);
                        }
                    }

                    int newSize = 1; // Start with the flipped cell
                    for (int id : uniqueIslands) {
                        newSize += islandSize.get(id);
                    }
                    maxIsland = Math.max(maxIsland, newSize);
                }
            }
        }

        return maxIsland;
    }

    private int dfs(int[][] grid, int i, int j, int islandId) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) {
            return 0;
        }

        grid[i][j] = islandId; // Mark the cell with the island ID
        int size = 1;

        int[] directions = {-1, 0, 1, 0, -1};
        for (int d = 0; d < 4; d++) {
            size += dfs(grid, i + directions[d], j + directions[d + 1], islandId);
        }

        return size;
    }
}
