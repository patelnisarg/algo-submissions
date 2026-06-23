/**
* using the ladder system. Notice the matrix is sorted 
* from left to right values increases and so does going 
* top to bottom. 
*
* starting with the right most col of each row, if the 
* val is > than target we look at the previous col 
* if the val is < than the target we look at the next row
*
* time complexity: O(m+n), every iteration the index goes 
* either left or down until size is reached 
*
* space complexity: O(1), constant space, no extra ds used
*/
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
