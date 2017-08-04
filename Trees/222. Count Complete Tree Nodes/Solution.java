/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    int count;
    public int countNodes(TreeNode root) {
        if(root==null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
                                   
        if(left==right) {
            count += (1 << left);
            countNodes(root.right);
        }
        else {
            count += (1 << right);
            countNodes(root.left);
        }
        return count;
    }
    
    private int height(TreeNode root) {
        
        int height=0;
        while(root!=null) {
            height++;
            root=root.left;
        }
        return height;
        
    }
    
}