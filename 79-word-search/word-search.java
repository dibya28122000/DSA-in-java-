class Solution {

    int rows, cols;
    int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};

    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, word, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) return true;

        if (i < 0 || j < 0 || i >= rows || j >= cols 
                || board[i][j] != word.charAt(index)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '#'; // mark visited

        for (int[] dir : directions) {
            int ni = i + dir[0];
            int nj = j + dir[1];

            if (dfs(board, word, ni, nj, index + 1))
                return true;
        }

        board[i][j] = temp; // backtrack
        return false;
    }
}