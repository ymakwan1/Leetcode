class Solution {
    public int[][] validArrangement(int[][] pairs) {
        
        Map<Integer, Deque<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, Integer> outDegree = new HashMap<>();

        for (int[] pair : pairs) {
            int start = pair[0];
            int end = pair[1];
            graph.computeIfAbsent(start, k -> new ArrayDeque<>()).add(end);
            outDegree.put(start, outDegree.getOrDefault(start, 0) + 1);
            inDegree.put(end, inDegree.getOrDefault(end, 0) + 1);
        }

        int startNode = pairs[0][0]; 
        for (int key : graph.keySet()) {
            if (outDegree.getOrDefault(key, 0) - inDegree.getOrDefault(key, 0) == 1) {
                startNode = key;
                break;
            }
        }

        List<int[]> result = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(startNode);

        while (!stack.isEmpty()) {
            int node = stack.peek();
            if (graph.containsKey(node) && !graph.get(node).isEmpty()) {
                // Traverse the next edge
                stack.push(graph.get(node).poll());
            } else {
                // Backtrack and record the path
                stack.pop();
                if (!stack.isEmpty()) {
                    result.add(new int[]{stack.peek(), node});
                }
            }
        }

        Collections.reverse(result);
        return result.toArray(new int[0][0]);
    }
}
