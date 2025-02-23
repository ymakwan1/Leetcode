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
 */
class Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        Map<Integer, Integer> postIndexMap = new HashMap<>();
        for(int i = 0; i < postorder.length; i++){
            postIndexMap.put(postorder[i], i);
        }

        return buildTree(preorder, postorder, postIndexMap, new int[]{0}, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] postorder, Map<Integer, Integer> postIndexMap, int[] preIndex, int postStart, int postEnd){
        if(preIndex[0] >= preorder.length || postStart > postEnd){
            return null;
        }

        TreeNode root = new TreeNode(preorder[preIndex[0]++]);

        if (postStart == postEnd || preIndex[0] >= preorder.length) {
            return root; 
        }

        int leftChildVal = preorder[preIndex[0]];
        int leftChildPostIndex = postIndexMap.get(leftChildVal);

        root.left = buildTree(preorder, postorder, postIndexMap, preIndex, postStart, leftChildPostIndex);
        root.right = buildTree(preorder, postorder, postIndexMap, preIndex, leftChildPostIndex + 1, postEnd - 1);

        return root;
    }
}