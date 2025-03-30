/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        markParents(root, parentMap);

        HashMap<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        visited.put(target, true);
        int currentLevel = 0;

        while(!q.isEmpty()){
            int size  = q.size();
            if(currentLevel == k){
                break;
            }
            currentLevel++;
            
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = q.poll();

                if(currentNode.left != null && visited.get(currentNode.left) == null){
                    q.offer(currentNode.left);
                    visited.put(currentNode.left, true);
                }

                if(currentNode.right != null && visited.get(currentNode.right) == null){
                    q.offer(currentNode.right);
                    visited.put(currentNode.right, true);
                }

                if(parentMap.get(currentNode) != null && visited.get(parentMap.get(currentNode)) == null){
                    q.offer(parentMap.get(currentNode));
                    visited.put(parentMap.get(currentNode), true);
                }
            }
        }

        while (!q.isEmpty()) {
            TreeNode current = q.poll();
            result.add(current.val);
        }

        return result;
    }

    private void markParents(TreeNode root, HashMap<TreeNode, TreeNode> map){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode current = q.poll();

            if(current.left != null){
                map.put(current.left, current);
                q.offer(current.left);
            }
            if(current.right != null){
                map.put(current.right, current);
                q.offer(current.right);
            }
        }
    }
}