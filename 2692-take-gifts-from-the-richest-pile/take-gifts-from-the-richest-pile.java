class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for(int g : gifts){
            pq.add(g);
        }

        while(k-- > 0){
            int richest = pq.poll();
            int reduced = (int) Math.sqrt(richest);
            pq.add(reduced);
        }

        long totalGift = 0;
        
        while(!pq.isEmpty()){
            totalGift += pq.poll();
        }

        return totalGift;
    }
}