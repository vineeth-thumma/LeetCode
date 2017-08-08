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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length-1);       
    }
    
    public TreeNode helper(int[] nums, int s, int e) {
        if(s>e) {
            return null;
        }
        int max = Integer.MIN_VALUE;
        int index = -1;
        for(int i=s; i<=e; i++) {
            if(nums[i]>max) {
                max = nums[i];
                index = i;
            }
        }
        TreeNode node = new TreeNode(max);
        node.left = helper(nums, s, index-1);
        node.right = helper(nums, index+1, e);
        return node;
    }
}