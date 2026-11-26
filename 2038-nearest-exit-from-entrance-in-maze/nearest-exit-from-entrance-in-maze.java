class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int row = maze.length;
        int col = maze[0].length;
        boolean[][] vis = new boolean[row][col];
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{entrance[0],entrance[1],0});
        vis[entrance[0]][entrance[1]] = true;

        int[][] dir = {{-1, 0},{0,1},{1,0},{0,-1}};

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int d = curr[2];
            for(int i = 0; i < 4; i++) {
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];

                if(nr >= 0 && nr < row && nc >= 0 && nc < col 
                    && maze[nr][nc] == '.' && !vis[nr][nc]) {

                    if (nr == 0 || nr == row - 1 || nc == 0 || nc == col - 1) {
                        return d + 1;
                    }
                    q.offer(new int[]{nr, nc, d + 1});
                    vis[nr][nc] = true;
                }
            }
        }
        return -1;
    }
}