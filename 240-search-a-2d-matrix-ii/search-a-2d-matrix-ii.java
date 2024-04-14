class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int column = matrix[0].length;

        for(int i = 0;  i < row; i++){
            if(binarySearch(matrix[i], target)){
                return true;
            }
        }
        return false;
    }

    private boolean binarySearch(int[] mat, int target){
        int n = mat.length;
        int low = 0;
        int high = n - 1;

        while(low <= high){
            int mid = (low+high)/2;
            if(mat[mid] == target){
                return true;
            } else if (target > mat[mid]){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }
}