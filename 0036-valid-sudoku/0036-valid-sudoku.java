class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> sudokuSet = new HashSet<>();

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    char boxValue = board[i][j];
                    if(!sudokuSet.add(boxValue+"row"+i) || !sudokuSet.add(boxValue+"col"+j) || !sudokuSet.add(boxValue+ "box" + i / 3 + "," + j / 3)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}