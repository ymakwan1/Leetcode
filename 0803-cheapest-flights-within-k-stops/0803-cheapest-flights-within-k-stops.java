class Pair{
    int to, price;
    Pair(int toIn, int priceIn){
        to = toIn;
        price = priceIn;
    }
}
class Tuple{
    int stops, node, dist;
    Tuple(int stopsIn, int nodeIn, int distIn){
        stops = stopsIn;
        node = nodeIn;
        dist = distIn;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        int m = flights.length;
        for(int i = 0; i < m; i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }

        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0, src, 0)); //stops, node, dist

        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        while(!q.isEmpty()){
            int stops = q.peek().stops;
            int node = q.peek().node;
            int dist = q.peek().dist;
            q.poll();

            if(stops > k){
                continue;
            }

            for(Pair p : adj.get(node)){
                int adjNode = p.to;
                int edgeWt = p.price;

                if(dist + edgeWt < distance[adjNode] && stops <= k){
                    distance[adjNode] = dist + edgeWt;
                    q.add(new Tuple(stops + 1, adjNode, distance[adjNode]));
                }
            }
        }

        for(int i = 0; i < n; i++){
            if(distance[i] == Integer.MAX_VALUE){
                distance[i] = -1;
            }
        }
        return distance[dst];
    }
}