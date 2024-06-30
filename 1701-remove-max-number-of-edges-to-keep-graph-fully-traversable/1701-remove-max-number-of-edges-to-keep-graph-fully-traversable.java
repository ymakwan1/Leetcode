class Solution {
    private class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return false;
            }

            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }

            return true;
        }

        public boolean isConnected() {
            int root = find(1);
            for (int i = 2; i < parent.length; i++) {
                if (find(i) != root) {
                    return false;
                }
            }
            return true;
        }
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind aliceUF = new UnionFind(n + 1);
        UnionFind bobUF = new UnionFind(n + 1);
        int edgesUsed = 0;

        // Process type 3 edges
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                boolean aliceUnion = aliceUF.union(edge[1], edge[2]);
                boolean bobUnion = bobUF.union(edge[1], edge[2]);
                if (aliceUnion || bobUnion) {
                    edgesUsed++;
                }
            }
        }

        // Process type 1 edges
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                if (aliceUF.union(edge[1], edge[2])) {
                    edgesUsed++;
                }
            }
        }

        // Process type 2 edges
        for (int[] edge : edges) {
            if (edge[0] == 2) {
                if (bobUF.union(edge[1], edge[2])) {
                    edgesUsed++;
                }
            }
        }

        // Check if both Alice and Bob can traverse the entire graph
        if (aliceUF.isConnected() && bobUF.isConnected()) {
            return edges.length - edgesUsed;
        } else {
            return -1;
        }
    }
}
