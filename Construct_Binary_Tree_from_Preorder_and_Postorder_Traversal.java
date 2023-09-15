/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 **/
class Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return dfs(preorder,0,preorder.length-1,postorder,0,preorder.length-1);
    }
    private TreeNode dfs(int[]preorder,int prestart,int preend,int[]postorder,int poststart,int postend){
        if(prestart>preend){
            return null;
        }
        TreeNode root=new TreeNode(preorder[prestart]);
        if(prestart==preend){
            return root;
        }
        int postidx=poststart;
        while(postorder[postidx]!=preorder[prestart+1]){
            postidx++;
        }
        int len=postidx-poststart+1;
        root.left=dfs(preorder,prestart+1,prestart+len,postorder,poststart,postidx);
        root.right=dfs(preorder,prestart+len+1,preend,postorder,postidx+1,postend-1);
        return root;
    }
}
