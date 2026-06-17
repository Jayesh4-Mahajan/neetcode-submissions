class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        int left = 0, right = rows*cols - 1;
        while (left <= right) {
            int mid = left + (right-left) / 2;
            int val = matrix[mid/cols][mid%cols];
            if (target == val) {
                return true;
            } else if (target > val) {
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }
        return false;
    }
}
