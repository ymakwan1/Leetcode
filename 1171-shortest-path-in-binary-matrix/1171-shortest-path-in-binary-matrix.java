class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if(grid[0][0] == 1 || grid[n-1][n-1] == 1){
            return -1;
        }

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int[][] distance = new int[n][n];
        for(int[] row : distance){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        distance[0][0] = 1;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{1, 0, 0}); //distance, row, col

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int dist = curr[0];
            int r = curr[1];
            int c = curr[2];

            if(r == n - 1 && c == n - 1){
                return dist;
            }

            for(int[] d : directions){
                int nr = r + d[0];
                int nc = c + d[1];

                if(nr >= 0 && nc >= 0 && nr < n && nc < n && grid[nr][nc] == 0){
                    if((dist + 1) < distance[nr][nc]){
                        distance[nr][nc] = dist + 1;
                        q.offer(new int[]{distance[nr][nc], nr, nc});
                    }
                }
            }
        }

        return -1;
    }
}