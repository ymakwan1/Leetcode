class Leaderboard {

    Map<Integer,Integer> scores;
    public Leaderboard() {
        scores = new HashMap<Integer,Integer>();
    }
    
    public void addScore(int playerId, int score) {
        scores.put(playerId, scores.getOrDefault(playerId, 0) + score);
    }
    
    public int top(int K) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> scores.get(b) - scores.get(a));
        maxHeap.addAll(scores.keySet());
        
        int sum = 0;
        for (int i = 0; i < K; i++) {
            if (maxHeap.isEmpty()) break;
            sum += scores.get(maxHeap.poll());
        }
        
        return sum;
    }
    
    public void reset(int playerId) {
        scores.remove(playerId);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */