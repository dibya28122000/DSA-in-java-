import java.util.*;
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) {
            return -1;
        }
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        int[][] d = {
            {-1, 0}, {-1, 1},{0, 1},{1, 1},{1, 0},{1, -1},{0, -1},{-1, -1}
        };
        q.offer(new int[]{0, 0, 1});
        visited[0][0] = true;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];
            int dist = curr[2];
            if (row == n-1 && col == n-1) {
                return dist;
            }
            for (int i = 0; i < 8; i++) {
                int nr = row + d[i][0];
                int nc = col + d[i][1];
                if (nr >= 0 && nc >= 0 &&
                    nr < n && nc < n &&
                    grid[nr][nc] == 0 &&
                    !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc, dist + 1});
                }
            }
        }
        return -1;
    }
}
