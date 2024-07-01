class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int left = 0;
        int right = 2;
        int n = arr.length;

        while(right < n){
            if(isOdd(left, right, arr)){
                return true;
            }

            left++;
            right++;
        }

        return false;
    }

    private boolean isOdd(int start, int end, int[] arr){
        boolean isOd = true;
        for(int i = start; i <= end; i++){
            if(arr[i] % 2 != 0){
                continue;
            }else{
                isOd = false;
            }
        }

        return isOd;
    }
}