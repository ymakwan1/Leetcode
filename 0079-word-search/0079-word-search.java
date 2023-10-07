class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        if(rows * cols < word.length()){
            return false;
        }
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if(dfs(r,c,board,word,0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int r,int c,char[][] board, String word, int index){
        if(index == word.length()){
            return true;
        }
        
        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != word.charAt(index)){
            return false;
        }

        

        char temp = board[r][c];
        board[r][c] = '.';

        boolean found = dfs(r+1, c, board, word, index+1) ||
                        dfs(r-1, c, board, word, index+1) ||
                        dfs(r, c+1, board, word, index+1) ||
                        dfs(r, c-1, board, word, index+1);
        board[r][c] = temp;
        return found;
    }
}