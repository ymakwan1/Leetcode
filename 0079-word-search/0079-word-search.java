public class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        
        if (rows * cols < word.length()) {
            return false;
        }

        boolean[][] visited = new boolean[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (dfs(r, c, board, word, 0, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(int r, int c, char[][] board, String word, int index, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }

        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length ||
            board[r][c] != word.charAt(index) || visited[r][c]) {
            return false;
        }

        visited[r][c] = true;

        boolean found = dfs(r + 1, c, board, word, index + 1, visited) ||
                        dfs(r - 1, c, board, word, index + 1, visited) ||
                        dfs(r, c + 1, board, word, index + 1, visited) ||
                        dfs(r, c - 1, board, word, index + 1, visited);

        visited[r][c] = false; // Backtrack

        return found;
    }
}
