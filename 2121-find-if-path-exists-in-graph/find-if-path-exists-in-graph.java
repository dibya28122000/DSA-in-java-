class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        boolean[] visited = new boolean[n];
        Stack<Integer> st = new Stack<>();
        st.push(source);
        visited[source] = true;
        while (!st.isEmpty()) {
            int node = st.pop();
            if (node == destination) {
                return true;
            }
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    st.push(neighbor);
                }
            }
        }
        return false;
    }
}