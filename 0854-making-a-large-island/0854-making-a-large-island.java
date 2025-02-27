class DS {
    public int[] parent;
    public int[] size;

    public DS(int n) {
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int u) {
        if (u == parent[u]) {
            return u;
        }
        return parent[u] = find(parent[u]);
    }

    public void unionBySize(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (size[rootX] < size[rootY]) {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            } else {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            }
        }
    }
}

class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DS ds = new DS(n * n); 

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0) {
                    continue;
                }
                int[] dr = new int[]{-1, 0, 1, 0};
                int[] dc = new int[]{0, -1, 0, 1};

                for (int ind = 0; ind < 4; ind++) {
                    int newr = row + dr[ind];
                    int newc = col + dc[ind];

                    if (isValid(newr, newc, n) && grid[newr][newc] == 1) {
                        int nodeNo = row * n + col;
                        int adjNodeNo = newr * n + newc;
                        ds.unionBySize(nodeNo, adjNodeNo);
                    }
                }
            }
        }

        int max = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) {
                    continue; 
                }
                int[] dr = new int[]{-1, 0, 1, 0};
                int[] dc = new int[]{0, -1, 0, 1};
                HashSet<Integer> components = new HashSet<>();

                //Check all adjacent cells.
                for (int ind = 0; ind < 4; ind++) {
                    int newr = row + dr[ind];
                    int newc = col + dc[ind];

                    if (isValid(newr, newc, n) && grid[newr][newc] == 1) {
                        components.add(ds.find(newr * n + newc));
                    }
                }

                int totalSize = 1;
                for (Integer p : components) {
                    totalSize += ds.size[p];
                }

                max = Math.max(max, totalSize);
            }
        }

        for (int cellNo = 0; cellNo < n * n; cellNo++) {
            max = Math.max(max, ds.size[ds.find(cellNo)]);
        }

        return max;
    }

    public boolean isValid(int newr, int newc, int n) {
        return newr >= 0 && newr < n && newc >= 0 && newc < n;
    }
}
