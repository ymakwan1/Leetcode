class Solution {
    public int trapRainWater(int[][] heightMap) {
        int rows = heightMap.length;
        int cols = heightMap[0].length;
        boolean[][] visited = new boolean[rows][cols];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]); //row,col,height

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 || i == rows - 1 || j == 0 || j == cols - 1) {
                    pq.offer(new int[] {i, j, heightMap[i][j]});
                    visited[i][j] = true;
                }
            }
        }

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int trappedWater = 0;

        while(!pq.isEmpty()){
            int[] cell = pq.poll();
            int x = cell[0];
            int y = cell[1];
            int height = cell[2];

            for(int[] dir : directions){
                int nx = x + dir[0];
                int ny = y + dir[1];

                if(nx >= 0 && ny >= 0 && nx < rows && ny < cols && !visited[nx][ny]){
                    trappedWater += Math.max(0, height - heightMap[nx][ny]);
                    pq.offer(new int[]{nx, ny, Math.max(height, heightMap[nx][ny])});
                    visited[nx][ny] = true;
                }
            }
        }

        return trappedWater;
    }
}