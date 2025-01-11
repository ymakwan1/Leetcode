class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int freshCount = 0;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols]; // Visited matrix

        // Step 1: Initialize the queue with all rotten oranges and count fresh oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j, 0}); // {row, col, time}
                    visited[i][j] = true; // Mark as visited
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        // Step 2: Perform BFS to simulate the rotting process
        int time = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; 

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            time = current[2];

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1 && !visited[newRow][newCol]) {
                    grid[newRow][newCol] = 2; 
                    visited[newRow][newCol] = true; 
                    freshCount--; 
                    queue.offer(new int[]{newRow, newCol, time + 1}); 
                }
            }
        }

        // Step 3: Return the result
        return freshCount == 0 ? time : -1; // If all fresh oranges are rotted, return time; else, return -1
    }
}
