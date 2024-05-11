class Solution {
    static class Worker{
        int quality;
        double ratio;

        public Worker(int qualityIn, int wageIn){
            quality = qualityIn;
            ratio = (double) wageIn/qualityIn;
        }
    }

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;

        Worker[] workers = new Worker[n];

        for(int i = 0; i < n; i++){
            workers[i] = new Worker(quality[i], wage[i]);
        }

        Arrays.sort(workers, Comparator.comparingDouble(w -> w.ratio));

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        double minCost = Double.MAX_VALUE;
        int totalQuality = 0;

        for(Worker worker : workers){
            pq.offer(worker.quality);
            totalQuality += worker.quality;

            if(pq.size() > k){
                totalQuality -= pq.poll();
            }

            if(pq.size() == k){
                minCost = Math.min(minCost, totalQuality * worker.ratio);
            }
        }

        return minCost;
    }
}