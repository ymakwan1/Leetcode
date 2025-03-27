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
    static class Tuple{
        TreeNode node;
        int row, col;
        Tuple(TreeNode nodeIn, int rowIn, int colIn){
            node = nodeIn;
            row = rowIn;
            col = colIn;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<Tuple>();
        q.offer(new Tuple(root, 0 , 0)); //node, vertical, level
        while(!q.isEmpty()){
            Tuple t = q.poll();
            TreeNode node = t.node;
            int x = t.row;
            int y = t.col;

            if(!map.containsKey(x)){
                map.put(x, new TreeMap<>());
            }

            if(!map.get(x).containsKey(y)){
                map.get(x).put(y, new PriorityQueue<>());
            }
            map.get(x).get(y).offer(node.val);

            if(node.left != null){
                q.offer(new Tuple(node.left, x - 1 , y + 1));
            }
            if(node.right != null){
                q.offer(new Tuple(node.right, x + 1 , y + 1));
            }
        }
        List<List<Integer>> list = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()){
            list.add(new ArrayList<>());
            for(PriorityQueue<Integer> nodes : ys.values()){
                while(!nodes.isEmpty()){
                    list.get(list.size() - 1).add(nodes.poll());
                }
            }
        }
        return list;
    }
}