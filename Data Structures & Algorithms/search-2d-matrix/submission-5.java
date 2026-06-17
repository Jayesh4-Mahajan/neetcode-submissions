class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // for (int[] row: matrix) {
        //     for (int val: row) {
        //         if (val == target) {
        //             return true;
        //         }
        //     }
        // }
        // return false;

        int m = matrix.length, n = matrix[0].length;
        int r = 0, c = n-1;
        while (r < m && c >= 0) {
            if (matrix[r][c] > target) {
                c--;
            } else if (matrix[r][c] < target) {
                r++;
            } else {
                return true;
            }
        }
        return false;
    }
}
