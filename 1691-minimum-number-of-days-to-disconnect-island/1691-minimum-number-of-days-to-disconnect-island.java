class Solution {
    private static final int[] directions = {-1, 0, 1, 0, -1};

    public int minDays(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if(isDisconnected(grid)){
            return 0; // Already disconnected
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    grid[i][j] = 0; //Temp removal
                    if(isDisconnected(grid)){
                        return 1; // If disconnected
                    }
                    grid[i][j] = 1; // Restore
                }
            }
        }

        return 2;
    }

    private boolean isDisconnected(int[][] grid){
        int n = grid.length; int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();

        boolean foundLand = false;

        for(int i = 0; i < n && !foundLand; i++){
            for(int j = 0; j < m && !foundLand; j++){
                if(grid[i][j] == 1){
                    queue.offer(new int[] {i, j});
                    visited[i][j] = true;
                    foundLand = true;
                }
            }
        }

        if(!foundLand){
            return true;
        }

        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];

            for(int i = 0; i < 4; i++){
                int newRow = r + directions[i];
                int newCol = c + directions[i+1];

                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == 1 && !visited[newRow][newCol]){
                    visited[newRow][newCol] = true;
                    queue.offer(new int[] {newRow, newCol});
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    return true; // Not connected
                }
            }
        }

        return false; // Connected
    }
}