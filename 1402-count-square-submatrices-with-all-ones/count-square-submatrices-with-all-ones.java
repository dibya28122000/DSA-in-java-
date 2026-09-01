class Solution {

    public int countSquares(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        Integer[][] dp = new Integer[m][n];

        int count = 0;

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (matrix[i][j] == 1) {
                    count += helper(i, j, matrix, dp);
                }
            }
        }

        return count;
    }

    public int helper(int row, int col, int[][] matrix, Integer[][] dp) {


        if (row >= matrix.length || col >= matrix[0].length) {
            return 0;
        }

        if (matrix[row][col] == 0) {
            return 0;
        }
       
        if (dp[row][col] != null) {
            return dp[row][col];
        }

        int down = helper(row + 1, col, matrix, dp);

        int right = helper(row, col + 1, matrix, dp);

        int diagonal = helper(row + 1, col + 1, matrix, dp);

        dp[row][col] = 1 + Math.min(diagonal, Math.min(down, right));

        return dp[row][col];
    }
}