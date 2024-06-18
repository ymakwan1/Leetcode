class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int[][] jobs = new int[n][2];

        for(int i=0; i < n; i++){
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }

        Arrays.sort(jobs, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[0] == b[0]){
                    return b[1] - a[1];
                }

                return a[0]-b[0];
            }
        });

        Arrays.sort(worker);

        int maxProfit = 0;
        int totalProfit = 0;
        int j = 0;

        for(int w: worker){
            while(j < n && jobs[j][0] <= w){
                maxProfit = Math.max(maxProfit, jobs[j][1]);
                j++;
            }

            totalProfit += maxProfit;
        }

        return totalProfit;
    }
}