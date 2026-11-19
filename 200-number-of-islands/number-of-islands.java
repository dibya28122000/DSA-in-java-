import java.util.*;
class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length; 
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    BFS(i, j, grid, visited);
               }
           }
       }
        return count;
    }
    public void BFS(int row, int column, char[][] grid,
                    boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row, column});
        visited[row][column] = true;

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while (!q.isEmpty()) {
           int[] current = q.poll();
           int r = current[0];
           int c = current[1];
            for (int i = 0; i < 4; i++) {
                int newRow = r + dr[i];
                int newCol = c + dc[i];
                if (newRow >= 0 && newRow < grid.length &&
                    newCol >= 0 && newCol < grid[0].length &&
                    grid[newRow][newCol] == '1' &&
                    !visited[newRow][newCol]) {

                    q.offer(new int[]{newRow, newCol});

                    visited[newRow][newCol] = true;
                }
            }
        }
    }
}
