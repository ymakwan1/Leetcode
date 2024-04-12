class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int w = weights.length;
        int max = Integer.MIN_VALUE;
        int sumOfWeights = 0;

        for(int i = 0; i < w; i++){
            sumOfWeights += weights[i];
            max = Math.max(max, weights[i]);
        }

        System.out.println(sumOfWeights);
        System.out.println(max);

        if (days == 1){
            return sumOfWeights;
        }

        int low = max;
        int high = sumOfWeights;

        while(low <= high){
            int mid = (low+high)/2;

            if(possible(mid, weights) <= days){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private int possible(int mid, int[] weights){
        int load = 0;
        int days = 1;
        for(int i = 0;  i < weights.length; i++){
            if(load + weights[i] > mid){
                days += 1;
                load = weights[i];
            }else {
                load += weights[i];
            }
        }
        return days;
    }
}