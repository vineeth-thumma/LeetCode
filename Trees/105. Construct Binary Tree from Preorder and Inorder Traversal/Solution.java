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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       int len = inorder.length;
        if(len==0) return null;
        HashMap<Integer, Integer> hm = new HashMap<Integer,Integer>();
	    for (int i=0; i<len; ++i)
		    hm.put(inorder[i], i);
        return helper(inorder, 0, len-1, preorder, 0, len-1, hm);
    }
    
    public TreeNode helper(int[] inorder, int a, int b, int[] preorder, int x, int y, HashMap<Integer, Integer> hm) {
        if(a>b || x>y) {
            return null;
        }
        
        if(a==b) {
            TreeNode node = new TreeNode(inorder[a]);
            node.left = node.right = null;
            return node;
        }
        TreeNode root = new TreeNode(preorder[x]);
        int i=hm.get(root.val);
        
        root.left = helper(inorder, a, i-1, preorder, x+1, x+i-a, hm);
        root.right = helper(inorder, i+1, b, preorder, x+i-a+1, y, hm);
        return root; 
    }
}