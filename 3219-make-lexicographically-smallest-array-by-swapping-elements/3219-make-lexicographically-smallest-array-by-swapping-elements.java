class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[] parent = new int[n];
        int[] rank = new int[n];

        // Initialize union-find data structure
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        // Sort indices based on values in nums
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (a, b) -> nums[a] - nums[b]);

        // Union indices based on the limit condition
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n && nums[indices[j]] - nums[indices[i]] <= limit; j++) {
                union(indices[i], indices[j], parent, rank);
            }
        }

        // Group indices by their connected component
        Map<Integer, List<Integer>> groups = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = find(i, parent);
            groups.computeIfAbsent(root, k -> new ArrayList<>()).add(i);
        }

        // Sort and update the array for each group
        for (List<Integer> group : groups.values()) {
            List<Integer> values = new ArrayList<>();
            for (int index : group) {
                values.add(nums[index]);
            }
            Collections.sort(group);
            Collections.sort(values);
            for (int i = 0; i < group.size(); i++) {
                nums[group.get(i)] = values.get(i);
            }
        }

        return nums;
    }

    // Find with path compression
    private int find(int x, int[] parent) {
        if (parent[x] != x) {
            parent[x] = find(parent[x], parent);
        }
        return parent[x];
    }

    // Union with rank
    private void union(int x, int y, int[] parent, int[] rank) {
        int rootX = find(x, parent);
        int rootY = find(y, parent);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
}