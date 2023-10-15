class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        boolean[][] boolgrid = new boolean[grid.length][grid[0].length];
        int rows = grid.length;
        int columns = grid[0].length;
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        for(int i = 0; i < rows; i++){
            for(int j=0; j<columns; j++){
                if(grid[i][j] == '1' && !boolgrid[i][j]){
                    count++;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i,j});
                    while(!queue.isEmpty()){
                        int[] current = queue.poll();
                        int x = current[0];
                        int y = current[1];

                        for(int[] dir : directions){
                            int newX = x + dir[0];
                            int newY = y + dir[1];

                            if(newX >=0 && newX<rows && newY>=0 && newY<columns && grid[newX][newY] == '1' && !boolgrid[newX][newY]){
                                queue.add(new int[]{newX,newY});
                                boolgrid[newX][newY] =true;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}