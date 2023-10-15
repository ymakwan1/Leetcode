class Solution {
    public boolean hasCycle(int i, List<List<Integer>> adjacency, boolean[] visited, boolean[] stack){
        visited[i] = true;
        stack[i] = true;

        for(int n : adjacency.get(i)){
            if(stack[n] || (!visited[n] && hasCycle(n, adjacency, visited, stack))){
                return true;
            }
        }
        stack[i] = false;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 1 || numCourses == 1 || prerequisites.length == 0){
            return true;
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] stack = new boolean[numCourses];
        
        List<List<Integer>> adjacency = new ArrayList<>(numCourses);

        for(int i = 0; i < numCourses; i++){
            adjacency.add(new ArrayList<>());
        }

        for(int[] p : prerequisites){
            adjacency.get(p[0]).add(p[1]);
        }

        for(int i = 0; i < numCourses; i++){
            if(!visited[i] && hasCycle(i, adjacency, visited, stack)){
                return false;
            }
        }

        return true;
    }
}