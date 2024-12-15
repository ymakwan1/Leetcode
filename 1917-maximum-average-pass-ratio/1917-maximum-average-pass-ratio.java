class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a, b) -> 
            Double.compare(b[0], a[0]));
        
        for (int[] cls : classes) {
            int pass = cls[0], total = cls[1];
            double improvement = gain(pass, total);
            maxHeap.offer(new double[]{improvement, pass, total});
        }
        
        while (extraStudents > 0) {
            double[] top = maxHeap.poll(); 
            int pass = (int) top[1], total = (int) top[2];

            pass++;
            total++;
            extraStudents--;
            
            double improvement = gain(pass, total);
            maxHeap.offer(new double[]{improvement, pass, total});
        }
        
        double totalRatio = 0.0;
        while (!maxHeap.isEmpty()) {
            double[] top = maxHeap.poll();
            int pass = (int) top[1], total = (int) top[2];
            totalRatio += (double) pass / total;
        }
        
        return totalRatio / classes.length;
    }
    
    private double gain(int pass, int total) {
        return (double) (pass + 1) / (total + 1) - (double) pass / total;
    }
}
