class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // search for which row woould contain the target
        // binary search by comparing matrix (right)[mid][cols - 1] and (left) matrix[mid][0];
        // if target < left, move up (bot = mid + 1) else top = mid - 1; (moving down);

        // once the row has been found, binary search on that row; 
        // left = 0; right = cols - 1;


        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        int top = 0;
        int bottom = ROWS - 1;
        int row = 0;

        while(top <= bottom){
            int mid = top + (bottom - top) / 2;

            // left side
            if(target < matrix[mid][0]){
                bottom = mid - 1;
            } else if(target > matrix[mid][COLS - 1]){
                top = mid + 1;
            } else {
                row = mid;
                break;
            }
            row = mid;
        }

        int left = 0;
        int right = COLS - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(matrix[row][mid] < target){
                left = mid + 1;
            } else if (matrix[row][mid] > target){
                right = mid - 1;
            } else {
                return true;
            }
        }

        return false; 
    }

}