class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];

        for(int i = 0; i < n; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE / 2);
            dist[i][i] = 0;
        }

        for(int[] edge : edges){
            int u = edge[0], v = edge[1], w = edge[2];
            dist[u][v] = w;
            dist[v][u] = w;
        }

        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(dist[i][j] > dist[i][k] + dist[k][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        int minN = Integer.MAX_VALUE;
        int bestCity = -1;

        for(int i = 0; i < n; i++){
            int count = 0;
            for(int j = 0; j < n; j++){
                if(dist[i][j] <= distanceThreshold){
                    count++;
                }
            }

            if (count < minN || (count == minN && i > bestCity)) {
                minN = count;
                bestCity = i;
            }
        }

        return bestCity;
    }
}