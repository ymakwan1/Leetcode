class Solution {
    class Pair{
        int row;
        int col;
        Pair(int rowIn, int colIn){
            row = rowIn;
            col = colIn;
        }
    }

    public int numEnclaves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] visited = new int[rows][cols];
        int count = 0;
        Queue<Pair> q = new LinkedList<>();
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(i == 0 || i == rows - 1 || j == 0 || j == cols - 1){
                    if(grid[i][j] == 1){
                        visited[i][j] = 1;
                        q.offer(new Pair(i , j));
                    }
                }
            }
        }

        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            q.poll();

            for(int[] dir : directions){
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr >= 0 && nr < rows && nc >= 0 && nc < cols && visited[nr][nc] == 0 && grid[nr][nc] == 1){
                    visited[nr][nc] = 1;
                    q.offer(new Pair(nr, nc));
                }
            }
        }

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 1 && visited[i][j] == 0){
                    count++;
                }
            }
        }

        return count;
    }
}