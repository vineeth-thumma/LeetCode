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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> list = new LinkedList<TreeNode>();
        helper(root, new HashMap<>(), list);
        return list;
        
    }
    private String helper(TreeNode node, Map<String, Integer> map, List<TreeNode> list) {
        if(node==null) {
            return "$";
        }
        String str = node.val + "," + helper(node.left, map, list) + "," + helper(node.right, map, list);
        if(map.getOrDefault(str,0)==1) {
            list.add(node);
        }
        map.put(str, map.getOrDefault(str,0)+1);
        return str;
    }
    
    
    
}