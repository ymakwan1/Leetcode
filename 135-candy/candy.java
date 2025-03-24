class Solution {
    public int candy(int[] ratings) {
        // Brute
        // int n = ratings.length;
        // int[] left = new int[n];
        // int[] right = new int[n];
        // int candyCount = 0;
        // left[0] = 1;
        // right[n - 1] = 1;

        // for(int i = 1; i < n; i++){
        //     if(ratings[i] > ratings[i-1]){
        //         left[i] = left[i - 1] + 1;
        //     }else{
        //         left[i] = 1;
        //     }
        // }

        // for(int i = n - 2; i >= 0; i--){
        //     if(ratings[i] > ratings[i+1]){
        //         right[i] = right[i + 1] + 1;
        //     }else{
        //         right[i] = 1;
        //     }
        // }

        // for(int i = 0; i < n; i++){
        //     candyCount += Math.max(left[i], right[i]);
        // }

        // return candyCount;

        //Better
        int n = ratings.length;
        int[] left = new int[n];
        int candyCount = 1;
        left[0] = 1;

        for(int i = 1; i < n; i++){
            if(ratings[i] > ratings[i-1]){
                left[i] = left[i - 1] + 1;
            }else{
                left[i] = 1;
            }
        }

        int current = 1, right = 1;
        candyCount = Math.max(1, left[n - 1]);
        for(int i = n - 2; i >= 0; i--){
            if(ratings[i] > ratings[i+1]){
                current = right + 1;
                
            }else{
                current = 1;
            }
            right = current;
            candyCount += Math.max(left[i], current);
        }

        return candyCount;
    }
}