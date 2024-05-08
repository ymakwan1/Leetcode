class Solution {
    public String[] findRelativeRanks(int[] score) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            result.add("");
        }
        int i = 4;
        for(int j = 0; j < score.length; j++){
            int k = findMax(score);
            if(j==0){
                result.set(k, "Gold Medal");
            } else if(j == 1){
                result.set(k, "Silver Medal");
            }else if (j== 2){
                result.set(k, "Bronze Medal");
            }else{
                result.set(k, String.valueOf(j+1));
            }
            score[k] = -1;
        }

        return result.toArray(new String[0]);
    }

    private int findMax(int[] score){
        int index = 0;
        for (int i = 1; i < score.length; i++) {
            if (score[i] > score[index]) {
                index = i;
            }
        }
        return index;
    }
}