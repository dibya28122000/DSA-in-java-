import java.util.*;

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{entrance[0], entrance[1], 0}); // {row, col, steps}
        maze[entrance[0]][entrance[1]] = '+'; // mark entrance as visited
        
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}}; // down, up, right, left
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0], c = cur[1], steps = cur[2];
            
            // Check all 4 directions
            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];
                
                // Check if in bounds and empty
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && maze[nr][nc] == '.') {
                    // If border cell and not entrance → exit found
                    if (nr == 0 || nr == m-1 || nc == 0 || nc == n-1) {
                        return steps + 1;
                    }
                    queue.offer(new int[]{nr, nc, steps + 1});
                    maze[nr][nc] = '+'; // mark visited
                }
            }
        }
        
        return -1; // no exit found
    }
}
