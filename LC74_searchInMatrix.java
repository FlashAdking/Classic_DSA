class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        int end = (matrix[0].length * matrix.length) - 1;


        while( start <= end){

            int mid = start + (end - start) / 2;

            int i = mid / matrix[0].length;
            int j = mid % matrix[0].length;

            if( matrix[i][j] == target) return true;

            if( matrix[i][j] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }


        return false;
    }
}
