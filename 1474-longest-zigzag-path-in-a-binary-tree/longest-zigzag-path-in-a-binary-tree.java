
class Solution{
    int max=0;
    public int longestZigZag(TreeNode root){
        dfs(root, true, 0);   
        dfs(root, false, 0);  
        return max;
    }

    private void dfs(TreeNode node, boolean isLeft, int length){
        if(node == null){
            return;
        }
        max=Math.max(max, length);

        if(isLeft){
            dfs(node.right, false, length+1);
            dfs(node.left, true, 1);
        } 
        else{
            dfs(node.left, true, length+1);
            dfs(node.right, false, 1);
        }
    }
}