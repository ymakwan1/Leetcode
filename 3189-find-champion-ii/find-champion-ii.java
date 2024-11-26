class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] inDegree = new int[n];

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            inDegree[v]++;
        }

        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < inDegree.length; i++){
            if(inDegree[i] == 0){
                res.add(i);
            }
        }

        if(res.size() != 1){
            return -1;
        }

        return res.get(0);
    }
}