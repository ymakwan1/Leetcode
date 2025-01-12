class Node {
    int i;
    int j;
    int step; 
    Node(int iIn, int jIn, int stepIn) {
        i = iIn;
        j = jIn;
        step = stepIn;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int vis[][] = new int[n][m];
        int dist[][] = new int[n][m];

        Queue<Node> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 0){
                    vis[i][j] = 1;
                    q.offer(new Node(i, j, 0));
                }
            }
        }

        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, +1, 0, -1};

        while (!q.isEmpty()) {
            int row = q.peek().i;
            int col = q.peek().j;
            int steps = q.peek().step;
            q.remove();

            dist[row][col] = steps;

            for (int i = 0; i < 4; i++) {
                int nRow = row + delRow[i];
                int nCol = col + delCol[i];

                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && vis[nRow][nCol] == 0) {
                    vis[nRow][nCol] = 1;
                    q.add(new Node(nRow, nCol, steps + 1)); 
                }
            }
        }

        return dist;
    }
}