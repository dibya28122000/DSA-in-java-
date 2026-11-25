class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] ans = new int[m][n];
        boolean[][] vis = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 0) {
                    q.offer(new int[]{i, j, 0});
                    vis[i][j] = true;
                }
            }
        }
        int[][] dis = {{-1, 0},{0,1},{1,0},{0,-1}};
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int d = curr[2];

            ans[r][c] = d;

            for(int i = 0; i < 4; i++) {
                int nr = r + dis[i][0];
                int nc = c + dis[i][1];

                if(nr >= 0 && nr < m && nc >= 0 && nc < n && mat[nr][nc] == 1 && !vis[nr][nc]) {
                    q.offer(new int[]{nr, nc, d + 1});
                    vis[nr][nc] = true;
                }
            }
        }
        return ans;
    }
}