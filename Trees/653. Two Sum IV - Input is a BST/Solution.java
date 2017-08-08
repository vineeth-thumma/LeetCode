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
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> hs = new HashSet();
        return helper(root, k, hs);        
    }
    
    public boolean helper(TreeNode root, int sum, Set<Integer> hs) {
        if(root==null) {
            return false;
        }
        int comp = sum-root.val;
        if(hs.contains(comp)) {
            return true;
        } else {
            hs.add(root.val);
        }
        return helper(root.left, sum, hs) || helper(root.right, sum, hs);
                
    }
}