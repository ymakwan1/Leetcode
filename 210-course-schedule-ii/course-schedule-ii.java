class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int [numCourses];
        int[] topo = new int[numCourses];
        int count = 0;

        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < prerequisites.length; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        for(int i = 0; i < numCourses; i++){
            for(int n : adj.get(i)){
                inDegree[n]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < inDegree.length; i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int node = q.poll();
            topo[count++] = node;

            for(int n : adj.get(node)){
                inDegree[n]--;
                if(inDegree[n] == 0){
                    q.add(n);
                }
            }
        }

        if(count == numCourses){
            return topo;
        }

        int[] arr = {};
        return arr;
    }
}