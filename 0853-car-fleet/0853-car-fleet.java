class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] cars = new double[n][2];
        int fleets = 1;
        for(int i = 0; i < n; i++){
            cars[i][0] = position[i];
            cars[i][1] = (double)(target - position[i]) / speed[i];
        }
        
        Arrays.sort(cars, (a,b) -> Double.compare(b[0], a[0]));
        
        Stack<Double> stack = new Stack<Double>();
        
        double prevTime = cars[0][1];
        
        for (int i = 1; i < n; i++) {
            double curTime = cars[i][1];
            
            if (curTime > prevTime) {
                fleets++;
                prevTime = curTime;
            }
        }
        
        return fleets;
    }
}