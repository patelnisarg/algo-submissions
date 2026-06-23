class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int currRow = 0, currCol = cols-1;
        
        while(currRow < rows && currCol >= 0){
            if(matrix[currRow][currCol] == target){
                return true;
            } else if(matrix[currRow][currCol] > target){
                currCol--;
            } else {
                currRow++;
            }
        }

        return false;
    }
}
