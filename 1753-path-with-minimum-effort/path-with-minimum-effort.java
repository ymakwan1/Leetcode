class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int[][] distance = new int[n][m];
        for(int[] row : distance){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        distance[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[0] - y[0]);
        pq.offer(new int[]{0, 0, 0}); //diff, row, col

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int diff = curr[0];
            int r = curr[1];
            int c = curr[2];

            if(r == n - 1 && c == m - 1){
                return diff;
            }

            for(int[] d : directions){
                int nr = r + d[0];
                int nc = c + d[1];
                
                if(nr >= 0 && nc >= 0 && nr < n && nc < m){
                    int newEffort = Math.max(Math.abs(heights[r][c] - heights[nr][nc]), diff);
                    if(newEffort < distance[nr][nc]){
                        distance[nr][nc] = newEffort;
                        pq.offer(new int[]{newEffort, nr, nc});
                    }
                }
            }
        }
        return 0;
    }
}