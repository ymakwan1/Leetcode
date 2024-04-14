class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int column = matrix[0].length - 1;
        
        while(row < matrix.length && column >= 0){
            if(matrix[row][column] == target){
                return true;
            } else if (matrix[row][column] < target) {
                row++;
            } else {
                column--;
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