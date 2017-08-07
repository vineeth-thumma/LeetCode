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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        if(len==0) return null;
        HashMap<Integer, Integer> hm = new HashMap<Integer,Integer>();
	    for (int i=0; i<len; ++i)
		    hm.put(inorder[i], i);
        return helper(inorder, 0, len-1, postorder, 0, len-1, hm);
    }
    
    public TreeNode helper(int[] inorder, int a, int b, int[] postorder, int x, int y, HashMap<Integer, Integer> hm) {
        if(a>b || x>y) {
            return null;
        }
        
        if(a==b) {
            TreeNode node = new TreeNode(inorder[a]);
            node.left = node.right = null;
            return node;
        }
        TreeNode root = new TreeNode(postorder[y]);
        int i=hm.get(root.val);
        
        root.left = helper(inorder, a, i-1, postorder, x, x+i-a-1, hm);
        root.right = helper(inorder, i+1, b, postorder, x+i-a, y-1, hm);
        return root;
        
    }
}