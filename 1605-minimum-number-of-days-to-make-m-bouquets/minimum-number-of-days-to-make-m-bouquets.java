class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        long val = (long) m * k;
        int n = bloomDay.length;
        if (val > n) return -1;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < bloomDay.length; i++){
            min = Math.min(min, bloomDay[i]);
            max = Math.max(max, bloomDay[i]);
        }

        int low = min;
        int high = max;

        while(low <= high){
            int mid = (low + high) / 2;
            if(possible(mid, bloomDay, m, k)){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean possible(int day, int[] bloomDay, int  m, int k){
        int n = bloomDay.length;
        int count = 0;
        int noOfBouquet = 0;

        for(int i = 0; i < n; i++){
            if(bloomDay[i] <= day){
                count++;
            }else {
                noOfBouquet += (count / k);
                count = 0;
            }
        }
        noOfBouquet += (count / k);
        return noOfBouquet >= m;
    }
}