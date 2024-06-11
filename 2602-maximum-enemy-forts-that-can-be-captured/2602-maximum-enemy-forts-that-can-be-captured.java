class Solution {
    public int captureForts(int[] forts) {
        int maxCaptures = 0;
        int n = forts.length;

        for(int i = 0; i < n; i++){
            if(forts[i] == 1){
                int capturesRight = 0;
                for(int j = i+1; j < n; j++){
                    if(forts[j] == -1){
                        maxCaptures = Math.max(maxCaptures, capturesRight);
                        break;
                    } else if(forts[j] == 1){
                        break;
                    } else if(forts[j] == 0){
                        capturesRight++;
                    }
                }

                int capturesLeft = 0;
                for(int j = i-1; j >= 0; j--){
                    if(forts[j] == -1){
                        maxCaptures = Math.max(maxCaptures, capturesLeft);
                        break;
                    } else if(forts[j] == 1){
                        break;
                    } else if(forts[j] == 0){
                        capturesLeft++;
                    }
                }
            }
        }

        return maxCaptures;
    }
}